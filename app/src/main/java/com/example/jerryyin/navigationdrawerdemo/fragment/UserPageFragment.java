package com.example.jerryyin.navigationdrawerdemo.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jerryyin.navigationdrawerdemo.R;

/**
 * Created by JerryYin on 5/6/16.
 */
public class UserPageFragment extends Fragment {


    /**
     * Constants
     */
    private View mContentView;
    private Activity mSelf;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (null != mContentView) {
            ViewGroup vg = (ViewGroup) mContentView.getParent();
            if (null != vg) {
                vg.removeView(mContentView);
            }
        } else {
            mContentView = inflater.inflate(R.layout.layout_fragment_user_page, container, false);
            mSelf = getActivity();
            setupViews();
        }
        return mContentView;
    }


    private void setupViews() {

    }
}
