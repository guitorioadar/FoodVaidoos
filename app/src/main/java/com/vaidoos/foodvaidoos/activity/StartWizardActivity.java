package com.vaidoos.foodvaidoos.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;
import com.vaidoos.foodvaidoos.R;
import com.vaidoos.foodvaidoos.adapter.ViewPagerWizardAdapter;
import com.vaidoos.foodvaidoos.model.ViewPagerWizardModel;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class StartWizardActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private ViewPagerWizardAdapter mViewPagerWizardAdapter;
    private ArrayList<ViewPagerWizardModel> mContents = new ArrayList<>();
    private DotsIndicator dotsIndicator;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_wizard);

        mViewPager = (ViewPager) findViewById(R.id.startWiazrdViewPager);
        dotsIndicator = (DotsIndicator) findViewById(R.id.dots_indicator);

        int images[] = {
                R.drawable.food_one,
                R.drawable.food_two,
                R.drawable.food_three
        };

        String titles[] = {
                "Order",
                "Pick Delivery Time",
                "Get Your Order"
        };

        String slogans[] = {
                "Order all you want from your favourite stores.",
                "Receive your order in less then 50 min Or pic a specific delivery time",
                "Real-time tracking will keep you posted about order progress."
        };

        for (int i = 0; i < images.length; i++) {
            ViewPagerWizardModel viewPagerWizardModel = new ViewPagerWizardModel();

            viewPagerWizardModel.images = images[i];
            viewPagerWizardModel.title = titles[i];
            viewPagerWizardModel.slogan = slogans[i];

            mContents.add(viewPagerWizardModel);
        }

        mViewPagerWizardAdapter = new ViewPagerWizardAdapter(mContents,this);
        //mViewPager.setPageTransformer(true, new ViewPagerStack());
        mViewPager.setAdapter(mViewPagerWizardAdapter);
        dotsIndicator.setViewPager(mViewPager);

    }

    private class ViewPagerStack implements ViewPager.PageTransformer {
        @Override
        public void transformPage(@NonNull View page, float position) {
            if (position >= 0){
                page.setScaleX(0.7f-0.05f * position);
                page.setScaleY(0.07f);
                page.setTranslationX(-page.getWidth() * position);
                page.setTranslationY(-30 * position);
            }
        }
    }
}
