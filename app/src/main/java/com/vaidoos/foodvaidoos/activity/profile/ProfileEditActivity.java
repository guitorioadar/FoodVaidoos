package com.vaidoos.foodvaidoos.activity.profile;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.vaidoos.foodvaidoos.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ProfileEditActivity extends AppCompatActivity {

    private Toolbar toolbarProfileEdit;


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);

        toolbarProfileEdit = findViewById(R.id.toolbarProfileEdit);
        toolbarProfileEdit.setTitle("");
        setSupportActionBar(toolbarProfileEdit);
        toolbarProfileEdit.setNavigationIcon(getResources().getDrawable(R.drawable.left_arrow));
        toolbarProfileEdit.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu) {

        menu.add(0, 1, 0, "Log Out")
                .setIcon(R.drawable.tb_logout)
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        Snackbar.make(toolbarProfileEdit,"Clicked",Snackbar.LENGTH_SHORT).show();

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
