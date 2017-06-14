package com.youxiake.guide.model;

import java.util.List;

/**
 * Created by Cvmars on 2017/6/14.
 */

public class HomeModel {

    /**
     * handler : search_list
     * url : 玩转
     * data : [{"title":"东南亚","thumb":"http://192.168.22.106:83/Public/Data/upload/ggimages/201703/18/58cca295ca651
     * .jpg","handler":"html5","url":"http://www.youxiake.com/dny/"},{"title":"玩转非洲","thumb":"http://192.168.22
     * .106:83/Public/Data/upload/ggimages/201703/18/58cca2792cbf7.jpg","handler":"html5","url":"http://www.youxiake
     * .com/feizhou/"},{"title":"柬埔寨","thumb":"http://192.168.22
     * .106:83/Public/Data/upload/ggimages/201703/18/58cc9f5f48a68.jpg","handler":"html5","url":"http://www.youxiake
     * .com/jpz/"},{"title":"玩转成都","thumb":"http://192.168.22
     * .106:83/Public/Data/upload/ggimages/201703/06/58bceaaa0ec06.jpg","handler":"html5","url":"http://m.youxiake
     * .com"}]
     */

    public EarthEntity earth;
    /**
     * id : 40
     * pid : 12599
     * pname : 【游侠宝贝之版纳行】2017年云南亲子  西双版纳-热带植物园-傣族园-曼么新寨-勐仑傣寨-野象谷，热带雨林民族风情6日游！
     * starttime : -1179289
     * overtime : 1437791
     * stock : 112
     * orig_price : 3500
     * orig_price_child : 2600
     * status : 1
     * img : http://gallery.youxiake.com/Public/Data/upload/productimg/201612/26/5860d1f8988ea.jpg
     * price : 3280
     */

    public SaleEntity sale;
    /**
     * title : 东北呵呵
     * thumb : http://192.168.22.106:83/Public/Data/upload/ggimages/201612/28/5863bd17b8dd9.png
     * handler : search_list
     * url : 1111
     */

    public List<FlashEntity> flash;
    /**
     * title : 国内游
     * url : cn
     * thumb : http://7xnqtj.com1.z0.glb.clouddn.com/28711493888018.png
     * content : 国内游
     * handler : product_list
     */

    public List<NavsEntity> navs;
    /**
     * title : 游侠客民宿·运河别院，免费试睡啦！
     * thumb : http://192.168.22.106:83/Public/Data/upload/ggimages/201611/30/583e44e2011ee.png
     * handler : html5
     * url : http://mp.weixin.qq.com/s?__biz=MjM5NTgxNjU0MQ==&mid=502025700&idx=1&sn=1571507990eaad720d92af7886956469
     * &chksm=3eea58d6099dd1c0ff7231bb4476ba57ff1c166fcf3b2643296ae8ba314e44558b3834771363&scene=0
     */

    public List<NoticeEntity> notice;
    /**
     * title : sadsad
     */

    public List<NewsEntity> news;
    /**
     * title : 雪乡
     * thumb : http://192.168.22.106:83/Public/Data/upload/ggimages/201612/30/5865c58f59f2f.jpg
     * handler : html5
     * url : http://www.youxiake.com/winter/
     */

    public List<Topic1Entity> topic1;
    /**
     * title : 非洲
     * thumb : http://192.168.22.106:83/Public/Data/upload/ggimages/201612/30/5865c64dd9be4.jpg
     * handler : html5
     * url : http://www.youxiake.com/feizhou/
     */

    public List<Topic2Entity> topic2;
    /**
     * title : 徒步库布齐沙漠
     * thumb : http://gallery.youxiake.com/Public/Data/upload/productimg/201612/16/5853ad29dad72.jpg
     * handler : product_detail
     * url : 15031
     * price_label : 1790
     */

    public List<WeekendEntity> weekend;
    /**
     * title : 怒江大峡谷
     * thumb : http://192.168.22.106:83/Public/Data/upload/ggimages/201703/18/58cc9875aa228.jpg
     * handler : html5
     * url : http://m.youxiake.com
     */

