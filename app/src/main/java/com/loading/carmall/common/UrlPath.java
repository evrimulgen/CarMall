package com.loading.carmall.common;


public class UrlPath {
    private static final String BASE_URL = "http://47.92.30.24:8080/api/";
    /**
     * 登陆接口
     * User-login
     * {"data":{"id":212067,"nickname":"马小布"}}
     */
    public static final String USER_LOGIN = BASE_URL + "user/login";
    /**
     * 获取验证码接口
     * User-sendsmscode
     * http://47.92.30.24:8080/api/user/sendsmscode
     */
    public static final String USER_SENDSMSCODE = BASE_URL + "user/sendsmscode";
    /**
     * 用户注册接口
     * User-register
     */
    public static final String USER_REGISTER = BASE_URL + "user/register";

    /**
     * 汽车分类接口
     * Cart-getbrand
     * String url = "http://47.92.30.24:8080/api/cart/" + "getbrand";
     */
    public static final String CART_GETBRAND = BASE_URL + "cart/getbrand";

    /**
     * 热门品牌接口
     * Cart–gethotbrand
     */
    public static final String CART_GETHOTBRAND = BASE_URL + "cart/gethotbrand";

    /**
     * 首页banner接口
     * Article-getbanner
     */
    public static final String ARTICLE_GETBANNER = BASE_URL + "article/getbanner";

    /**
     * 团购列表
     * Purchase-group_brandlist
     * {"data":{"brand":[{"logo":"20170413\/13601c957e41643cd8725ba690e5f72d.jpg","id":1},null],"brandlist":[{"logo":"20170413\/13601c957e41643cd8725ba690e5f72d.jpg","id":1},null]}}
     */
    public static final String PURCHASE_GROUP_BRANDLIST = BASE_URL + "purchase/group_brandlist";


    /**
     * 获取常见问题分类接口
     * User-getfaqclasslist
     */
    public static final String USER_GETFAQCLASSLIST = BASE_URL + "user/getfaqclasslist";

    /**
     * 获取常见问题列表接口
     * User-getfaqlist
     */
    public static final String USER_GETFAQLIST = BASE_URL + "user/getfaqlist";

    /**
     * 我的订单接口
     * User-myorder
     */
    public static final String USER_MYORDER = BASE_URL + "user/myorder";

    /**
     * 最新车源
     * Cart-newcart
     * {"data":[{"modelid":26,"name":"2019款 4.7L Couoe","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170427\/560da4fef81f78892fff3f9565770dd2.jpg"},{"modelid":1,"name":"2017款 4.7L Couoe","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170427\/fdb4123a256bfd56b18af776078be0ad.jpg"},{"modelid":1,"name":"2016款 4.7L Couoe","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170427\/fdb4123a256bfd56b18af776078be0ad.jpg"},{"modelid":1,"name":"2019款 4.7L Couoe","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170427\/fdb4123a256bfd56b18af776078be0ad.jpg"},{"modelid":3,"name":"2017款 4.7L Couoe","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170413\/3c909e96e13a54f9156a6df36c0416cf.jpg"},{"modelid":1,"name":"2017款 4.7L Couoe","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170427\/fdb4123a256bfd56b18af776078be0ad.jpg"},{"modelid":1,"name":"2017款 4.7L Couoe","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170427\/fdb4123a256bfd56b18af776078be0ad.jpg"},{"modelid":1,"name":"2017款 4.7L Couoe","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170427\/fdb4123a256bfd56b18af776078be0ad.jpg"},{"modelid":3,"name":"2017款 4.7L Couoe","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170413\/3c909e96e13a54f9156a6df36c0416cf.jpg"},{"modelid":3,"name":"2017款 4.7L Couoe","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170413\/3c909e96e13a54f9156a6df36c0416cf.jpg"},{"modelid":3,"name":"2017款 4.7L Couoe","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170413\/3c909e96e13a54f9156a6df36c0416cf.jpg"},{"modelid":3,"name":"2017款 4.7L Couoe","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170413\/3c909e96e13a54f9156a6df36c0416cf.jpg"},{"modelid":3,"name":"2017款 4.7L Couoe","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170413\/3c909e96e13a54f9156a6df36c0416cf.jpg"},{"modelid":1,"name":"2017款 4.7L Couoe","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170427\/fdb4123a256bfd56b18af776078be0ad.jpg"},{"modelid":1,"name":"2017款 4.7L Couoe","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170427\/fdb4123a256bfd56b18af776078be0ad.jpg"}]}
     */
    public static final String CART_NEWCART = BASE_URL + "cart/newcart";
    /**
     * 车辆详情
     * Cart-cart_detail
     * {"data":{"modelid":1,"subtitle":null,"price":22,"g_price":22,"name":"2017款 4.7L Couoe","deposit":null,"logo":[{"image":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170427\/fdb4123a256bfd56b18af776078be0ad.jpg"},{"image":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170427\/0dda5abfd264523b7d2b29827446a34b.jpg"},{"image":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170427\/1cd45afcacf0954d3f9b3a5b7fe09cd0.jpg"}],"count":0,"text":[]}}
     */
    public static final String CART_CART_DETAIL = BASE_URL + "cart/cart_detail";

    /**
     * 车辆参数
     * Cart-cart_conf
     * {"data":[{"base":[{"name":"speed","value":"22"},{"name":"official_up","value":"22"},{"name":"actual_up","value":"22"},{"name":"actual_brake","value":null},{"name":"actual_fuel","value":null},{"name":"ministry_fuel","value":"22"},{"name":"gap","value":"22"},{"name":"quality","value":"22"},{"name":"level","value":"紧凑型车"},{"name":"gearbox","value":"手动变速箱"},{"name":"structure","value":"2门3座两厢车"},{"name":"manufacturers","value":5},{"name":"brandname","value":"奔驰"}],"body":null,"engine":null,"motor":null,"gearbox":null,"wheels":null,"security":null,"control":null,"exterior":null,"inside":null,"seat":null,"multimedia":null,"light":null,"glass":null,"refrigerator":null,"hightech":null,"xzb":null}]}
     */
    public static final String CART_CART_CONF = BASE_URL + "cart/cart_conf";

    /**
     * 获取意见反馈分类列表
     * User-getfeedbackclass
     */
    public static final String USER_GETFEEDBACKCLASS = BASE_URL + "user/getfeedbackclass";
}
