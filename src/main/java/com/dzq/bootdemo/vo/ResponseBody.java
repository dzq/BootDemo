package com.dzq.bootdemo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBody<T> implements Serializable {
    private int code;
    private String msg;

    private T data;

    public ResponseBody(T data) {
        this.data = data;
    }
}