    public List<MddCnEntity> mdd_cn;
    /**
     * title : 罗平油菜花
     * thumb : http://192.168.22.106:83/Public/Data/upload/ggimages/201703/06/58bcd096b3ebf.jpg
     * handler : html5
     * url : http://m.youxiake.com
     */

    public List<MddAbroadEntity> mdd_abroad;
    /**
     * quote_id : 19141
     * content :
     * avatar :
     */

    public List<MeetsEntity> meets;
    /**
     * class_region_id : 2
     * name : 国内游
     * url : http://192.168.22.106/api/home/lines
     * items : [{"tag_id":0,"name":"热门"},{"tag_id":48,"name":"新疆"},{"tag_id":21,"name":"西北"},{"tag_id":45,
     * "name":"广西"},{"tag_id":47,"name":"西藏"},{"tag_id":23,"name":"东北"},{"tag_id":117,"name":"海南"}]
     */

    public List<TagsEntity> tags;
    /**
     * title : 东北雪乡
     * thumb : http://192.168.22.106:83/Public/Data/upload/ggimages/201612/16/5853a49472080.jpg
     * handler : html5
     * url : http://www.youxiake.com/db/
     */

    public List<HotsearchsEntity> hotsearchs;

    public static class EarthEntity {
        public String handler;
        public String url;
        /**
         * title : 东南亚
         * thumb : http://192.168.22.106:83/Public/Data/upload/ggimages/201703/18/58cca295ca651.jpg
         * handler : html5
         * url : http://www.youxiake.com/dny/
         */

        public List<DataEntity> data;

        public static class DataEntity {
            public String title;
            public String thumb;
            public String handler;
            public String url;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public String getHandler() {
                return handler;
            }

            public void setHandler(String handler) {
                this.handler = handler;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }

    public static class SaleEntity {
        public int id;
        public int pid;
        public String pname;
        public int starttime;
        public int overtime;
        public int stock;
        public int orig_price;
        public int orig_price_child;
        public int status;
        public String img;
        public String price;
    }

    public static class FlashEntity {
        public String title;
        public String thumb;
        public String handler;
        public String url;
    }

    public static class NavsEntity {
        public String title;
        public String url;
        public String thumb;
        public String content;
        public String handler;
    }

    public static class NoticeEntity {
        public String title;
        public String thumb;
        public String handler;
        public String url;
    }

    public static class NewsEntity {
        public String title;
    }

    public static class Topic1Entity {
        public String title;
        public String thumb;
        public String handler;
        public String url;
    }

    public static class Topic2Entity {
        public String title;
        public String thumb;
        public String handler;
        public String url;
    }

    public static class WeekendEntity {
        public String title;
        public String thumb;
        public String handler;
        public String url;
        public String price_label;
    }

    public static class MddCnEntity {
        public String title;
        public String thumb;
        public String handler;
        public String url;
    }

    public static class MddAbroadEntity {
        public String title;
        public String thumb;
        public String handler;
        public String url;
    }

    public static class MeetsEntity {
        public int quote_id;
        public String content;
        public String avatar;
    }

    public static class TagsEntity {
        public int class_region_id;
        public String name;
        public String url;
        /**
         * tag_id : 0
         * name : 热门
         */

        public List<ItemsEntity> items;

        public static class ItemsEntity {
            public int tag_id;
            public String name;
        }
    }

    public static class HotsearchsEntity {
        public String title;
        public String thumb;
        public String handler;
        public String url;
    }


    @Override
    public String toString() {
        return "HomeModel{" +
                "earth=" + earth +
                ", sale=" + sale +
                ", flash=" + flash +
                ", navs=" + navs +
                ", notice=" + notice +
                ", news=" + news +
                ", topic1=" + topic1 +
                ", topic2=" + topic2 +
                ", weekend=" + weekend +
                ", mdd_cn=" + mdd_cn +
                ", mdd_abroad=" + mdd_abroad +
                ", meets=" + meets +
                ", tags=" + tags +
                ", hotsearchs=" + hotsearchs +
                '}';
    }
}
