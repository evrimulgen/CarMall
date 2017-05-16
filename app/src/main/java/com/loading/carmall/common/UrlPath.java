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
     * 首页汽车头条接口
     * Article–getheadlines
     * {"data":[{"id":1,"title":"你哈皮"},{"id":3,"title":"2232"},{"id":4,"title":"过关"}]}
     */
    public static final String ARTICLE_GETHEADLINES = BASE_URL + "article/getheadlines";
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
    /**
     * 首页热门搜索，搜索记录接口
     * Article-getsearch
     * {"data":[{"keyword":"奥拓","hot":1},{"keyword":"尼桑","hot":1},{"keyword":"宝马","hot":1},{"keyword":"奔驰","hot":1},{"keyword":"红旗","hot":1},{"keyword":"国产","hot":1},{"keyword":"进口","hot":1},{"keyword":"本田","hot":1}]}
     */
    public static final String ARTICLE_GETSEARCH = BASE_URL + "article/getsearch";
    /**
     * 首页搜索结果接口
     * Article-search
     * {"data":[{"id":1,"name":"本田8965号","pricd":"80-90万","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170427\/fdb4123a256bfd56b18af776078be0ad.jpg","comment":"小型车 1.0T 2.0T"},{"id":2,"name":"本田89号","pricd":"80-90万","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170413\/3c909e96e13a54f9156a6df36c0416cf.jpg","comment":"小型车 1.0T 2.0T"},{"id":3,"name":"本田2号","pricd":"80-90万","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170413\/3c909e96e13a54f9156a6df36c0416cf.jpg","comment":"小型车 1.0T 2.0T"},{"id":5,"name":"本田2号","pricd":"80-90万","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170413\/3c909e96e13a54f9156a6df36c0416cf.jpg","comment":"小型车 1.0T 2.0T"},{"id":6,"name":"本田9号","pricd":"80-90万","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170413\/3c909e96e13a54f9156a6df36c0416cf.jpg","comment":"小型车 1.0T 2.0T"},{"id":7,"name":"本田135号","pricd":"80-90万","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170413\/3c909e96e13a54f9156a6df36c0416cf.jpg","comment":"小型车 1.0T 2.0T"},{"id":8,"name":"本田56号","pricd":"80-36万","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170414\/5cb8e3a670453579dc0a1806693bcd48.jpg","comment":"小型车 1.0T 2.0T"},{"id":9,"name":"本田58sw号","pricd":"33.3-55.5万","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170414\/e2f1808aeabf7b6165ddd377df49b7e7.jpg","comment":"小型车 1.0T 2.0T"},{"id":10,"name":"本田ww号","pricd":"33.3-55.5万","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170414\/ad1e43518e77d5e18b826a246a0a48dc.jpg","comment":"小型车 1.0T 2.0T"},{"id":11,"name":"本田1wd号","pricd":"80-36万","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170414\/74cffefac003782ae4816ffac2fb9260.jpg","comment":"小型车 1.0T 2.0T"},{"id":12,"name":"本田213号","pricd":"33.3-55.5万","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170414\/c32429d783a75897c185324ee893baa3.jpg","comment":"小型车 1.0T 2.0T"},{"id":13,"name":"本田213号","pricd":"33.3-55.5万","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170414\/c32429d783a75897c185324ee893baa3.jpg","comment":"小型车 1.0T 2.0T"},{"id":14,"name":"咋咋","pricd":"38.5-22.5","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170421\/282f309b295a613387b6888fe80ab3a4.jpg","comment":"小型车 1.0T 2.0T"},{"id":15,"name":"小马丁","pricd":"39.8-22.5","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170426\/0eea36d3d3a2e8b00818a74039d5e082.jpg","comment":"小型车 1.0T 2.0T"},{"id":26,"name":"就是这个","pricd":"80-90万","logo":"http:\/\/47.92.30.24:8080\/uploads\/face\/20170427\/560da4fef81f78892fff3f9565770dd2.jpg","comment":"小型车 1.0T 2.0T"}]}
     */
    public static final String ARTICLE_SEARCH = BASE_URL + "article/search";

    /**
     * 寻车
     * Cart-find_cart
     * http://47.92.30.24:8080/api/cart/find_cart
     */
    public static final String CART_FIND_CART = BASE_URL + "cart/find_cart";

    /**
     * 寻车列表
     * Cart-find_detail
     * http://47.92.30.24:8080/api/cart/find_detail
     */
    public static final String CART_FIND_DETAIL = BASE_URL + "cart/find_detail";

    /**
     * 类型详情接口
     * Cart-cart_type
     */
    public static final String CART_CART_TYPE = BASE_URL + "cart/cart_type";

    /**
     * 发布二手车接口
     * Cartused-release
     */
    public static final String CARTUSED_RELEASE = BASE_URL + "cartused/release";

    /**
     * 用户协议
     * User-protocol
     */
    public static final String USER_PROTOCOL = BASE_URL + "User/protocol";
}
