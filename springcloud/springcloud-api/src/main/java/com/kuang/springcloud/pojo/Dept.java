package com.kuang.springcloud.pojo;/*
 * @projectName: springcloud
 * @documentName: Dept
 * @author: WJM
 * @date:2021/1/30 15:26
 */

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true) //链式写法
public class Dept implements Serializable {


    private Long deptno;
    private String dname;
    //这个数据是存在那个数据库的字段，一个服务对应一个数据库，同一个信息可能存在不同的数据库
    private String db_source;

    public Dept(String dname) {
        this.dname = dname;
    }


}
