package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//提供Restful服务！
@RestController
public class DeptController {

    //获取一些配置的信息，得到具体的微服务
    @Autowired
    private DiscoveryClient client;

    @Autowired
    private DeptService deptService;



    @PostMapping("/dept/add")
    public boolean addDept(@RequestBody Dept dept){
        return deptService.addDept(dept);
    }

/*    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
       return deptService.queryById(id);
    }*/

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        Dept dept = deptService.queryById(id);
        if (dept==null){
            throw new RuntimeException("Fail");
        }
        return dept;
    }

    /*
    * http://localhost:8001/dept/list
    * */
    @GetMapping("/dept/list")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }


/*
* http://localhost:8001/dept/discovery
*
* */

//注册进来的微服务，获取一些信息
    @GetMapping("/dept/discovery")
    public Object discovery(){
        //获取微服务列表的清单
        List<String> services = client.getServices();
        System.err.println("discovery=>services:"+services);

        //得到一个具体的微服务信息，通过具体的微服务id,applicationName
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.err.println(
                    instance.getHost()+"\t"+
                            instance.getPort()+"\t"+
                            instance.getUri()+"\t"+
                            instance.getServiceId()

            );
        }
        return this.client;

    }






}
