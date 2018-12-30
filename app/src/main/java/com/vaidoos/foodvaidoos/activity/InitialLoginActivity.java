package com.vaidoos.foodvaidoos.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.vaidoos.foodvaidoos.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class InitialLoginActivity extends AppCompatActivity {

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnEmailOption(View view) {
        startActivity(new Intent(this,LoginRegistrationActivity.class));
    }
}
