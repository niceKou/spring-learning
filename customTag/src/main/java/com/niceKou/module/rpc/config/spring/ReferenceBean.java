package com.niceKou.module.rpc.config.spring;

import com.niceKou.module.rpc.config.ReferenceConfig;
import org.springframework.beans.factory.InitializingBean;

public class ReferenceBean extends ReferenceConfig implements InitializingBean {

    public void afterPropertiesSet() {
        System.out.println("ReferenceBean Initializing --> afterPropertiesSet");
    }
}
