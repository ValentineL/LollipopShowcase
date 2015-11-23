package com.mikepenz.lollipopshowcase;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import com.mikepenz.lollipopshowcase.adapter.CardAdapter;
import com.mikepenz.lollipopshowcase.entity.CardInfo;
import com.mikepenz.lollipopshowcase.itemanimator.CustomItemAnimator;
/*import com.mikepenz.lollipopshowcase.util.UploadHelper;*/
import com.mikepenz.materialdrawer.Drawer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends BaseActivity {
    /*private static final int DRAWER_ITEM_SWITCH = 1;
    private static final int DRAWER_ITEM_OPEN_SOURCE = 10;*/

    private List<CardInfo> applicationList = new ArrayList<CardInfo>();

    private Drawer drawer;

    private CardAdapter mAdapter;
    /*private FloatingActionButton mFabButton;*/
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ProgressBar mProgressBar;
    private DBHelper db;
    private Cursor cursorForId;
    private CardDetails ID;

    /*private static UploadHelper.UploadComponentInfoTask uploadComponentInfoTask = null;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Handle Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        final SharedPreferences pref = getSharedPreferences("com.mikepenz.applicationreader", 0);

        /*drawer = new DrawerBuilder(this)
                .withToolbar(toolbar)
                *//*.addDrawerItems(
                        new SwitchDrawerItem().withOnCheckedChangeListener(new OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(IDrawerItem drawerItem, CompoundButton compoundButton, boolean b) {
                                SharedPreferences.Editor editor = pref.edit();
                                editor.putBoolean("autouploadenabled", b);
                                editor.apply();
                            }
                        }).withName(R.string.drawer_switch).withChecked(pref.getBoolean("autouploadenabled", false))
                ).addStickyDrawerItems(
                        new SecondaryDrawerItem()
                                .withName(R.string.drawer_opensource)
                                .withIdentifier(DRAWER_ITEM_OPEN_SOURCE)
                                .withIcon(FontAwesome.Icon.faw_github)
                                .withCheckable(false)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(AdapterView<?> adapterView, View view, int i, long l, IDrawerItem drawerItem) {
                        if (drawerItem.getIdentifier() == DRAWER_ITEM_OPEN_SOURCE) {
                            new LibsBuilder()
                                    .withFields(R.string.class.getFields())
                                    .withVersionShown(true)
                                    .withLicenseShown(true)
                                    .withActivityTitle(getString(R.string.drawer_opensource))
                                    .withActivityStyle(Libs.ActivityStyle.LIGHT_DARK_TOOLBAR)
                                    .start(MainActivity.this);
                        }
                        return false;
                    }
                })*//*

                .withSavedInstance(savedInstanceState)
                .build();*/

        // Handle ProgressBar
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        // Fab Button
        /*mFabButton = (FloatingActionButton) findViewById(R.id.fab_normal);
        mFabButton.setImageDrawable(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_file_upload).color(Color.WHITE).actionBar());
        mFabButton.setOnClickListener(fabClickListener);*/

        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new CustomItemAnimator());
        //mRecyclerView.setItemAnimator(new ReboundItemAnimator());

        mAdapter = new CardAdapter(new ArrayList<CardInfo>(), R.layout.row_application, MainActivity.this);
        mRecyclerView.setAdapter(mAdapter);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
        mSwipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.theme_accent));
        mSwipeRefreshLayout.setRefreshing(true);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new InitializeApplicationsTask().execute();
            }
        });

        new InitializeApplicationsTask().execute();

        /*if (savedInstanceState != null) {
            if (uploadComponentInfoTask != null) {
                if (uploadComponentInfoTask.isRunning) {
                    uploadComponentInfoTask.showProgress(this);
                }
            }
        }*/

        //show progress
        mRecyclerView.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.VISIBLE);

//        try {
//
//            db.createDataBase();
//
//        }
//        catch (IOException ioe) {
//
//            throw new Error("Unable to create database");
//
////        }
//
//        try {
//
//            db.openDataBase();
//
//        }catch(SQLException sqle){
//
//            throw sqle;
//
//        }
//
//        db = new DBHelper(getApplicationContext());
//        cursorForId = db.getCardId();
//        cursorForId.moveToFirst();

        /*SearchResponse response;
        JSONArray json = new JSONArray(response);*/




    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (drawer != null) {
            outState = drawer.saveInstanceState(outState);
        }
        super.onSaveInstanceState(outState);
    }

    /**
     * onDestroy make sure we stop the upload
     */
    @Override
    protected void onDestroy() {
        /*UploadHelper.getInstance(null, null).destroy();*/
        super.onDestroy();
    }

    /**
     * sample onClickListener with an AsyncTask as action
     */
    /*View.OnClickListener fabClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            uploadComponentInfoTask = UploadHelper.getInstance(MainActivity.this, applicationList).uploadAll();
        }
    };*/

    /**
     * helper class to start the new detailActivity animated
     *
     * @param appInfo
     * @param appIcon
     */
    public void animateActivity(CardInfo appInfo, View appIcon) {
        Intent i = new Intent(this, DetailActivity.class);
        i.putExtra("appInfo", appInfo.getComponentName());

        /*ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, Pair.create((View) mFabButton, "fab"), Pair.create(appIcon, "appIcon"));*/
        startActivity(i);
    }


    /**
     * A simple AsyncTask to load the list of applications and display them
     */
    private class InitializeApplicationsTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            mAdapter.clearCards();
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            applicationList.clear();

            //Query the applications
            final Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
            mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);

            List<ResolveInfo> ril = getPackageManager().queryIntentActivities(mainIntent, 0);
            for (ResolveInfo ri : ril) {
                applicationList.add(new CardInfo(MainActivity.this, ri));
            }
            Collections.sort(applicationList);

            for (CardInfo appInfo : applicationList) {
                //load icons before shown. so the list is smoother
                appInfo.getIcon();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            //handle visibility
            mRecyclerView.setVisibility(View.VISIBLE);
            mProgressBar.setVisibility(View.GONE);

            //set data for list
            mAdapter.addCards(applicationList);
            mSwipeRefreshLayout.setRefreshing(false);

            super.onPostExecute(result);
        }
    }
}
