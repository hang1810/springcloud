package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {  //json 封装主题类

    private Integer code;
    private String  message;
    private T  data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
