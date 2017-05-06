package com.loading.carmall.bean;

import java.util.List;

/**
 * Created by 马小布 on 2017/5/2.
 */

public class CartGethotbrandBean {

    /**
     * data : [{"id":4,"name":"宝马","Initials":"B","logo":"20170413\\29bd3f88661b9c82d052892c3e35bd3e.jpg","introduce":"北京宝马","hot":1},{"id":5,"name":"奔驰","Initials":"B","logo":"20170413\\97e9f2245c4bd50ee9fc11e8098d490f.jpg","introduce":"北京奔驰","hot":1},{"id":11,"name":"本田","Initials":"B","logo":"20170413\\a18c7e177cce2a172f4fc12e724b94f4.jpg","introduce":"本田","hot":1},{"id":9,"name":"玛莎拉蒂","Initials":"M","logo":"20170413\\a1fe0f825a787a8e06891558566af311.jpg","introduce":"玛莎拉蒂","hot":1},{"id":6,"name":"日产","Initials":"R","logo":"20170413\\709cfde368b430a06da534441dd91c39.jpg","introduce":"日产","hot":1},{"id":1,"name":"修改奥迪","Initials":"A","logo":"20170413\\13601c957e41643cd8725ba690e5f72d.jpg","introduce":"北京奥迪","hot":1}]
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
         * id : 4
         * name : 宝马
         * Initials : B
         * logo : 20170413\29bd3f88661b9c82d052892c3e35bd3e.jpg
         * introduce : 北京宝马
         * hot : 1
         */

        private int id;
        private String name;
        private String Initials;
        private String logo;
        private String introduce;
        private int hot;

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setInitials(String Initials) {
            this.Initials = Initials;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public void setIntroduce(String introduce) {
            this.introduce = introduce;
        }

        public void setHot(int hot) {
            this.hot = hot;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getInitials() {
            return Initials;
        }

        public String getLogo() {
            return logo;
        }

        public String getIntroduce() {
            return introduce;
        }

        public int getHot() {
            return hot;
        }
    }
}
