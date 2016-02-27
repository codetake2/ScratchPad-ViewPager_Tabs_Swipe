package com.test.app.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by vargh on 27-02-2016.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter{
    int mNumOfTabs;

    public ViewPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FragmentCategories fragmentCategories = new FragmentCategories();
                return fragmentCategories;
            case 1:
                FragmentProducts fragmentProducts = new FragmentProducts();
                return fragmentProducts;
            case 2:
                FragmentUsers fragmentUsers = new FragmentUsers();
                return fragmentUsers;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }


    //ToDo: Why the hell does this method set the Titles for the Tabs?
    //ToDo: this is commented out then the Tab titles are blank
    //ToDo: so this doesnt seem to be overwriting the .setText() method from the MainActivity class
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "SECTION 1";
            case 1:
                return "SECTION 2";
            case 2:
                return "SECTION 3";
        }
        return null;
    }
}
