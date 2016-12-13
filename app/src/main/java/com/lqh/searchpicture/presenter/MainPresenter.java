package com.lqh.searchpicture.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;

import com.jude.beam.expansion.list.BeamListActivityPresenter;
import com.lqh.searchpicture.model.ImgClassifyModel;
import com.lqh.searchpicture.view.activity.MainActivity;

/**
 * Created by lqh on 2016/12/10.
 */
public class MainPresenter extends BeamListActivityPresenter<MainActivity,ImgClassifyModel> {

    private MainActivity mView;
    private ImgClassifyModel mModel;

    @Override
    protected void onCreate(@NonNull MainActivity view, Bundle savedState) {
        super.onCreate(view, savedState);
        mView=view;
        mModel=ImgClassifyModel.getInstance(this);
    }

    @Override
    public void onLoadMore() {
        super.onLoadMore();
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
    }

    public void loadImgClassify(){
        mModel.loadImgClassify();
    }

    public void setViewPageAdapter(PagerAdapter adapter){
        mView.setViewPager(adapter);
    }
}
