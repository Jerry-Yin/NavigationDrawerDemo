package com.example.jerryyin.navigationdrawerdemo.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jerryyin.navigationdrawerdemo.R;

import java.util.concurrent.TimeUnit;

/**
 * Created by JerryYin on 5/6/16.
 */
public class OtherFragment extends Fragment {


    /**
     * Constants
     */
    private View mContentView;
    private Activity mSelf;
    private TextView mTvLabel;

    public String mLabel;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (null != mContentView) {
            ViewGroup vg = (ViewGroup) mContentView.getParent();
            if (null != vg) {
                vg.removeView(mContentView);
            }
        } else {
            mContentView = inflater.inflate(R.layout.layout_fragment_other, container, false);
            mSelf = getActivity();
            setupViews();
        }
        return mContentView;
    }

    private void setupViews() {
        mLabel = this.getArguments().getString("label");
        mTvLabel = (TextView) mContentView.findViewById(R.id.tv_lable);
        if (!TextUtils.isEmpty(mLabel)) {
            mTvLabel.setText(mLabel);
        }
    }
}
