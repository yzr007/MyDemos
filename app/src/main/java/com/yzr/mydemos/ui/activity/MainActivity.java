package com.yzr.mydemos.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.yzr.mydemos.contract.MainContract;
import com.yzr.mydemos.model.HomeMenu;
import com.yzr.mydemos.presenter.MainPresenter;
import com.yzr.mydemos.ui.BaseActivity;
import com.yzr.mydemos.R;
import com.yzr.mydemos.ui.adapter.MenuAdapter;
import com.yzr.mydemos.ui.fragment.Demo0Fragment;
import com.yzr.mydemos.utils.ActivityUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Android-YZR on 2016/11/28.
 */

public class MainActivity extends BaseActivity implements MainContract.View{
    @BindView(R.id.title_toolbar)
    TextView titleToolbar;
    @BindView(R.id.tl_custom)
    Toolbar tlCustom;
    @BindView(R.id.ll_fragment)
    LinearLayout llFragment;
    @BindView(R.id.lv_menu)
    ListView lvMenu;
    @BindView(R.id.dl_left)
    DrawerLayout dlLeft;

    private MainContract.Presenter mPresenter;
    private ActionBarDrawerToggle mDrawerToggle;
    private MenuAdapter menuAdapter;
    private List<HomeMenu> homeMenuList;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        setTheme(R.style.StatusAndNavigationTranslucentTheme);
        mDrawerToggle = new ActionBarDrawerToggle(this,dlLeft,tlCustom,R.string.dl_open,R.string.dl_close);
        dlLeft.addDrawerListener(mDrawerToggle);
        titleToolbar.setText("首页");
        setSupportActionBar(tlCustom);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        homeMenuList = new ArrayList<>();
        menuAdapter = new MenuAdapter(this,homeMenuList);
        lvMenu.setAdapter(menuAdapter);
        lvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mPresenter.menuSelect(i,getSupportFragmentManager().findFragmentById(R.id.ll_fragment));
                dlLeft.closeDrawer(Gravity.LEFT);
            }
        });
        mPresenter.initMenu(homeMenuList);
        switchFragment(Demo0Fragment.newInstance());
    }

    @Override
    protected void bindPresenter() {
        new MainPresenter(this);
    }


    //onCreate之后执行 Activity彻底启动起来
    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        mDrawerToggle.syncState();
        super.onPostCreate(savedInstanceState, persistentState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mDrawerToggle.onOptionsItemSelected(item)){//查看源码可知，menuId为android.R.id.home，执行私有方法toggle();
         return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void updateMenu() {
        menuAdapter.notifyDataSetChanged();
    }

    @Override
    public void switchFragment(Fragment fragment) {
        ActivityUtils.replaceFragment(getSupportFragmentManager(),fragment,R.id.ll_fragment);
    }

}
