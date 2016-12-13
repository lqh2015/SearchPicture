package com.lqh.searchpicture.model.beans;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lqh on 2016/12/10.
 */
public class ImgClassify implements Serializable{

    private boolean status;

    public ArrayList<Classify> getTngou() {
        return tngou;
    }

    public void setTngou(ArrayList<Classify> tngou) {
        this.tngou = tngou;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private ArrayList<Classify> tngou;

    public class Classify implements Serializable{
        private int id;
        private String name;
        private String title;
        private String keywords;
        private String description;
        private int seq;//排序 从0。。。。10开始

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getKeywords() {
            return keywords;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getSeq() {
            return seq;
        }

        public void setSeq(int seq) {
            this.seq = seq;
        }
    }
}

