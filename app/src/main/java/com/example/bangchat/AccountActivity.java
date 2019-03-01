package com.example.bangchat;

import android.app.ActionBar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

public class AccountActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    private TabLayout tabLayout;
    private ViewPager pagers;
    private Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);


        tabLayout = findViewById(R.id.tabLayout);
        pagers = findViewById(R.id.pager);
        toolbar = findViewById(R.id.toolbarAccount);
        toolbar.setTitle("Bang Chat");
        setSupportActionBar(toolbar);


        tabLayout.addTab(tabLayout.newTab().setText("Chat"));
        tabLayout.addTab(tabLayout.newTab().setText("Friends"));
        tabLayout.addTab(tabLayout.newTab().setText("Home"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        pager adapter = new pager(getSupportFragmentManager(),tabLayout.getTabCount());
        pagers.setAdapter(adapter);
        tabLayout.setupWithViewPager(pagers);
        tabLayout.addOnTabSelectedListener(this);



    }
 //Tab Layout
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        pagers.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
    }
    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


    //toolbar

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
