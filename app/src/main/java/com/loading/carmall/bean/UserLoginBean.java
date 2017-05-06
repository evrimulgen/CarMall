package com.loading.carmall.bean;

/**
 * Created by 马小布 on 2017/5/5.
 */
@SuppressWarnings("all")
public class UserLoginBean {

    /**
     * data : {"id":212067,"nickname":"马小布"}
     */

    private DataBean data;

    public void setData(DataBean data) {
        this.data = data;
    }

    public DataBean getData() {
        return data;
    }

    public static class DataBean {
        /**
         * id : 212067
         * nickname : 马小布
         */

        private int id;
        private String nickname;

        public void setId(int id) {
            this.id = id;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getId() {
            return id;
        }

        public String getNickname() {
            return nickname;
        }
    }
}
