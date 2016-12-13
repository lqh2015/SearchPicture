package com.lqh.searchpicture.model;

import com.jude.beam.model.AbsModel;
import com.lqh.searchpicture.APIStore;
import com.lqh.searchpicture.model.beans.ImgList;
import com.lqh.searchpicture.presenter.MainPresenter;
import com.lqh.searchpicture.presenter.adapter.ContentViewPagerAdapter2;
import com.lqh.searchpicture.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by lqh on 2016/12/12.
 */
public class ImgListModel extends AbsModel {
    private static MainPresenter mPresenter;
    private static List<String> mTabTitles;
    public static ImgListModel getInstance(MainPresenter presenter,List<String> tabTitles){
        mPresenter=presenter;
        mTabTitles=tabTitles;
        return getInstance(ImgListModel.class);
    }

    /**
     * 获取首页信息
     */
    public void loadImgList(){
        APIStore apiStore = Utils.creatRetrofit().create(APIStore.class);
        Observable<ImgList> imgListObservable = apiStore.loadImgList();
        Utils.registersubscribe(imgListObservable, new Subscriber<ImgList>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ImgList imgList) {
                List<ImgList.ImgListDec> imgListDecs = imgList.getTngou();
                List<String> decs=new ArrayList<String>();
//                for(ImgList.ImgListDec imgListDec:imgListDecs){
//                    String dec=imgListDec.getTitle();
//                    decs.add(dec);
//                }
                for(int i=0;i<7;i++){
                    String dec=imgListDecs.get(i).getTitle();
                    decs.add(dec);
                }
                ContentViewPagerAdapter2 adapter2=new ContentViewPagerAdapter2(decs,mTabTitles);
                mPresenter.setViewPageAdapter(adapter2);
            }
        });
    }
}
