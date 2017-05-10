package com.loading.carmall.bean;

import com.loading.carmall.ui.weiget.reacyclerviewhelper.entity.SectionEntity;

import java.util.List;

/**
 * Created by maxia on 2017/5/9.
 */

public class SearchAtyResultBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * comment : 小型车 1.0T 2.0T
         * id : 1
         * logo : http://47.92.30.24:8080/uploads/face/20170427/fdb4123a256bfd56b18af776078be0ad.jpg
         * name : 本田8965号
         * pricd : 80-90万
         */

        private String comment;
        private int id;
        private String logo;
        private String name;
        private String pricd;

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPricd() {
            return pricd;
        }

        public void setPricd(String pricd) {
            this.pricd = pricd;
        }
    }
}
