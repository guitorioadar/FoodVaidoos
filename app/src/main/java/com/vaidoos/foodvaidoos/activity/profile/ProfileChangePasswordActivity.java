package com.vaidoos.foodvaidoos.activity.profile;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.vaidoos.foodvaidoos.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ProfileChangePasswordActivity extends AppCompatActivity {


    private Toolbar toolbarChangePassword;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_change_password);
        initializeView();

        toolbarChangePassword.setTitle("");
        setSupportActionBar(toolbarChangePassword);
        toolbarChangePassword.setNavigationIcon(getResources().getDrawable(R.drawable.left_arrow));
        toolbarChangePassword.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

    }

    private void initializeView() {
        toolbarChangePassword = findViewById(R.id.toolbarChangePassword);
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu) {
        menu.add(0, 1, 0, "Log Out")
                .setIcon(R.drawable.tb_logout)
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        Snackbar.make(toolbarChangePassword,"Clicked",Snackbar.LENGTH_SHORT).show();

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
