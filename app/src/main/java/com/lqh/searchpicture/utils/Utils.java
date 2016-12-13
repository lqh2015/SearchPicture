package com.lqh.searchpicture.utils;


import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.util.Log;

import com.lqh.searchpicture.APIStore;
import com.lqh.searchpicture.model.ImgClassifyModel;
import com.lqh.searchpicture.model.callbacks.ImgClassifyCallback;

import java.io.File;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by lqh on 2016/12/11.
 */
public class Utils {
    private static CompositeSubscription mCompositeSubscription;
    public static Retrofit creatRetrofit(){
        //创建interceptor，用于打印网络请求的信息，如请求行，请求体等信息
        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //用于网络请求
        OkHttpClient client= new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(APIStore.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }

    public static void registersubscribe(Observable observable, Subscriber subscriber){

        if(mCompositeSubscription==null){
            mCompositeSubscription=new CompositeSubscription();
        }
        mCompositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }

    public static File getDiskLruCachedir(Context context){
        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
            return context.getExternalCacheDir();
        }
        return context.getCacheDir();
    }

    public static int getAPPVersion(Context context){
            PackageInfo info = null;
            try {
                info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                return info.versionCode;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        return 1;
    }
}
