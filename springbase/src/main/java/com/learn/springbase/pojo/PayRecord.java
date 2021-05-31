package com.learn.springbase.pojo;

import java.util.List;
import java.util.Set;

/**
 * @description
 * @author: fangjc
 * @create: 2021-05-31 15:27
 **/
public class PayRecord {
    private String recordId;
    private Custom custom;
    private List<String> remarks;


    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public Custom getCustom() {
        return custom;
    }

    public void setCustom(Custom custom) {
        this.custom = custom;
    }

    @Override
    public String toString() {
        return "PayRecord{" +
                "recordId='" + recordId + '\'' +
                ", custom=" + custom +
                ", remarks=" + remarks +
                '}';
    }

    public List<String> getRemarks() {
        return remarks;
    }



    public void setRemarks(List remarks) {
        this.remarks = remarks;
    }
}
