package com.kuang.springcloud;
/*
 * @projectName: springcloud
 * @documentName: EurekaServer_7001
 * @author: WJM
 * @date:2021/1/31 14:33
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//启动之后，直接访问http://localhost:7001/
@SpringBootApplication
@EnableEurekaServer //@EnableEurekaServer 服务端的启动类，可以接收别人注册进来
public class EurekaServer_7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_7002.class,args);
    }
}
