package com.lqh.searchpicture.presenter.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.EasyRecyclerView;

import java.util.List;

/**
 * Created by lqh on 2016/12/12.
 */
public class ContentViewPagerAdapter extends PagerAdapter {
    private List<EasyRecyclerView> easyRecyclerViews;
    public ContentViewPagerAdapter(List<EasyRecyclerView> easyRecyclerViews){
        this.easyRecyclerViews=easyRecyclerViews;
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
        EasyRecyclerView easyRecyclerView = easyRecyclerViews.get(position);
        container.addView(easyRecyclerView);
        return easyRecyclerView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(easyRecyclerViews.get(position));
        super.destroyItem(container, position, object);
    }
}
