package com.example.jerryyin.navigationdrawerdemo.activity;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.jerryyin.navigationdrawerdemo.R;
import com.example.jerryyin.navigationdrawerdemo.fragment.OtherFragment;
import com.example.jerryyin.navigationdrawerdemo.fragment.UserPageFragment;
import com.example.jerryyin.navigationdrawerdemo.view.RoundImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    /*
    Constants
     */
    private static final String TAG = "MainActivity";
//    @Bind(R.id.img_usr)
//    RoundImageView imgUsr;
//    @Bind(R.id.textView)
//    TextView textView;


    /*
    Views
     */
    private UserPageFragment mUserPageFragment;
    private OtherFragment mOtherFragment;

    private DrawerLayout mDrawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);

        initViews();

    }

    private void initViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
//        navigationView.setClickable(true);
        View headView = navigationView.getHeaderView(0);
        headView.findViewById(R.id.img_usr).setOnClickListener(this);
        headView.findViewById(R.id.tv_url).setOnClickListener(this);
//        View headView = LayoutInflater.from(this).inflate(R.layout.nav_header_main, null);
//        headView.findViewById(R.id.img_usr).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                changeFragment(getmUserPageFragment(), false);
//                Log.d(TAG, "HELLO CLICK IMG");
//            }
//        });
//
//        headView.findViewById(R.id.tv_url).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                changeFragment(getmUserPageFragment(), false);
//                Log.d(TAG, "HELLO CLICK TextView");
//            }
//        });
//
//        Log.d(TAG, "headView.imageView = " + headView.findViewById(R.id.img_usr));
//        Log.d(TAG, "headView.TextView = "+headView.findViewById(R.id.tv_url));
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            changeFragment(getOtherFragment((String) item.getTitle()), false);
        } else if (id == R.id.nav_gallery) {
            changeFragment(getOtherFragment((String) item.getTitle()), false);
        } else if (id == R.id.nav_slideshow) {
            changeFragment(getOtherFragment((String) item.getTitle()), false);
        } else if (id == R.id.nav_manage) {
            changeFragment(getOtherFragment((String) item.getTitle()), false);
        } else if (id == R.id.nav_share) {
            changeFragment(getOtherFragment((String) item.getTitle()), false);
        } else if (id == R.id.nav_send) {
            changeFragment(getOtherFragment((String) item.getTitle()), false);
        }

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public Fragment getmUserPageFragment() {
        if (mUserPageFragment == null) {
            mUserPageFragment = new UserPageFragment();
        }
        return mUserPageFragment;
    }

    public Fragment getOtherFragment(String label){
        mOtherFragment = null;
        if (mOtherFragment == null){
            mOtherFragment = new OtherFragment();
        }
        Bundle bundle = new Bundle();
        bundle.putString("label",label);
        mOtherFragment.setArguments(bundle);
        return mOtherFragment;
    }

    /**
     * 替换fragment
     */
    public void changeFragment(Fragment f, boolean init) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_root, f);
        if (!init) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_usr:
                changeFragment(getmUserPageFragment(), false);
                Log.d(TAG, "HELLO CLICK IMG");
                mDrawer.closeDrawer(GravityCompat.START);
                break;

            case R.id.tv_url:


                mDrawer.closeDrawer(GravityCompat.START);
                break;

            default:
                break;
        }
    }
}
