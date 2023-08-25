package com.jtech.newapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.jtech.newapp.adapter.CategoryFragmentPagerAdapter;
import com.jtech.newapp.utils.Constants;
import com.jtech.newapp.utils.DatabaseHelper;
import androidx.appcompat.widget.SearchView;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ViewPager viewPager;
    private ProgressDialog pd;
    private  SearchView searchView;
    CategoryFragmentPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Getting Database Helper
        DatabaseHelper myDbHelper = new DatabaseHelper(getApplicationContext());
        try {
            //Copying Database from Raw Folder
            myDbHelper.createDataBase();
        } catch (IOException ioe) {
            //Cant Create Database
            Toast.makeText(getApplicationContext(),"Unable to create tarot database",Toast.LENGTH_SHORT).show();
            throw new Error("Unable to create database");
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // Find the view pager that will allow the user to swipe between fragments
        viewPager = findViewById(R.id.viewpager);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
        // Set gravity for tab bar
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        NavigationView navigationView = findViewById(R.id.nav_view);
        assert navigationView != null;
        navigationView.setNavigationItemSelectedListener(this);

        // Set the default fragment when starting the app
        onNavigationItemSelected(navigationView.getMenu().getItem(0).setChecked(true));

        // Set category fragment pager adapter
        pagerAdapter =
                new CategoryFragmentPagerAdapter(this, getSupportFragmentManager());
        // Set the pager adapter onto the view pager
        viewPager.setAdapter(pagerAdapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // Switch Fragments in a ViewPager on clicking items in Navigation Drawer
        if (id == R.id.nav_home) {
            viewPager.setCurrentItem(Constants.HOME);
        } else if (id == R.id.nav_world) {
            viewPager.setCurrentItem(Constants.WORLD);
        } else if (id == R.id.nav_science) {
            viewPager.setCurrentItem(Constants.SCIENCE);
        } else if (id == R.id.nav_sport) {
            viewPager.setCurrentItem(Constants.SPORT);
        } else if (id == R.id.nav_environment) {
            viewPager.setCurrentItem(Constants.ENVIRONMENT);
        } else if (id == R.id.nav_society) {
            viewPager.setCurrentItem(Constants.SOCIETY);
        } else if (id == R.id.nav_fashion) {
            viewPager.setCurrentItem(Constants.FASHION);
        } else if (id == R.id.nav_business) {
            viewPager.setCurrentItem(Constants.BUSINESS);
        } else if (id == R.id.nav_culture) {
            viewPager.setCurrentItem(Constants.CULTURE);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    // Initialize the contents of the Activity's options menu
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the Options Menu we specified in XML
        getMenuInflater().inflate(R.menu.main, menu);
        SearchView searchView  =(SearchView) menu.findItem(R.id.search).getActionView();
        EditText editText = (EditText) searchView.findViewById(androidx.appcompat.R.id.search_src_text);
        editText.setTextColor(getResources().getColor(R.color.black));
        editText.setHintTextColor(getResources().getColor(R.color.black));
        ImageView searchClear = searchView.findViewById(androidx.appcompat.R.id.search_close_btn);
        searchClear.setImageResource(R.drawable.ic_close);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Perform search operation here
                performSearch(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Perform search operation as the query text changes
                performSearch(newText);
                return true;
            }
        });
        // Handle search cancel button click
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                clearSearch();
                return false;
            }
        });

        return true;
    }
    private void performSearch(String data) {
        // This is where you handle the search query and display the results
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("query", data.replaceAll("[-+.^:,]",""));
        editor.commit();
        pagerAdapter.notifyDataSetChanged();
        viewPager.setCurrentItem(Constants.SEARCH);
    }

    private void clearSearch() {
        // This is where you clear the search query and restore the previous view
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("query", "");
        editor.commit();
    }
    @Override
    // This method is called whenever an item in the options menu is selected.
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent settingsIntent = new Intent(this, SettingsActivity.class);
            startActivity(settingsIntent);
            return true;
        }
        if(id== R.id.action_tarrots){
            pd = ProgressDialog.show(MainActivity.this, "", "質問を考えてください",
                    true, false);
            pd.show();
            new CountDownTimer(600, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    //this will be done every 1000 milliseconds ( 1 seconds )
                    Toast.makeText(getApplicationContext(),"終わるまで質問を考えてください",Toast.LENGTH_LONG).show();
                    long progress = (600 - millisUntilFinished) / 1000;
                    pd.setProgress(Integer.parseInt(progress+""));

                }

                @Override
                public void onFinish() {
                    //the progressBar will be invisible after 60 000 miliseconds ( 1 minute)
                    pd.dismiss();
                    Intent myIntent = new Intent(MainActivity.this, DrawCards.class);
                    //Optional parameters
                    MainActivity.this.startActivity(myIntent);
                }

            }.start();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
