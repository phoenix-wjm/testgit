package com.kuang.springcloud.config;
/*
 * @projectName: springcloud
 * @documentName: ConfigBean
 * @author: WJM
 * @date:2021/1/31 11:17
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
