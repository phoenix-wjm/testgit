package com.kuang.springcloud.controller;/*
 * @projectName: springcloud
 * @documentName: DeptConsumerController
 * @author: WJM
 * @date:2021/1/31 11:17
 */

import com.kuang.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {

    //理解：消费者，不应该有service层
    //restTemplate....供我们直接调用就可以了，注册到spring中
    //（url,实体：Map,Class<T> responseType）

    @Autowired
    private RestTemplate restTemplate;//提供多种便捷访问远程http服务的方法，简单的Restful服务模板

    private static final String REST_URL_PREFIX = "http://localhost:8001";


    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }

    /*
    * http://localhost/consumer/dept/get/2
    * */

//    @RequestMapping("/consumer/dept/get/{id}")
//    public Dept get(@PathVariable("id") Long id){
//
//        System.err.println("/consumer/dept/get/{id}"+id);
//        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get"+id,Dept.class);
//    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }


    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }


}
