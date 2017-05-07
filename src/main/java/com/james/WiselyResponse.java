package com.james;

import lombok.Data;

/**
 * Created by 何强
 * date 2017/4/17
 * description
 */
@Data
public class WiselyResponse {
    private String responseMessage;
    public WiselyResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
