package com.bhadresha.tejas.sannibh;

import android.app.Application;
import android.content.ClipData;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    EditText usernameet, passwordet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flag.f=0;
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawerlayout);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav123);
        navigationView.setNavigationItemSelectedListener(this);

        if(flag.f == 1){
            NavigationView nv = (NavigationView) findViewById(R.id.nav123);
            Menu menu = nv.getMenu();
            MenuItem item = menu.findItem(R.id.action_notification);
            item.setTitle("Log out");
        }
       // usernameet = (EditText)findViewById(R.id.user);
       // passwordet = (EditText)findViewById(R.id.pass);

    }

   /* @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    public void login(View view){

        String username = usernameet.getText().toString();
        String password = passwordet.getText().toString();
        String type = "login";
        backlog blog = new backlog(this);
        blog.execute(type, username, password);

    }*/



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (flag.f == 0) {

            getMenuInflater().inflate(R.menu.action_bar, menu);
            return super.onCreateOptionsMenu(menu);
        }

        return false;
    }

    public void home_activity(View view) {

        Intent i = new Intent(this,about.class);
        startActivity(i);
    }

    public void gallery(View view) {

        Intent i = new Intent(this,gallery.class);
        startActivity(i);
    }

    public void services(View view) {

        Intent i = new Intent(this,services.class);
        startActivity(i);
    }

    public void cppd(View view) {

        Intent i = new Intent(this,cppd.class);
        startActivity(i);
    }

    public void contact(View view) {

        Intent i = new Intent(this,contact.class);
        startActivity(i);
    }

    public void exit_app(View view){
        finishAffinity();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            moveTaskToBack(true);
            return true; // return
        }
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
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
        }else if (id == R.id.action_notification) {
            Intent i = new Intent(this,login_main.class);
            startActivity(i);
        }
        return true;
    }
}
