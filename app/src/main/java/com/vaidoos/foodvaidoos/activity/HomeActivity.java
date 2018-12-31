package com.vaidoos.foodvaidoos.activity;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.vaidoos.foodvaidoos.R;
import com.vaidoos.foodvaidoos.fragment.LoginFragment;
import com.vaidoos.foodvaidoos.fragment.RegistrationFragment;
import com.vaidoos.foodvaidoos.fragment.UserProfileFragment;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class HomeActivity extends AppCompatActivity {

    private final String TAG = "HomeActivity";

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

        final Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Home");
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

        loadFragment(new LoginFragment());

    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
