package com.niceKou.module.rpc.config.spring.schema;

import com.niceKou.module.rpc.config.*;
import com.niceKou.module.rpc.config.spring.ReferenceBean;
import com.niceKou.module.rpc.config.spring.ServiceBean;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class RpcNamespaceHandler extends NamespaceHandlerSupport {
    public void init() {
        /*
         * 最后将定义好的bean装入到spring的bean容器中进行管理
         */
        registerBeanDefinitionParser("registry", new RpcBeanDefinitionParser(RegistryConfig.class, true));
        registerBeanDefinitionParser("protocol", new RpcBeanDefinitionParser(ProtocolConfig.class, true));
        registerBeanDefinitionParser("reference", new RpcBeanDefinitionParser(ReferenceBean.class, true));
        registerBeanDefinitionParser("service", new RpcBeanDefinitionParser(ServiceBean.class, true));

    }
}
