package com.bhadresha.tejas.sannibh;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class finishing_school extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finishing_school);
        setTitle("Finishing School");

        mDrawerLayout = (DrawerLayout)findViewById(R.id.finishing_school_layout);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_finishing_school);
        navigationView.setNavigationItemSelectedListener(this);
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        View view = null;
        if (id == R.id.nav_about) {
            Intent i = new Intent(this,about.class);
            startActivity(i);
        } else if (id == R.id.nav_services) {
            Intent i = new Intent(this,services.class);
            startActivity(i);
        } else if (id == R.id.nav_cppd) {
            Intent i = new Intent(this,cppd.class);
            startActivity(i);
        } else if (id == R.id.nav_gallery) {
            Intent i = new Intent(this,gallery.class);
            startActivity(i);
        } else if (id == R.id.nav_contact) {
            Intent i = new Intent(this,contact.class);
            startActivity(i);
        } else if (id == R.id.nav_exit) {
            finishAffinity();
        }
        return true;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            this.finish();
            Intent i = new Intent(this,services.class);
            startActivity(i);
            return true; // return
        }
        return false;
    }
}
