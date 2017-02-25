package com.example.lijie.kitchen.db;

import java.util.List;

/**
 * Created by Administrator on 2017-02-25.
 */

public class FirstHorizonItemBean {
    private String parentId;
    private String name;
    private List<SecondItemBean> list;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<SecondItemBean> getList() {
        return list;
    }

    public void setList(List<SecondItemBean> list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FirstHorizonItemBean{" +
                "parentId='" + parentId + '\'' +
                ", name='" + name + '\'' +
                ", list=" + list +
                '}';
    }
}
