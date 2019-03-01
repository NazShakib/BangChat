package com.example.bangchat;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import Fragments.Chat;
import Fragments.Friends;
import Fragments.Home;

public class pager extends FragmentStatePagerAdapter {

 private int count;

    private String[] tabTitles = new String[]{"Chat", "Friends", "Home"};

    public pager(FragmentManager fm,int count) {
        super(fm);
        this.count=count;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
            {
                Chat chat = new Chat();
                return chat;
            }
            case 1:
            {
                Friends friends = new Friends();
                return friends;
            }
            case 2:
            {
                Home home = new Home();
                return home;
            }
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    @Override
    public int getCount() {
        return count;
    }
}
