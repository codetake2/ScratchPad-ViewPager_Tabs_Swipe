package com.test.app.myapplication;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


//Just a dummy project to learn implementing Tabs with PageViewer and swiping functionality
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Start with the Tabs here
        TabLayout tab_layout = (TabLayout) findViewById(R.id.tabs);

        // ToDo : Not sure why the below .setText() methods doesnt set the Tab title
        tab_layout.addTab(tab_layout.newTab().setText("Categories"));
        tab_layout.addTab(tab_layout.newTab().setText("Products"));
        tab_layout.addTab(tab_layout.newTab().setText("Users"));
        tab_layout.setTabGravity(TabLayout.GRAVITY_FILL);

        // Set up the ViewPager with the view pager adapter.
        final ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(),tab_layout.getTabCount());
        final ViewPager view_pager = (ViewPager) findViewById(R.id.viewpager);
        view_pager.setAdapter(adapter);

        view_pager.addOnPageChangeListener
                (new TabLayout.TabLayoutOnPageChangeListener(tab_layout));

        tab_layout.setOnTabSelectedListener
                (new TabLayout.OnTabSelectedListener(){
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        view_pager.setCurrentItem(tab.getPosition());
                    }
                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                    }
                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {
                    }
                });

//        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
//        tabLayout.setupWithViewPager(view_pager);
          tab_layout.setupWithViewPager(view_pager);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
