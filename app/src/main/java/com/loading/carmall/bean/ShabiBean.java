package com.loading.carmall.bean;

/**
 * Created by 马小布 on 2017/5/4.
 */

public class ShabiBean {

    /**
     * id : 13
     * name : 阿尔法·罗密欧
     * Initials : A
     * logo : http://47.92.30.24:8080/uploads/face/20170413/d500be20f1db023ad53d1f95d3efee78.jpg
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
