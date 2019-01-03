package com.vaidoos.foodvaidoos.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.vaidoos.foodvaidoos.R;
import com.vaidoos.foodvaidoos.dialogs.DialogLogOut;
import com.vaidoos.foodvaidoos.fragment.LoginFragment;
import com.vaidoos.foodvaidoos.fragment.RegistrationFragment;
import com.vaidoos.foodvaidoos.fragment.UserProfileFragment;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class HomeActivity extends AppCompatActivity {

    private final String TAG = "HomeActivity";

    private Toolbar toolbar;

    private BottomNavigationBar bottomNavigationBar;


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setMode(BottomNavigationBar.BACKGROUND_STYLE_STATIC);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.img_hamburger_white_24dp));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*fragment = new NavigationFragment();
                setfragment(fragment);
                toggleNavIcon(NavOpen);*/
                Snackbar.make(toolbar,"Clicked",Snackbar.LENGTH_SHORT).show();
            }
        });



        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.bn_home, "Home"))
                .addItem(new BottomNavigationItem(R.drawable.bn_category, "Category"))
                .addItem(new BottomNavigationItem(R.drawable.bn_shopping_basket, "Cart"))
                .addItem(new BottomNavigationItem(R.drawable.bn_user, "User"))
                .setFirstSelectedPosition(0)
                .initialise();


        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener(){
            @Override
            public void onTabSelected(int position) {

                switch ( position ){
                    case 0:
                        loadFragment(new LoginFragment());
                        toolbar.setTitle("Home");
                        break;
                    case 1:
                        loadFragment(new RegistrationFragment());
                        toolbar.setTitle("Category");
                        break;
                    case 2:
                        Log.d(TAG, "onTabSelected: 3");
                        break;
                    case 3:
                        loadFragment(new UserProfileFragment());
                        toolbar.setTitle("Profile");
                        break;
                }
                Log.d(TAG, "onTabSelected: Selected: "+position);
            }
            @Override
            public void onTabUnselected(int position) {
                Log.d(TAG, "onTabSelected: UnSelected: "+position);
            }
            @Override
            public void onTabReselected(int position) {
                Log.d(TAG, "onTabSelected: ReSelected: "+position);
            }
        });

        loadFragment(new UserProfileFragment());

    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {

        menu.add(0, 1, 0, "Log Out")
                .setIcon(R.drawable.tb_logout)
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        Snackbar.make(toolbar,"CLicked",Snackbar.LENGTH_SHORT).show();

                        DialogLogOut dialogLogOut = new DialogLogOut(HomeActivity.this);
                        //dialogLogOut.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                        dialogLogOut.show();


                        /*SharedPrefClear(HomeActivity.this);

                        Toast.makeText(HomeActivity.this, "Logout successful", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                        finish();*/
                        return true;
                    }
                })
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

        return true;
    }
}
