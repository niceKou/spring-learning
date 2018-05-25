package com.niceKou.module.rpc.config.spring;

import com.niceKou.module.rpc.config.ServiceConfig;
import org.springframework.beans.factory.InitializingBean;

public class ServiceBean extends ServiceConfig implements InitializingBean {

    public void afterPropertiesSet() {
        System.out.println("ServiceBean Initializing --> afterPropertiesSet");
    }
}
