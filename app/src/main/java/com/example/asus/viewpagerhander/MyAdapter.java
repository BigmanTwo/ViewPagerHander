package com.example.asus.viewpagerhander;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Asus on 2016/4/22.
 */
public class MyAdapter extends PagerAdapter {
    private ImageView[] imageViews;

    public MyAdapter(ImageView[] imageViews) {
        this.imageViews = imageViews;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(View container, int position) {
        ((ViewPager)container).addView(imageViews[position%imageViews.length]);
        return imageViews[position%imageViews.length];
    }

    @Override
    public void destroyItem(View container, int position, Object object) {
        ((ViewPager)container).removeView(imageViews[position%imageViews.length]);
    }
}
