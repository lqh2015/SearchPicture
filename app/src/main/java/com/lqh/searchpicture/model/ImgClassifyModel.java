package com.lqh.searchpicture.model;

import android.util.Log;

import com.jakewharton.disklrucache.DiskLruCache;
import com.jude.beam.model.AbsModel;
import com.lqh.searchpicture.APIStore;
import com.lqh.searchpicture.MyApplication;
import com.lqh.searchpicture.model.beans.ImgClassify;
import com.lqh.searchpicture.presenter.MainPresenter;
import com.lqh.searchpicture.utils.Utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by lqh on 2016/12/10.
 */
public class ImgClassifyModel extends AbsModel {
    private static final String TAG="ImgClassifyModel";
    private APIStore apiStore= Utils.creatRetrofit().create(APIStore.class);
    private static MainPresenter mainpresenter;
    private  DiskLruCache diskLruCache=null;
    public static ImgClassifyModel getInstance(MainPresenter presenter){
        mainpresenter=presenter;
        return getInstance(ImgClassifyModel.class);
    }

    public void loadImgClassify(){
        final File dir=Utils.getDiskLruCachedir(MyApplication.getInstance());
        int appVerdion=Utils.getAPPVersion(MyApplication.getInstance());
        try {
            diskLruCache=DiskLruCache.open(dir,appVerdion,1,4*1024*1024);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Observable<ImgClassify> classifyObservable = apiStore.loadImgClassify();
        Utils.registersubscribe(classifyObservable, new Subscriber<ImgClassify>() {
            @Override
            public void onCompleted() {
                Log.e(TAG,"onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG,"onError");
                e.printStackTrace();
                try {
                    DiskLruCache.Snapshot snapShot = diskLruCache.get("classify");
                    if(snapShot!=null){
                        InputStream is = snapShot.getInputStream(0);
                        ObjectInputStream ois=new ObjectInputStream(is);
                        ImgClassify imgClassify = (ImgClassify) ois.readObject();
                        ArrayList<ImgClassify.Classify> classifies = imgClassify.getTngou();
                        ArrayList<String> tabTitles=new ArrayList<String>();
                        for(ImgClassify.Classify classify:classifies){
                            tabTitles.add(classify.getName());
                        }
//                        mainpresenter.setTablayoutTitle(tabTitles);
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }

            @Override
            public void onNext(ImgClassify imgClassify) {
                Log.e(TAG,"onNext");
                ArrayList<ImgClassify.Classify> classifies = imgClassify.getTngou();
                ArrayList<String> tabTitles=new ArrayList<String>();
                for(ImgClassify.Classify classify:classifies){
                    tabTitles.add(classify.getName());
                }
                tabTitles.add(0,"首页");
//                mainpresenter.setTablayoutTitle(tabTitles);
                ImgListModel.getInstance(mainpresenter,tabTitles).loadImgList();
                DiskLruCache.Editor editor=null;
                try {
                    editor = diskLruCache.edit("classify");
                    OutputStream outputStream = editor.newOutputStream(0);
                    ObjectOutputStream obj=new ObjectOutputStream(outputStream);
                    obj.writeObject(imgClassify);
                    obj.flush();
                    editor.commit();
                    diskLruCache.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                    if(editor!=null){
                        try {
                            editor.abort();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        editor=null;
                    }
                }
            }
        });
    }
}
