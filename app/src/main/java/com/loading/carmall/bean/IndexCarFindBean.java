package com.loading.carmall.bean;

import java.util.List;

/**
 * Created by 马小布 on 2017/4/11.
 */

public class IndexCarFindBean {

    /**
     * error_code : 0
     * reason : 查询成功
     * result : {"detail":[{"firstLetter":"A","id":27,"imageSrc":"/parentbrand/aodi.jpg","name":"奥迪"},{"firstLetter":"A","id":26,"imageSrc":"/parentbrand/anchi.jpg","name":"安驰"},{"firstLetter":"A","id":24,"imageSrc":"/parentbrand/AlfaRomeo.jpg","name":"阿尔法-罗密欧"},{"firstLetter":"A","id":25,"imageSrc":"/parentbrand/asidunmading.jpg","name":"阿斯顿马丁"},{"firstLetter":"A","id":162,"imageSrc":"(NULL)","name":"Alpina"},{"firstLetter":"B","id":38,"imageSrc":"/parentbrand/bentian.jpg","name":"本田"},{"firstLetter":"B","id":41,"imageSrc":"/parentbrand/bieke.jpg","name":"别克"},{"firstLetter":"B","id":40,"imageSrc":"/parentbrand/biaozhi.jpg","name":"标致"},{"firstLetter":"B","id":39,"imageSrc":"/parentbrand/biyadi.jpg","name":"比亚迪"},{"firstLetter":"B","id":31,"imageSrc":"/parentbrand/baoma.jpg","name":"宝马"},{"firstLetter":"B","id":36,"imageSrc":"/parentbrand/benchi.jpg","name":"奔驰"},{"firstLetter":"B","id":37,"imageSrc":"/parentbrand/benteng.jpg","name":"奔腾"},{"firstLetter":"B","id":29,"imageSrc":"/parentbrand/baoJun.jpg","name":"宝骏"},{"firstLetter":"B","id":35,"imageSrc":"/parentbrand/beiqi.jpg","name":"北汽"},{"firstLetter":"B","id":33,"imageSrc":"/parentbrand/baoshijie.jpg","name":"保时捷"},{"firstLetter":"B","id":34,"imageSrc":"/parentbrand/beijing.jpg","name":"北京"},{"firstLetter":"B","id":30,"imageSrc":"/parentbrand/baolong.jpg","name":"宝龙"},{"firstLetter":"B","id":28,"imageSrc":"/parentbrand/barbus.jpg","name":"巴博斯"},{"firstLetter":"B","id":42,"imageSrc":"/parentbrand/binli.jpg","name":"宾利"},{"firstLetter":"B","id":43,"imageSrc":"/parentbrand/bujiadi.jpg","name":"布加迪"},{"firstLetter":"B","id":32,"imageSrc":"/parentbrand/bufori.jpg","name":"保斐利"},{"firstLetter":"C","id":45,"imageSrc":"/parentbrand/changan.jpg","name":"长安"},{"firstLetter":"C","id":47,"imageSrc":"/parentbrand/changcheng.jpg","name":"长城"},{"firstLetter":"C","id":48,"imageSrc":"/parentbrand/chuanqi.jpg","name":"传祺"},{"firstLetter":"C","id":46,"imageSrc":"/parentbrand/changanshangyong.jpg","name":"长安商用"},{"firstLetter":"C","id":44,"imageSrc":"/parentbrand/changhe.jpg","name":"昌河"},{"firstLetter":"D","id":53,"imageSrc":"/parentbrand/dazhong.jpg","name":"大众"},{"firstLetter":"D","id":59,"imageSrc":"/parentbrand/dongnan.jpg","name":"东南"},{"firstLetter":"D","id":50,"imageSrc":"/parentbrand/dafa.jpg","name":"大发"},{"firstLetter":"D","id":56,"imageSrc":"/parentbrand/dongfeng.jpg","name":"东风"},{"firstLetter":"D","id":54,"imageSrc":"/parentbrand/daoqi.jpg","name":"道奇"},{"firstLetter":"D","id":16,"imageSrc":"/parentbrand/DS.jpg","name":"DS"},{"firstLetter":"D","id":57,"imageSrc":"/parentbrand/dongfengfengdu.jpg","name":"东风风度"},{"firstLetter":"D","id":58,"imageSrc":"/parentbrand/dongfengxiaokang.jpg","name":"东风小康"},{"firstLetter":"D","id":49,"imageSrc":"/parentbrand/dadi.jpg","name":"大迪"},{"firstLetter":"D","id":51,"imageSrc":"/parentbrand/datong.jpg","name":"大通"},{"firstLetter":"D","id":52,"imageSrc":"/parentbrand/dayu.jpg","name":"大宇"},{"firstLetter":"F","id":3,"imageSrc":"/parentbrand/fengtian.jpg","name":"丰田"},{"firstLetter":"F","id":7,"imageSrc":"/parentbrand/fute.jpg","name":"福特"},{"firstLetter":"F","id":2,"imageSrc":"/parentbrand/feiyate.jpg","name":"菲亚特"},{"firstLetter":"F","id":8,"imageSrc":"/parentbrand/futian.jpg","name":"福田"},{"firstLetter":"F","id":1,"imageSrc":"/parentbrand/falali.jpg","name":"法拉利"},{"firstLetter":"F","id":5,"imageSrc":"/parentbrand/fenghang.jpg","name":"风行"},{"firstLetter":"F","id":4,"imageSrc":"/parentbrand/fengshen.jpg","name":"风神"},{"firstLetter":"F","id":6,"imageSrc":"/parentbrand/fudi.jpg","name":"福迪"},{"firstLetter":"F","id":163,"imageSrc":"(NULL)","name":"富奇"},{"firstLetter":"G","id":10,"imageSrc":"/parentbrand/guanggang.jpg","name":"光冈"},{"firstLetter":"G","id":9,"imageSrc":"/parentbrand/guanzhi.jpg","name":"观致"},{"firstLetter":"G","id":17,"imageSrc":"/parentbrand/GMC.jpg","name":"GMC"},{"firstLetter":"H","id":14,"imageSrc":"/parentbrand/haima.jpg","name":"海马"},{"firstLetter":"H","id":12,"imageSrc":"/parentbrand/hafu.jpg","name":"哈弗"},{"firstLetter":"H","id":62,"imageSrc":"/parentbrand/hongqi.jpg","name":"红旗"},{"firstLetter":"H","id":11,"imageSrc":"/parentbrand/hafei.jpg","name":"哈飞"},{"firstLetter":"H","id":15,"imageSrc":"/parentbrand/hanma.jpg","name":"悍马"},{"firstLetter":"H","id":65,"imageSrc":"/parentbrand/huatai.jpg","name":"华泰"},{"firstLetter":"H","id":13,"imageSrc":"/parentbrand/haige.jpg","name":"海格"},{"firstLetter":"H","id":60,"imageSrc":"/parentbrand/heibao.jpg","name":"黑豹"},{"firstLetter":"H","id":68,"imageSrc":"/parentbrand/huanghai.jpg","name":"黄海"},{"firstLetter":"H","id":61,"imageSrc":"/parentbrand/hengtian.jpg","name":"恒天"},{"firstLetter":"H","id":63,"imageSrc":"/parentbrand/huabei.jpg","name":"华北"},{"firstLetter":"H","id":64,"imageSrc":"/parentbrand/huapu.jpg","name":"华普"},{"firstLetter":"H","id":171,"imageSrc":"(NULL)","name":"华颂"},{"firstLetter":"H","id":66,"imageSrc":"/parentbrand/huayang.jpg","name":"华阳"},{"firstLetter":"H","id":67,"imageSrc":"/parentbrand/huansu.jpg","name":"幻速"},{"firstLetter":"H","id":69,"imageSrc":"/parentbrand/huizhong.jpg","name":"汇众"},{"firstLetter":"J","id":71,"imageSrc":"/parentbrand/jili.jpg","name":"吉利"},{"firstLetter":"J","id":73,"imageSrc":"/parentbrand/jianghuai.jpg","name":"江淮"},{"firstLetter":"J","id":18,"imageSrc":"/parentbrand/Jeep.jpg","name":"Jeep"},{"firstLetter":"J","id":78,"imageSrc":"/parentbrand/jinbei.jpg","name":"金杯"},{"firstLetter":"J","id":76,"imageSrc":"/parentbrand/jiebao.jpg","name":"捷豹"},{"firstLetter":"J","id":74,"imageSrc":"/parentbrand/jiangling.jpg","name":"江铃"},{"firstLetter":"J","id":77,"imageSrc":"/parentbrand/jiefang.jpg","name":"解放"},{"firstLetter":"J","id":75,"imageSrc":"/parentbrand/jiangnan.jpg","name":"江南"},{"firstLetter":"J","id":70,"imageSrc":"/parentbrand/jiao.jpg","name":"吉奥"},{"firstLetter":"J","id":72,"imageSrc":"/parentbrand/jiaxing.jpg","name":"佳星"},{"firstLetter":"J","id":79,"imageSrc":"/parentbrand/jincheng.jpg","name":"金程"},{"firstLetter":"J","id":80,"imageSrc":"/parentbrand/jiulong.jpg","name":"九龙"},{"firstLetter":"K","id":84,"imageSrc":"/parentbrand/kaidilake.jpg","name":"凯迪拉克"},{"firstLetter":"K","id":86,"imageSrc":"/parentbrand/kelaisile.jpg","name":"克莱斯勒"},{"firstLetter":"K","id":81,"imageSrc":"/parentbrand/carlsson.jpg","name":"卡尔森"},{"firstLetter":"K","id":82,"imageSrc":"/parentbrand/kawei.jpg","name":"卡威"},{"firstLetter":"K","id":83,"imageSrc":"/parentbrand/kairui.jpg","name":"开瑞"},{"firstLetter":"K","id":169,"imageSrc":"(NULL)","name":"凯翼"},{"firstLetter":"K","id":85,"imageSrc":"/parentbrand/kenisaike.jpg","name":"科尼赛克"},{"firstLetter":"L","id":96,"imageSrc":"/parentbrand/lingmu.jpg","name":"铃木"},{"firstLetter":"L","id":98,"imageSrc":"/parentbrand/luhu.jpg","name":"路虎"},{"firstLetter":"L","id":91,"imageSrc":"/parentbrand/leinuo.jpg","name":"雷诺"},{"firstLetter":"L","id":90,"imageSrc":"/parentbrand/leikesasi.jpg","name":"雷克萨斯"},{"firstLetter":"L","id":164,"imageSrc":"(NULL)","name":"猎豹"},{"firstLetter":"L","id":87,"imageSrc":"/parentbrand/lanbojini.jpg","name":"兰博基尼"},{"firstLetter":"L","id":89,"imageSrc":"/parentbrand/laosilaisi.jpg","name":"劳斯莱斯"},{"firstLetter":"L","id":93,"imageSrc":"/parentbrand/lifan.jpg","name":"力帆"},{"firstLetter":"L","id":100,"imageSrc":"/parentbrand/luofu.jpg","name":"罗孚"},{"firstLetter":"L","id":99,"imageSrc":"/parentbrand/lotus.jpg","name":"路特斯"},{"firstLetter":"L","id":92,"imageSrc":"/parentbrand/linian.jpg","name":"理念"},{"firstLetter":"L","id":94,"imageSrc":"/parentbrand/lianhua.jpg","name":"莲花"},{"firstLetter":"L","id":95,"imageSrc":"/parentbrand/linken.jpg","name":"林肯"},{"firstLetter":"L","id":97,"imageSrc":"/parentbrand/lufeng.jpg","name":"陆风"},{"firstLetter":"L","id":88,"imageSrc":"/parentbrand/laolunshi.jpg","name":"劳伦士"},{"firstLetter":"M","id":101,"imageSrc":"/parentbrand/mazida.jpg","name":"马自达"},{"firstLetter":"M","id":20,"imageSrc":"/parentbrand/mini.jpg","name":"MINI"},{"firstLetter":"M","id":102,"imageSrc":"/parentbrand/mashaladi.jpg","name":"玛莎拉蒂"},{"firstLetter":"M","id":19,"imageSrc":"/parentbrand/MG.jpg","name":"MG"},{"firstLetter":"M","id":105,"imageSrc":"/parentbrand/meiya.jpg","name":"美亚"},{"firstLetter":"M","id":103,"imageSrc":"/parentbrand/maibahe.jpg","name":"迈巴赫"},{"firstLetter":"M","id":104,"imageSrc":"/parentbrand/mclaren.jpg","name":"迈凯伦"},{"firstLetter":"N","id":106,"imageSrc":"/parentbrand/nazhijie.jpg","name":"纳智捷"},{"firstLetter":"O","id":108,"imageSrc":"/parentbrand/oubao.jpg","name":"欧宝"},{"firstLetter":"O","id":107,"imageSrc":"/parentbrand/ouge.jpg","name":"讴歌"},{"firstLetter":"O","id":109,"imageSrc":"/parentbrand/oulang.jpg","name":"欧朗"},{"firstLetter":"P","id":111,"imageSrc":"/parentbrand/pangdike.jpg","name":"庞蒂克"},{"firstLetter":"P","id":110,"imageSrc":"/parentbrand/pagani.jpg","name":"帕加尼"},{"firstLetter":"Q","id":115,"imageSrc":"/parentbrand/qiya.jpg","name":"起亚"},{"firstLetter":"Q","id":112,"imageSrc":"/parentbrand/qirui.jpg","name":"奇瑞"},{"firstLetter":"Q","id":113,"imageSrc":"/parentbrand/qichen.jpg","name":"启辰"},{"firstLetter":"Q","id":116,"imageSrc":"/parentbrand/qinling.jpg","name":"庆铃"},{"firstLetter":"Q","id":114,"imageSrc":"/parentbrand/qiteng.jpg","name":"启腾"},{"firstLetter":"R","id":118,"imageSrc":"/parentbrand/richan.jpg","name":"日产"},{"firstLetter":"R","id":119,"imageSrc":"/parentbrand/rongwei.jpg","name":"荣威"},{"firstLetter":"R","id":120,"imageSrc":"/parentbrand/ruiqi.jpg","name":"瑞麒"},{"firstLetter":"R","id":21,"imageSrc":"/parentbrand/ruf.jpg","name":"RUF"},{"firstLetter":"S","id":130,"imageSrc":"/parentbrand/sikeda.jpg","name":"斯柯达"},{"firstLetter":"S","id":124,"imageSrc":"/parentbrand/shenbao.jpg","name":"绅宝"},{"firstLetter":"S","id":129,"imageSrc":"/parentbrand/sibalu.jpg","name":"斯巴鲁"},{"firstLetter":"S","id":122,"imageSrc":"/parentbrand/sanling.jpg","name":"三菱"},{"firstLetter":"S","id":128,"imageSrc":"/parentbrand/siming.jpg","name":"思铭"},{"firstLetter":"S","id":127,"imageSrc":"/parentbrand/shuanglong.jpg","name":"双龙"},{"firstLetter":"S","id":23,"imageSrc":"/parentbrand/Smart.jpg","name":"Smart"},{"firstLetter":"S","id":125,"imageSrc":"/parentbrand/shijue.jpg","name":"世爵"},{"firstLetter":"S","id":126,"imageSrc":"/parentbrand/shuanghuan.jpg","name":"双环"},{"firstLetter":"S","id":121,"imageSrc":"/parentbrand/sabo.jpg","name":"萨博"},{"firstLetter":"S","id":165,"imageSrc":"(NULL)","name":"赛宝"},{"firstLetter":"S","id":123,"imageSrc":"/parentbrand/shanqitongjia.jpg","name":"陕汽通家"},{"firstLetter":"S","id":168,"imageSrc":"(NULL)","name":"SPRINGO"},{"firstLetter":"S","id":22,"imageSrc":"/parentbrand/Scion.jpg","name":"Scion"},{"firstLetter":"T","id":166,"imageSrc":"(NULL)","name":"特斯拉"},{"firstLetter":"T","id":133,"imageSrc":"/parentbrand/tongyong.jpg","name":"通用"},{"firstLetter":"T","id":170,"imageSrc":"(NULL)","name":"腾势"},{"firstLetter":"T","id":131,"imageSrc":"/parentbrand/tianma.jpg","name":"天马"},{"firstLetter":"T","id":132,"imageSrc":"/parentbrand/tongtian.jpg","name":"通田"},{"firstLetter":"W","id":138,"imageSrc":"/parentbrand/woerwo.jpg","name":"沃尔沃"},{"firstLetter":"W","id":140,"imageSrc":"/parentbrand/wushiling.jpg","name":"五十铃"},{"firstLetter":"W","id":139,"imageSrc":"/parentbrand/wuling.jpg","name":"五菱"},{"firstLetter":"W","id":135,"imageSrc":"/parentbrand/weilin.jpg","name":"威麟"},{"firstLetter":"W","id":134,"imageSrc":"/parentbrand/wanfeng.jpg","name":"万丰"},{"firstLetter":"W","id":136,"imageSrc":"/parentbrand/weiwang.jpg","name":"威旺"},{"firstLetter":"W","id":137,"imageSrc":"/parentbrand/wiesmann.jpg","name":"威兹曼"},{"firstLetter":"X","id":144,"imageSrc":"/parentbrand/xiandai.jpg","name":"现代"},{"firstLetter":"X","id":147,"imageSrc":"/parentbrand/xuefolan.jpg","name":"雪佛兰"},{"firstLetter":"X","id":148,"imageSrc":"/parentbrand/xuetielong.jpg","name":"雪铁龙"},{"firstLetter":"X","id":143,"imageSrc":"/parentbrand/xiali.jpg","name":"夏利"},{"firstLetter":"X","id":142,"imageSrc":"/parentbrand/xiyate.jpg","name":"西雅特"},{"firstLetter":"X","id":141,"imageSrc":"/parentbrand/xianaotuo.jpg","name":"西安奥拓"},{"firstLetter":"X","id":145,"imageSrc":"/parentbrand/xinkai.jpg","name":"新凯"},{"firstLetter":"X","id":146,"imageSrc":"/parentbrand/xinyatu.jpg","name":"新雅途"},{"firstLetter":"Y","id":153,"imageSrc":"/parentbrand/yingfeinidi.jpg","name":"英菲尼迪"},{"firstLetter":"Y","id":152,"imageSrc":"/parentbrand/yiweike.jpg","name":"依维柯"},{"firstLetter":"Y","id":151,"imageSrc":"/parentbrand/yiqi.jpg","name":"一汽"},{"firstLetter":"Y","id":149,"imageSrc":"/parentbrand/yangzi.jpg","name":"扬子"},{"firstLetter":"Y","id":150,"imageSrc":"/parentbrand/yema.jpg","name":"野马"},{"firstLetter":"Y","id":167,"imageSrc":"(NULL)","name":"英致"},{"firstLetter":"Y","id":155,"imageSrc":"/parentbrand/yongyuan.jpg","name":"永源"},{"firstLetter":"Y","id":156,"imageSrc":"/parentbrand/yunque.jpg","name":"云雀"},{"firstLetter":"Z","id":161,"imageSrc":"/parentbrand/zhongtai.jpg","name":"众泰"},{"firstLetter":"Z","id":157,"imageSrc":"/parentbrand/zhonghua.jpg","name":"中华"},{"firstLetter":"Z","id":160,"imageSrc":"/parentbrand/zhongxing.jpg","name":"中兴"},{"firstLetter":"Z","id":159,"imageSrc":"/parentbrand/zhongshun.jpg","name":"中顺"},{"firstLetter":"Z","id":158,"imageSrc":"/parentbrand/zhongou.jpg","name":"中欧"}],"note":"SUCCESS"}
     */

