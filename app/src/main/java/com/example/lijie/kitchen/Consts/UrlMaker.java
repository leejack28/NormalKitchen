package com.example.lijie.kitchen.Consts;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by Administrator on 2017-02-23.
 */

public class UrlMaker {

    public static final String APPKEY = "1d54282403865188fbd7e7c6ad1d27bd";
    /**
     * 菜谱大全查询时候的URL
     */
    public static final String SEARCHURL = "http://apis.juhe.cn/cook/";

    /**
     * 分类标签列表的URL
     */
    public static final String FirstHorizonUrl = "http://apis.juhe.cn/cook/category";

    public static String getSearchurl(String menu,int rn,int pn){

        try {
           String content = URLEncoder.encode(menu,"UTF-8");
            return SEARCHURL+"query?key="+APPKEY+"&menu="+ content+"&rn="+rn+"&pn="+pn;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getFirstHorizonItemUrl(){
        return FirstHorizonUrl+"?key="+APPKEY;
    }


}
