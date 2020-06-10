package com.atguigu.springcloud.entities;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
//pom 定义的lombok 配合使用 生产一下几个注解
//全参数构造函数
@AllArgsConstructor
//无参数构造函数
@NoArgsConstructor
//set get
//@Data
@Setter
@Getter
//链式写法
@Accessors(chain = true)
@SuppressWarnings("serial")
public class Dept implements Serializable  {// entity --orm--- db_table //序列化
    private Long 	deptno; // 主键
    private String 	dname; // 部门名称
    private String 	db_source;// 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库

    public Dept(String dname) {
        this.dname = dname;
    }

    public static void main(String[] args) {
        Dept dept = new Dept();
        dept.setDeptno(11L).setDname("RD").setDb_source("DB01");
    }
}
