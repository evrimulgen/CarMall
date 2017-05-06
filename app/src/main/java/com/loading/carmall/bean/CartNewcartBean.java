package com.loading.carmall.bean;

import java.util.List;

/**
 * Created by 马小布 on 2017/5/5.
 */

public class CartNewcartBean {

    /**
     * data : [{"modelid":26,"name":"2019款 4.7L Couoe","logo":"http://47.92.30.24:8080/uploads/face/20170427/560da4fef81f78892fff3f9565770dd2.jpg"},{"modelid":1,"name":"2017款 4.7L Couoe","logo":"http://47.92.30.24:8080/uploads/face/20170427/fdb4123a256bfd56b18af776078be0ad.jpg"},{"modelid":1,"name":"2016款 4.7L Couoe","logo":"http://47.92.30.24:8080/uploads/face/20170427/fdb4123a256bfd56b18af776078be0ad.jpg"},{"modelid":1,"name":"2019款 4.7L Couoe","logo":"http://47.92.30.24:8080/uploads/face/20170427/fdb4123a256bfd56b18af776078be0ad.jpg"},{"modelid":3,"name":"2017款 4.7L Couoe","logo":"http://47.92.30.24:8080/uploads/face/20170413/3c909e96e13a54f9156a6df36c0416cf.jpg"},{"modelid":1,"name":"2017款 4.7L Couoe","logo":"http://47.92.30.24:8080/uploads/face/20170427/fdb4123a256bfd56b18af776078be0ad.jpg"},{"modelid":1,"name":"2017款 4.7L Couoe","logo":"http://47.92.30.24:8080/uploads/face/20170427/fdb4123a256bfd56b18af776078be0ad.jpg"},{"modelid":1,"name":"2017款 4.7L Couoe","logo":"http://47.92.30.24:8080/uploads/face/20170427/fdb4123a256bfd56b18af776078be0ad.jpg"},{"modelid":3,"name":"2017款 4.7L Couoe","logo":"http://47.92.30.24:8080/uploads/face/20170413/3c909e96e13a54f9156a6df36c0416cf.jpg"},{"modelid":3,"name":"2017款 4.7L Couoe","logo":"http://47.92.30.24:8080/uploads/face/20170413/3c909e96e13a54f9156a6df36c0416cf.jpg"},{"modelid":3,"name":"2017款 4.7L Couoe","logo":"http://47.92.30.24:8080/uploads/face/20170413/3c909e96e13a54f9156a6df36c0416cf.jpg"},{"modelid":3,"name":"2017款 4.7L Couoe","logo":"http://47.92.30.24:8080/uploads/face/20170413/3c909e96e13a54f9156a6df36c0416cf.jpg"},{"modelid":3,"name":"2017款 4.7L Couoe","logo":"http://47.92.30.24:8080/uploads/face/20170413/3c909e96e13a54f9156a6df36c0416cf.jpg"},{"modelid":1,"name":"2017款 4.7L Couoe","logo":"http://47.92.30.24:8080/uploads/face/20170427/fdb4123a256bfd56b18af776078be0ad.jpg"},{"modelid":1,"name":"2017款 4.7L Couoe","logo":"http://47.92.30.24:8080/uploads/face/20170427/fdb4123a256bfd56b18af776078be0ad.jpg"}]
     */

    private List<DataBean> data;

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public List<DataBean> getData() {
        return data;
    }

    public static class DataBean {
        /**
         * modelid : 26
         * name : 2019款 4.7L Couoe
         * logo : http://47.92.30.24:8080/uploads/face/20170427/560da4fef81f78892fff3f9565770dd2.jpg
         */

        private int modelid;
        private String name;
        private String logo;

        public void setModelid(int modelid) {
            this.modelid = modelid;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public int getModelid() {
            return modelid;
        }

        public String getName() {
            return name;
        }

        public String getLogo() {
            return logo;
        }
    }
}
