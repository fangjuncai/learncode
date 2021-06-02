package com.learn.springbase.pojo;

import lombok.ToString;

/**
 * @description
 * @author: fangjc
 * @create: 2021-06-02 14:42
 **/
@ToString
public class PayReocordByAuto {
    private String recordId;
    private String desc;
    private Custom custom;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Custom getCustom() {
        return custom;
    }

    public void setCustom(Custom custom) {
        this.custom = custom;
    }

    
    public PayReocordByAuto(String recordId, String desc, Custom custom) {
        this.recordId = recordId;
        this.desc = desc;
        this.custom = custom;
    }
}