    private int error_code;
    private String reason;
    private ResultBean result;

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public String getReason() {
        return reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public static class ResultBean {
        /**
         * detail : [{"firstLetter":"A","id":27,"imageSrc":"/parentbrand/aodi.jpg","name":"奥迪"},{"firstLetter":"A","id":26,"imageSrc":"/parentbrand/anchi.jpg","name":"安驰"},{"firstLetter":"A","id":24,"imageSrc":"/parentbrand/AlfaRomeo.jpg","name":"阿尔法-罗密欧"},{"firstLetter":"A","id":25,"imageSrc":"/parentbrand/asidunmading.jpg","name":"阿斯顿马丁"},{"firstLetter":"A","id":162,"imageSrc":"(NULL)","name":"Alpina"},{"firstLetter":"B","id":38,"imageSrc":"/parentbrand/bentian.jpg","name":"本田"},{"firstLetter":"B","id":41,"imageSrc":"/parentbrand/bieke.jpg","name":"别克"},{"firstLetter":"B","id":40,"imageSrc":"/parentbrand/biaozhi.jpg","name":"标致"},{"firstLetter":"B","id":39,"imageSrc":"/parentbrand/biyadi.jpg","name":"比亚迪"},{"firstLetter":"B","id":31,"imageSrc":"/parentbrand/baoma.jpg","name":"宝马"},{"firstLetter":"B","id":36,"imageSrc":"/parentbrand/benchi.jpg","name":"奔驰"},{"firstLetter":"B","id":37,"imageSrc":"/parentbrand/benteng.jpg","name":"奔腾"},{"firstLetter":"B","id":29,"imageSrc":"/parentbrand/baoJun.jpg","name":"宝骏"},{"firstLetter":"B","id":35,"imageSrc":"/parentbrand/beiqi.jpg","name":"北汽"},{"firstLetter":"B","id":33,"imageSrc":"/parentbrand/baoshijie.jpg","name":"保时捷"},{"firstLetter":"B","id":34,"imageSrc":"/parentbrand/beijing.jpg","name":"北京"},{"firstLetter":"B","id":30,"imageSrc":"/parentbrand/baolong.jpg","name":"宝龙"},{"firstLetter":"B","id":28,"imageSrc":"/parentbrand/barbus.jpg","name":"巴博斯"},{"firstLetter":"B","id":42,"imageSrc":"/parentbrand/binli.jpg","name":"宾利"},{"firstLetter":"B","id":43,"imageSrc":"/parentbrand/bujiadi.jpg","name":"布加迪"},{"firstLetter":"B","id":32,"imageSrc":"/parentbrand/bufori.jpg","name":"保斐利"},{"firstLetter":"C","id":45,"imageSrc":"/parentbrand/changan.jpg","name":"长安"},{"firstLetter":"C","id":47,"imageSrc":"/parentbrand/changcheng.jpg","name":"长城"},{"firstLetter":"C","id":48,"imageSrc":"/parentbrand/chuanqi.jpg","name":"传祺"},{"firstLetter":"C","id":46,"imageSrc":"/parentbrand/changanshangyong.jpg","name":"长安商用"},{"firstLetter":"C","id":44,"imageSrc":"/parentbrand/changhe.jpg","name":"昌河"},{"firstLetter":"D","id":53,"imageSrc":"/parentbrand/dazhong.jpg","name":"大众"},{"firstLetter":"D","id":59,"imageSrc":"/parentbrand/dongnan.jpg","name":"东南"},{"firstLetter":"D","id":50,"imageSrc":"/parentbrand/dafa.jpg","name":"大发"},{"firstLetter":"D","id":56,"imageSrc":"/parentbrand/dongfeng.jpg","name":"东风"},{"firstLetter":"D","id":54,"imageSrc":"/parentbrand/daoqi.jpg","name":"道奇"},{"firstLetter":"D","id":16,"imageSrc":"/parentbrand/DS.jpg","name":"DS"},{"firstLetter":"D","id":57,"imageSrc":"/parentbrand/dongfengfengdu.jpg","name":"东风风度"},{"firstLetter":"D","id":58,"imageSrc":"/parentbrand/dongfengxiaokang.jpg","name":"东风小康"},{"firstLetter":"D","id":49,"imageSrc":"/parentbrand/dadi.jpg","name":"大迪"},{"firstLetter":"D","id":51,"imageSrc":"/parentbrand/datong.jpg","name":"大通"},{"firstLetter":"D","id":52,"imageSrc":"/parentbrand/dayu.jpg","name":"大宇"},{"firstLetter":"F","id":3,"imageSrc":"/parentbrand/fengtian.jpg","name":"丰田"},{"firstLetter":"F","id":7,"imageSrc":"/parentbrand/fute.jpg","name":"福特"},{"firstLetter":"F","id":2,"imageSrc":"/parentbrand/feiyate.jpg","name":"菲亚特"},{"firstLetter":"F","id":8,"imageSrc":"/parentbrand/futian.jpg","name":"福田"},{"firstLetter":"F","id":1,"imageSrc":"/parentbrand/falali.jpg","name":"法拉利"},{"firstLetter":"F","id":5,"imageSrc":"/parentbrand/fenghang.jpg","name":"风行"},{"firstLetter":"F","id":4,"imageSrc":"/parentbrand/fengshen.jpg","name":"风神"},{"firstLetter":"F","id":6,"imageSrc":"/parentbrand/fudi.jpg","name":"福迪"},{"firstLetter":"F","id":163,"imageSrc":"(NULL)","name":"富奇"},{"firstLetter":"G","id":10,"imageSrc":"/parentbrand/guanggang.jpg","name":"光冈"},{"firstLetter":"G","id":9,"imageSrc":"/parentbrand/guanzhi.jpg","name":"观致"},{"firstLetter":"G","id":17,"imageSrc":"/parentbrand/GMC.jpg","name":"GMC"},{"firstLetter":"H","id":14,"imageSrc":"/parentbrand/haima.jpg","name":"海马"},{"firstLetter":"H","id":12,"imageSrc":"/parentbrand/hafu.jpg","name":"哈弗"},{"firstLetter":"H","id":62,"imageSrc":"/parentbrand/hongqi.jpg","name":"红旗"},{"firstLetter":"H","id":11,"imageSrc":"/parentbrand/hafei.jpg","name":"哈飞"},{"firstLetter":"H","id":15,"imageSrc":"/parentbrand/hanma.jpg","name":"悍马"},{"firstLetter":"H","id":65,"imageSrc":"/parentbrand/huatai.jpg","name":"华泰"},{"firstLetter":"H","id":13,"imageSrc":"/parentbrand/haige.jpg","name":"海格"},{"firstLetter":"H","id":60,"imageSrc":"/parentbrand/heibao.jpg","name":"黑豹"},{"firstLetter":"H","id":68,"imageSrc":"/parentbrand/huanghai.jpg","name":"黄海"},{"firstLetter":"H","id":61,"imageSrc":"/parentbrand/hengtian.jpg","name":"恒天"},{"firstLetter":"H","id":63,"imageSrc":"/parentbrand/huabei.jpg","name":"华北"},{"firstLetter":"H","id":64,"imageSrc":"/parentbrand/huapu.jpg","name":"华普"},{"firstLetter":"H","id":171,"imageSrc":"(NULL)","name":"华颂"},{"firstLetter":"H","id":66,"imageSrc":"/parentbrand/huayang.jpg","name":"华阳"},{"firstLetter":"H","id":67,"imageSrc":"/parentbrand/huansu.jpg","name":"幻速"},{"firstLetter":"H","id":69,"imageSrc":"/parentbrand/huizhong.jpg","name":"汇众"},{"firstLetter":"J","id":71,"imageSrc":"/parentbrand/jili.jpg","name":"吉利"},{"firstLetter":"J","id":73,"imageSrc":"/parentbrand/jianghuai.jpg","name":"江淮"},{"firstLetter":"J","id":18,"imageSrc":"/parentbrand/Jeep.jpg","name":"Jeep"},{"firstLetter":"J","id":78,"imageSrc":"/parentbrand/jinbei.jpg","name":"金杯"},{"firstLetter":"J","id":76,"imageSrc":"/parentbrand/jiebao.jpg","name":"捷豹"},{"firstLetter":"J","id":74,"imageSrc":"/parentbrand/jiangling.jpg","name":"江铃"},{"firstLetter":"J","id":77,"imageSrc":"/parentbrand/jiefang.jpg","name":"解放"},{"firstLetter":"J","id":75,"imageSrc":"/parentbrand/jiangnan.jpg","name":"江南"},{"firstLetter":"J","id":70,"imageSrc":"/parentbrand/jiao.jpg","name":"吉奥"},{"firstLetter":"J","id":72,"imageSrc":"/parentbrand/jiaxing.jpg","name":"佳星"},{"firstLetter":"J","id":79,"imageSrc":"/parentbrand/jincheng.jpg","name":"金程"},{"firstLetter":"J","id":80,"imageSrc":"/parentbrand/jiulong.jpg","name":"九龙"},{"firstLetter":"K","id":84,"imageSrc":"/parentbrand/kaidilake.jpg","name":"凯迪拉克"},{"firstLetter":"K","id":86,"imageSrc":"/parentbrand/kelaisile.jpg","name":"克莱斯勒"},{"firstLetter":"K","id":81,"imageSrc":"/parentbrand/carlsson.jpg","name":"卡尔森"},{"firstLetter":"K","id":82,"imageSrc":"/parentbrand/kawei.jpg","name":"卡威"},{"firstLetter":"K","id":83,"imageSrc":"/parentbrand/kairui.jpg","name":"开瑞"},{"firstLetter":"K","id":169,"imageSrc":"(NULL)","name":"凯翼"},{"firstLetter":"K","id":85,"imageSrc":"/parentbrand/kenisaike.jpg","name":"科尼赛克"},{"firstLetter":"L","id":96,"imageSrc":"/parentbrand/lingmu.jpg","name":"铃木"},{"firstLetter":"L","id":98,"imageSrc":"/parentbrand/luhu.jpg","name":"路虎"},{"firstLetter":"L","id":91,"imageSrc":"/parentbrand/leinuo.jpg","name":"雷诺"},{"firstLetter":"L","id":90,"imageSrc":"/parentbrand/leikesasi.jpg","name":"雷克萨斯"},{"firstLetter":"L","id":164,"imageSrc":"(NULL)","name":"猎豹"},{"firstLetter":"L","id":87,"imageSrc":"/parentbrand/lanbojini.jpg","name":"兰博基尼"},{"firstLetter":"L","id":89,"imageSrc":"/parentbrand/laosilaisi.jpg","name":"劳斯莱斯"},{"firstLetter":"L","id":93,"imageSrc":"/parentbrand/lifan.jpg","name":"力帆"},{"firstLetter":"L","id":100,"imageSrc":"/parentbrand/luofu.jpg","name":"罗孚"},{"firstLetter":"L","id":99,"imageSrc":"/parentbrand/lotus.jpg","name":"路特斯"},{"firstLetter":"L","id":92,"imageSrc":"/parentbrand/linian.jpg","name":"理念"},{"firstLetter":"L","id":94,"imageSrc":"/parentbrand/lianhua.jpg","name":"莲花"},{"firstLetter":"L","id":95,"imageSrc":"/parentbrand/linken.jpg","name":"林肯"},{"firstLetter":"L","id":97,"imageSrc":"/parentbrand/lufeng.jpg","name":"陆风"},{"firstLetter":"L","id":88,"imageSrc":"/parentbrand/laolunshi.jpg","name":"劳伦士"},{"firstLetter":"M","id":101,"imageSrc":"/parentbrand/mazida.jpg","name":"马自达"},{"firstLetter":"M","id":20,"imageSrc":"/parentbrand/mini.jpg","name":"MINI"},{"firstLetter":"M","id":102,"imageSrc":"/parentbrand/mashaladi.jpg","name":"玛莎拉蒂"},{"firstLetter":"M","id":19,"imageSrc":"/parentbrand/MG.jpg","name":"MG"},{"firstLetter":"M","id":105,"imageSrc":"/parentbrand/meiya.jpg","name":"美亚"},{"firstLetter":"M","id":103,"imageSrc":"/parentbrand/maibahe.jpg","name":"迈巴赫"},{"firstLetter":"M","id":104,"imageSrc":"/parentbrand/mclaren.jpg","name":"迈凯伦"},{"firstLetter":"N","id":106,"imageSrc":"/parentbrand/nazhijie.jpg","name":"纳智捷"},{"firstLetter":"O","id":108,"imageSrc":"/parentbrand/oubao.jpg","name":"欧宝"},{"firstLetter":"O","id":107,"imageSrc":"/parentbrand/ouge.jpg","name":"讴歌"},{"firstLetter":"O","id":109,"imageSrc":"/parentbrand/oulang.jpg","name":"欧朗"},{"firstLetter":"P","id":111,"imageSrc":"/parentbrand/pangdike.jpg","name":"庞蒂克"},{"firstLetter":"P","id":110,"imageSrc":"/parentbrand/pagani.jpg","name":"帕加尼"},{"firstLetter":"Q","id":115,"imageSrc":"/parentbrand/qiya.jpg","name":"起亚"},{"firstLetter":"Q","id":112,"imageSrc":"/parentbrand/qirui.jpg","name":"奇瑞"},{"firstLetter":"Q","id":113,"imageSrc":"/parentbrand/qichen.jpg","name":"启辰"},{"firstLetter":"Q","id":116,"imageSrc":"/parentbrand/qinling.jpg","name":"庆铃"},{"firstLetter":"Q","id":114,"imageSrc":"/parentbrand/qiteng.jpg","name":"启腾"},{"firstLetter":"R","id":118,"imageSrc":"/parentbrand/richan.jpg","name":"日产"},{"firstLetter":"R","id":119,"imageSrc":"/parentbrand/rongwei.jpg","name":"荣威"},{"firstLetter":"R","id":120,"imageSrc":"/parentbrand/ruiqi.jpg","name":"瑞麒"},{"firstLetter":"R","id":21,"imageSrc":"/parentbrand/ruf.jpg","name":"RUF"},{"firstLetter":"S","id":130,"imageSrc":"/parentbrand/sikeda.jpg","name":"斯柯达"},{"firstLetter":"S","id":124,"imageSrc":"/parentbrand/shenbao.jpg","name":"绅宝"},{"firstLetter":"S","id":129,"imageSrc":"/parentbrand/sibalu.jpg","name":"斯巴鲁"},{"firstLetter":"S","id":122,"imageSrc":"/parentbrand/sanling.jpg","name":"三菱"},{"firstLetter":"S","id":128,"imageSrc":"/parentbrand/siming.jpg","name":"思铭"},{"firstLetter":"S","id":127,"imageSrc":"/parentbrand/shuanglong.jpg","name":"双龙"},{"firstLetter":"S","id":23,"imageSrc":"/parentbrand/Smart.jpg","name":"Smart"},{"firstLetter":"S","id":125,"imageSrc":"/parentbrand/shijue.jpg","name":"世爵"},{"firstLetter":"S","id":126,"imageSrc":"/parentbrand/shuanghuan.jpg","name":"双环"},{"firstLetter":"S","id":121,"imageSrc":"/parentbrand/sabo.jpg","name":"萨博"},{"firstLetter":"S","id":165,"imageSrc":"(NULL)","name":"赛宝"},{"firstLetter":"S","id":123,"imageSrc":"/parentbrand/shanqitongjia.jpg","name":"陕汽通家"},{"firstLetter":"S","id":168,"imageSrc":"(NULL)","name":"SPRINGO"},{"firstLetter":"S","id":22,"imageSrc":"/parentbrand/Scion.jpg","name":"Scion"},{"firstLetter":"T","id":166,"imageSrc":"(NULL)","name":"特斯拉"},{"firstLetter":"T","id":133,"imageSrc":"/parentbrand/tongyong.jpg","name":"通用"},{"firstLetter":"T","id":170,"imageSrc":"(NULL)","name":"腾势"},{"firstLetter":"T","id":131,"imageSrc":"/parentbrand/tianma.jpg","name":"天马"},{"firstLetter":"T","id":132,"imageSrc":"/parentbrand/tongtian.jpg","name":"通田"},{"firstLetter":"W","id":138,"imageSrc":"/parentbrand/woerwo.jpg","name":"沃尔沃"},{"firstLetter":"W","id":140,"imageSrc":"/parentbrand/wushiling.jpg","name":"五十铃"},{"firstLetter":"W","id":139,"imageSrc":"/parentbrand/wuling.jpg","name":"五菱"},{"firstLetter":"W","id":135,"imageSrc":"/parentbrand/weilin.jpg","name":"威麟"},{"firstLetter":"W","id":134,"imageSrc":"/parentbrand/wanfeng.jpg","name":"万丰"},{"firstLetter":"W","id":136,"imageSrc":"/parentbrand/weiwang.jpg","name":"威旺"},{"firstLetter":"W","id":137,"imageSrc":"/parentbrand/wiesmann.jpg","name":"威兹曼"},{"firstLetter":"X","id":144,"imageSrc":"/parentbrand/xiandai.jpg","name":"现代"},{"firstLetter":"X","id":147,"imageSrc":"/parentbrand/xuefolan.jpg","name":"雪佛兰"},{"firstLetter":"X","id":148,"imageSrc":"/parentbrand/xuetielong.jpg","name":"雪铁龙"},{"firstLetter":"X","id":143,"imageSrc":"/parentbrand/xiali.jpg","name":"夏利"},{"firstLetter":"X","id":142,"imageSrc":"/parentbrand/xiyate.jpg","name":"西雅特"},{"firstLetter":"X","id":141,"imageSrc":"/parentbrand/xianaotuo.jpg","name":"西安奥拓"},{"firstLetter":"X","id":145,"imageSrc":"/parentbrand/xinkai.jpg","name":"新凯"},{"firstLetter":"X","id":146,"imageSrc":"/parentbrand/xinyatu.jpg","name":"新雅途"},{"firstLetter":"Y","id":153,"imageSrc":"/parentbrand/yingfeinidi.jpg","name":"英菲尼迪"},{"firstLetter":"Y","id":152,"imageSrc":"/parentbrand/yiweike.jpg","name":"依维柯"},{"firstLetter":"Y","id":151,"imageSrc":"/parentbrand/yiqi.jpg","name":"一汽"},{"firstLetter":"Y","id":149,"imageSrc":"/parentbrand/yangzi.jpg","name":"扬子"},{"firstLetter":"Y","id":150,"imageSrc":"/parentbrand/yema.jpg","name":"野马"},{"firstLetter":"Y","id":167,"imageSrc":"(NULL)","name":"英致"},{"firstLetter":"Y","id":155,"imageSrc":"/parentbrand/yongyuan.jpg","name":"永源"},{"firstLetter":"Y","id":156,"imageSrc":"/parentbrand/yunque.jpg","name":"云雀"},{"firstLetter":"Z","id":161,"imageSrc":"/parentbrand/zhongtai.jpg","name":"众泰"},{"firstLetter":"Z","id":157,"imageSrc":"/parentbrand/zhonghua.jpg","name":"中华"},{"firstLetter":"Z","id":160,"imageSrc":"/parentbrand/zhongxing.jpg","name":"中兴"},{"firstLetter":"Z","id":159,"imageSrc":"/parentbrand/zhongshun.jpg","name":"中顺"},{"firstLetter":"Z","id":158,"imageSrc":"/parentbrand/zhongou.jpg","name":"中欧"}]
         * note : SUCCESS
         */

        private String note;
        private List<DetailBean> detail;

        public void setNote(String note) {
            this.note = note;
        }

        public void setDetail(List<DetailBean> detail) {
            this.detail = detail;
        }

        public String getNote() {
            return note;
        }

        public List<DetailBean> getDetail() {
            return detail;
        }

        public static class DetailBean {
            /**
             * firstLetter : A
             * id : 27
             * imageSrc : /parentbrand/aodi.jpg
             * name : 奥迪
             */

            private String firstLetter;
            private int id;
            private String imageSrc;
            private String name;

            public void setFirstLetter(String firstLetter) {
                this.firstLetter = firstLetter;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setImageSrc(String imageSrc) {
                this.imageSrc = imageSrc;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getFirstLetter() {
                return firstLetter;
            }

            public int getId() {
                return id;
            }

            public String getImageSrc() {
                return imageSrc;
            }

            public String getName() {
                return name;
            }
        }
    }
}
