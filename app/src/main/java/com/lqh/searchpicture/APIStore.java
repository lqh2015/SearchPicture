package com.lqh.searchpicture;

import rx.Observable;

import com.lqh.searchpicture.model.ImgClassifyModel;
import com.lqh.searchpicture.model.beans.ImgClassify;
import com.lqh.searchpicture.model.beans.ImgList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by lqh on 2016/12/10.
 */
public interface  APIStore {

    String BASE_URL="http://www.tngou.net/tnfs/api/";


    /**
     * 加载图片类别
     * @return
     */
    @GET("classify")
    Observable<ImgClassify> loadImgClassify();

    /**
     * 加载首页信息
     * @return
     */
    @GET("list")
    Observable<ImgList> loadImgList();

}
