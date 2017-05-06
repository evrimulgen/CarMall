package com.loading.carmall.bean;

import java.util.List;

/**
 * Created by 马小布 on 2017/5/2.
 */

public class CartGetbrandBean {

    /**
     * A : [{"id":13,"name":"阿尔法·罗密欧","Initials":"A","logo":"20170413\\d500be20f1db023ad53d1f95d3efee78.jpg","introduce":"阿尔法·罗密欧","hot":0},{"id":14,"name":"阿斯顿·马丁","Initials":"A","logo":"20170413\\8cc09ff18a04d4ef00164663f5c23352.jpg","introduce":"阿斯顿·马丁","hot":0},{"id":1,"name":"修改奥迪","Initials":"A","logo":"20170413\\13601c957e41643cd8725ba690e5f72d.jpg","introduce":"北京奥迪","hot":1}]
     * B : [{"id":4,"name":"宝马","Initials":"B","logo":"20170413\\29bd3f88661b9c82d052892c3e35bd3e.jpg","introduce":"北京宝马","hot":1},{"id":5,"name":"奔驰","Initials":"B","logo":"20170413\\97e9f2245c4bd50ee9fc11e8098d490f.jpg","introduce":"北京奔驰","hot":1},{"id":11,"name":"本田","Initials":"B","logo":"20170413\\a18c7e177cce2a172f4fc12e724b94f4.jpg","introduce":"本田","hot":1},{"id":8,"name":"宾利","Initials":"B","logo":"20170413\\f8360a316833428768717754e6b0f28c.jpg","introduce":"病例","hot":0},{"id":18,"name":"不知道","Initials":"B","logo":"20170428\\ff641f9b0e6152ff6f38115c480e4f21.jpg","introduce":"","hot":0}]
     * L : [{"id":10,"name":"兰博基尼","Initials":"L","logo":"20170413\\7541ddef6875ab8212328c8991ffef76.jpg","introduce":"兰博基尼","hot":0}]
     * M : [{"id":9,"name":"玛莎拉蒂","Initials":"M","logo":"20170413\\a1fe0f825a787a8e06891558566af311.jpg","introduce":"玛莎拉蒂","hot":1}]
     * R : [{"id":6,"name":"日产","Initials":"R","logo":"20170413\\709cfde368b430a06da534441dd91c39.jpg","introduce":"日产","hot":1}]
     * Z : [{"id":17,"name":"咋咋","Initials":"Z","logo":"20170421\\b26418f7fe8ce389d795226cf11122ff.jpg","introduce":"咋咋咋","hot":0}]
     */

    private List<ABean> A;
    private List<BBean> B;
    private List<LBean> L;
    private List<MBean> M;
    private List<RBean> R;
    private List<ZBean> Z;

    public void setA(List<ABean> A) {
        this.A = A;
    }

    public void setB(List<BBean> B) {
        this.B = B;
    }

    public void setL(List<LBean> L) {
        this.L = L;
    }

    public void setM(List<MBean> M) {
        this.M = M;
    }

    public void setR(List<RBean> R) {
        this.R = R;
    }

    public void setZ(List<ZBean> Z) {
        this.Z = Z;
    }

    public List<ABean> getA() {
        return A;
    }

    public List<BBean> getB() {
        return B;
    }

    public List<LBean> getL() {
        return L;
    }

    public List<MBean> getM() {
        return M;
    }

    public List<RBean> getR() {
        return R;
    }

    public List<ZBean> getZ() {
        return Z;
    }

    public static class ABean {
        /**
         * id : 13
         * name : 阿尔法·罗密欧
         * Initials : A
         * logo : 20170413\d500be20f1db023ad53d1f95d3efee78.jpg
         * introduce : 阿尔法·罗密欧
         * hot : 0
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

    public static class BBean {
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

    public static class LBean {
        /**
         * id : 10
         * name : 兰博基尼
         * Initials : L
         * logo : 20170413\7541ddef6875ab8212328c8991ffef76.jpg
         * introduce : 兰博基尼
         * hot : 0
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

    public static class MBean {
        /**
         * id : 9
         * name : 玛莎拉蒂
         * Initials : M
         * logo : 20170413\a1fe0f825a787a8e06891558566af311.jpg
         * introduce : 玛莎拉蒂
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

    public static class RBean {
        /**
         * id : 6
         * name : 日产
         * Initials : R
         * logo : 20170413\709cfde368b430a06da534441dd91c39.jpg
         * introduce : 日产
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

    public static class ZBean {
        /**
         * id : 17
         * name : 咋咋
         * Initials : Z
         * logo : 20170421\b26418f7fe8ce389d795226cf11122ff.jpg
         * introduce : 咋咋咋
         * hot : 0
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
