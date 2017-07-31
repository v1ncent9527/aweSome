package com.v1ncent.awesome;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.v1ncent.awesome.base.BaseActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.frame_content)
    FrameLayout frameContent;
    @BindView(R.id.main_content)
    CoordinatorLayout mainContent;
    @BindView(R.id.navigation_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    private Context mContest;
    private ActionBarDrawerToggle mDrawerToggle;
    private View headerView;

    private ArrayList<String> itemsList = new ArrayList<>();

    @Override
    public void onClickListener(View v) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContest = this;

        toolbar.setTitle("CustomView");
        setSupportActionBar(toolbar);

        mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open,
                R.string.drawer_close);
        mDrawerToggle.syncState();
        drawerLayout.addDrawerListener(mDrawerToggle);

        navigationView.setItemTextColor(getResources().getColorStateList(R.drawable.nav_menu_text_color, null));
        navigationView.setItemIconTintList(getResources().getColorStateList(R.drawable.nav_menu_text_color, null));
        setupDrawerContent(navigationView);
        setUpProfileImage();

        /**
         * 默认选中第一页
         */
        intoMain(Arrays.asList(mContest.getResources().getStringArray(R.array.navigation_item_ui)), "navigation_item_ui");
    }


    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        toolbar.setTitle(menuItem.getTitle());
                        switch (menuItem.getItemId()) {
                            case R.id.navigation_item_ui:
                                intoMain(Arrays.asList(mContest.getResources().getStringArray(R.array.navigation_item_ui)), "navigation_item_ui");
                                break;
                            case R.id.navigation_item_recycler:
                                intoMain(Arrays.asList(mContest.getResources().getStringArray(R.array.navigation_item_recycler)), "navigation_item_recycler");
                                break;
                            case R.id.navigation_item_test:
                                intoMain(Arrays.asList(mContest.getResources().getStringArray(R.array.navigation_item_test)), "navigation_item_test");
                                break;
                            case R.id.navigation_item_photo:
                                intoMain(Arrays.asList(mContest.getResources().getStringArray(R.array.navigation_item_photo)), "navigation_item_photo");
                                break;
                            case R.id.navigation_item_new_technology:
                                intoMain(Arrays.asList(mContest.getResources().getStringArray(R.array.navigation_item_new_technology)), "navigation_item_new_technology");
                                break;
                            case R.id.navigation_item_viewpager:
                                intoMain(Arrays.asList(mContest.getResources().getStringArray(R.array.navigation_item_viewpager)), "navigation_item_viewpager");
                                break;
                            case R.id.navigation_item_anim:
                                intoMain(Arrays.asList(mContest.getResources().getStringArray(R.array.navigation_item_animation)), "navigation_item_animation");
                                break;
                        }
                        menuItem.setChecked(true);
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    private void setUpProfileImage() {
        headerView = navigationView.inflateHeaderView(R.layout.navigation_header);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_notifications:
                showToast("notifications");
                break;
            case R.id.action_search:
                showToast("search");
                break;
            case R.id.action_settings:
                showToast("settings");
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void intoMain(List<String> items, String tag) {
        itemsList.clear();
        itemsList.addAll(items);
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("itemsList", itemsList);
        bundle.putString("TAG", tag);
        MainFragment mainFragment = new MainFragment();
        mainFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, mainFragment).commit();
    }
}
