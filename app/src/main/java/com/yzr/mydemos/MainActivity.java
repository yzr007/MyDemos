package com.yzr.mydemos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Android-YZR on 2016/11/28.
 */

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.title_toolbar)
    TextView titleToolbar;
    @BindView(R.id.rightbtn_toolbar)
    TextView rightbtnToolbar;
    @BindView(R.id.tl_custom)
    Toolbar tlCustom;
    @BindView(R.id.ll_fragment)
    LinearLayout llFragment;
    @BindView(R.id.lv_menu)
    ListView lvMenu;
    @BindView(R.id.dl_left)
    DrawerLayout dlLeft;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
