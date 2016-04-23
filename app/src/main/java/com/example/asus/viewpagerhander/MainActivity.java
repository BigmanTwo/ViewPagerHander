package com.example.asus.viewpagerhander;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity  implements ViewPager.OnPageChangeListener{
    private ViewPager mViewPager;
    private ViewGroup mViewGroup;
    private int[] image={R.mipmap.water,R.mipmap.flower,R.mipmap.butterfly,R.mipmap.flower,R.mipmap.butterfly,R.mipmap.water};
    private ImageView[] mImagView;
    private ImageView[] tips;
    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
        int index=mViewPager.getCurrentItem();
            mViewPager.setCurrentItem(index+1);
            mHandler.sendEmptyMessageDelayed(1,2000);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager=(ViewPager)findViewById(R.id.view_pager);
        mViewGroup=(ViewGroup)findViewById(R.id.viewGroup);
        getImageView();
        getTips();
        MyAdapter adapter=new MyAdapter(mImagView);
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(mImagView.length*100);
        mViewPager.setOnPageChangeListener(this);
        mHandler.sendEmptyMessageDelayed(1,2000);
    }
    private void getImageView(){
        mImagView=new ImageView[image.length];
        for (int i=0;i<mImagView.length;i++){
            ImageView imageView=new ImageView(this);
            imageView.setBackgroundResource(image[i]);
            mImagView[i]=imageView;
        }
    }
    private void getTips(){
        tips=new ImageView[image.length];
        for (int i=0;i<mImagView.length;i++){
            ImageView imageView=new ImageView(this);
            tips[i]=imageView;
            if(i==0){
                tips[i].setBackgroundResource(R.mipmap.dui);
            }else{
                tips[i].setBackgroundResource(R.mipmap.fu);
            }
            LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            layoutParams.leftMargin=5;
            layoutParams.rightMargin=5;
            mViewGroup.addView(tips[i],layoutParams);

        }
    }
    private void itemSeclect(int item){
        for(int i=0;i<tips.length;i++){
            if(i==item){
                tips[i].setBackgroundResource(R.mipmap.dui);
            }else{
                tips[i].setBackgroundResource(R.mipmap.fu);
            }
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        //把ViewPager当前页数传到圆点选择器里面
                itemSeclect(position%tips.length);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
