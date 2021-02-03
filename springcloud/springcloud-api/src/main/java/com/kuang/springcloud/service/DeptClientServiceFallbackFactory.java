package com.kuang.springcloud.service;/*
 * @projectName: springcloud
 * @documentName: DeptClientServiceFallbackFactory
 * @author: WJM
 * @date:2021/2/2 11:12
 */

import com.kuang.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;

import java.util.List;

//降级
public class DeptClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {

            @Override
            public Dept queryById(Long id) {
                return new Dept()
                        .setDeptno(id)
                        .setDname("id=>"+id+"没有对应的信息，客户端提供了降级的信息，这个服务现在已经被关闭")
                        .setDb_source("没有数据~");
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }

            @Override
            public boolean addDept(Dept dept) {
                return false;
            }

        };
    }
}
