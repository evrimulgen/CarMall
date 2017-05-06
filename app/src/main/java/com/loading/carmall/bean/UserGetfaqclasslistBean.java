package com.loading.carmall.bean;

import java.util.List;

/**
    *Created by 马小布 on 2017/5/5.
    *Project : recycler adapter封装
    *Program Name :  com.loading.carmall.bean.UserGetfaqclasslistBean.java
    *Author :马庆龙 on 2017/5/5 8:58
    *email:maxiaobu1999@163.com
    *功能：获取常见问题分类接口
    *伪码：
    *待完成：
*/
public class UserGetfaqclasslistBean {

    /**
     * data : [{"id":1,"name":"账号问题","status":1,"sort":50},{"id":2,"name":"订单问题","status":1,"sort":50}]
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
         * id : 1
         * name : 账号问题
         * status : 1
         * sort : 50
         */

        private int id;
        private String name;
        private int status;
        private int sort;

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getStatus() {
            return status;
        }

        public int getSort() {
            return sort;
        }
    }
}
