package com.wjw.commons;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author: wjw
 * @Date: 2021/8/6 10:19
 */
@Getter
@Setter
public class ResultJson {
    private String code;
    private String msg;
    private Integer count;
    private List<?> data;

    public ResultJson() {
    }

    public ResultJson(String code, String msg, Integer count, List<?> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultJson{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}
