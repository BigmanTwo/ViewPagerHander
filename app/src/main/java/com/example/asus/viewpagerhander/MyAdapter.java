package com.example.asus.viewpagerhander;

import android.content.Context;
import android.content.Intent;
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
    private Context mContext;


    public MyAdapter(ImageView[] imageViews, Context mContext) {
        this.imageViews = imageViews;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return imageViews.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(View container, int position) {
        ((ViewPager)container).addView(imageViews[position]);
        if (position==imageViews.length-1){
            imageViews[position].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(mContext,MainActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }
        return imageViews[position];
    }

    @Override
    public void destroyItem(View container, int position, Object object) {
        ((ViewPager)container).removeView(imageViews[position]);
    }
}
