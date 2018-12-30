package com.vaidoos.foodvaidoos.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vaidoos.foodvaidoos.R;
import com.vaidoos.foodvaidoos.model.ViewPagerWizardModel;

import java.util.List;

public class ViewPagerWizardAdapter extends PagerAdapter {

    private List<ViewPagerWizardModel> contents;
    private Context context;

    public ViewPagerWizardAdapter(List<ViewPagerWizardModel> contents, Context context) {
        this.contents = contents;
        this.context = context;
    }

    @Override
    public int getCount() {
        return contents.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.view_content_wizard, null);

        container.addView(view);

        ImageView foodImageViewPager = view.findViewById(R.id.foodImageViewPager);
        foodImageViewPager.setImageResource(contents.get(position).getImages());

        TextView tvWizardTitle = view.findViewById(R.id.tvWizardTitle);
        tvWizardTitle.setText(contents.get(position).getTitle());

        TextView tvWizardSlogan = view.findViewById(R.id.tvWizardSlogan);
        tvWizardSlogan.setText(contents.get(position).getSlogan());



        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
