package com.lqh.searchpicture.model.beans;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lqh on 2016/12/12.
 */
public class ImgList implements Serializable {
    private boolean status;
    private int total;
    private List<ImgListDec> tngou;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<ImgListDec> getTngou() {
        return tngou;
    }

    public void setTngou(List<ImgListDec> tngou) {
        this.tngou = tngou;
    }

    public static class ImgListDec implements Serializable{
        private int id;
        private int  galleryclass ;//          图片分类
        private String title     ;//          标题
        private String img     ;//          图库封面
        private int count     ;//          访问数
        private int rcount     ;//           回复数
        private int fcount     ;//          收藏数
        private int size     ;//      图片多少张

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getGalleryclass() {
            return galleryclass;
        }

        public void setGalleryclass(int galleryclass) {
            this.galleryclass = galleryclass;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getRcount() {
            return rcount;
        }

        public void setRcount(int rcount) {
            this.rcount = rcount;
        }

        public int getFcount() {
            return fcount;
        }

        public void setFcount(int fcount) {
            this.fcount = fcount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }
}
