package com.learn.springbase.pojo;

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * @description
 * @author: fangjc
 * @create: 2021-06-02 14:42
 **/
@ToString
public class PayReocordByConstruct {
    private String recordId;
    private String desc;
    private Custom custom;


    public PayReocordByConstruct(String recordId, String desc) {
        this.recordId = recordId;
        this.desc = desc;
    }

    public PayReocordByConstruct(String recordId, String desc, Custom custom) {
        this.recordId = recordId;
        this.desc = desc;
        this.custom = custom;
    }
}
