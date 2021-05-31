package com.learn.springbase.pojo;

import lombok.ToString;

/**
 * @description
 * @author: fangjc
 * @create: 2021-05-31 15:27
 **/
@ToString
public class Custom {
    private String customId;
    private String customName;

    public String getCustomId() {
        return customId;
    }

    public void setCustomId(String customId) {
        this.customId = customId;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

}
