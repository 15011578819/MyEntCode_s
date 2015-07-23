package com.qf.administrator.myentcode_s;

import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawer = ((DrawerLayout) findViewById(R.id.drawer));
        toggle = new ActionBarDrawerToggle(this,drawer,0,0);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigation = (NavigationView)findViewById(R.id.navigation);
        navigation.setNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return toggle.onOptionsItemSelected(item)||super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        FragmentTransaction  transation=getSupportFragmentManager().beginTransaction();
        switch (menuItem.getItemId()){

            case R.id.md5:
                transation.replace(R.id.container,new MD5Fragment()).commit();
                break;
            case R.id.base64:
                transation.replace(R.id.container,new BASE64Fragment()).commit();
                break;
            case R.id.des:
                transation.replace(R.id.container,new DesFragmnet()).commit();
                break;


        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
