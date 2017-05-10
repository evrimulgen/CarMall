package com.loading.carmall.bean;

import java.util.List;

/**
 * Created by maxia on 2017/5/10.
 */

public class ArticlegetbannnerBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 12
         * title : 首页banner1
         * url :
         * image : http://47.92.30.24:8080/uploads/images/20170509/67773784644856781de7194b008cca10.jpg
         */

        private int id;
        private String title;
        private String url;
        private String image;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
