package com.lqh.searchpicture.presenter.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lqh on 2016/12/12.
 */
public class ContentViewPagerAdapter2 extends PagerAdapter {
    private List<String> easyRecyclerViews;
    private List<String> titles;
    public ContentViewPagerAdapter2(List<String> easyRecyclerViews,List<String> titles){
        this.easyRecyclerViews=easyRecyclerViews;
        this.titles=titles;
    }

    @Override
    public int getCount() {
        return easyRecyclerViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        String easyRecyclerView = easyRecyclerViews.get(position);
        TextView textView=new TextView(container.getContext());
        textView.setText(easyRecyclerView);
        container.addView(textView);
        return textView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
//        super.destroyItem(container, position, object);
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return titles.get(position);
    }
}
