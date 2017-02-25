package com.example.lijie.kitchen.db;

import java.util.List;

/**
 * Created by Administrator on 2017-02-25.
 */

public class ItemBean {
    private String resultcode;
    private String reason;
    private List<FirstHorizonItemBean> result;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public List<FirstHorizonItemBean> getResult() {
        return result;
    }

    public void setResult(List<FirstHorizonItemBean> result) {
        this.result = result;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "ItemBean{" +
                "resultcode='" + resultcode + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }
}
