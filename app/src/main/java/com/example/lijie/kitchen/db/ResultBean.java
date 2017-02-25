package com.example.lijie.kitchen.db;

import java.util.List;

/**
 * Created by Administrator on 2017-02-22.
 */

public class ResultBean {

    private List<CookMenu> data;
    private String totalNum;
    private int pn;
    private int rn;

    public List<CookMenu> getData() {
        return data;
    }

    public void setData(List<CookMenu> data) {
        this.data = data;
    }

    public int getRn() {
        return rn;
    }

    public void setRn(int rn) {
        this.rn = rn;
    }

    public int getPn() {
        return pn;
    }

    public void setPn(int pn) {
        this.pn = pn;
    }

    public String getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(String totalNum) {
        this.totalNum = totalNum;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "data=" + data +
                ", totalNum='" + totalNum + '\'' +
                ", pn=" + pn +
                ", rn=" + rn +
                '}';
    }
}
