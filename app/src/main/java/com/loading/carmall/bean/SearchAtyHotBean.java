package com.loading.carmall.bean;

import java.util.List;

/**
 * Created by maxia on 2017/5/9.
 */

public class SearchAtyHotBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * hot : 1
         * keyword : 奥拓
         */

        private int hot;
        private String keyword;

        public int getHot() {
            return hot;
        }

        public void setHot(int hot) {
            this.hot = hot;
        }

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }
    }
}
