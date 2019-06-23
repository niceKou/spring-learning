package com.niceKou.module.rpc.config.spring.schema;

import com.niceKou.module.rpc.config.*;
import com.niceKou.module.rpc.config.spring.ReferenceBean;
import com.niceKou.module.rpc.config.spring.ServiceBean;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

public class RpcBeanDefinitionParser implements BeanDefinitionParser {

    private final Class<?> beanClass;
    private final boolean required;

    RpcBeanDefinitionParser(Class<?> beanClass, boolean required) {
        this.beanClass = beanClass;
        this.required = required;
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        return parse(element, parserContext, beanClass, required);
    }

    private static BeanDefinition parse(Element element, ParserContext parserContext, Class<?> beanClass, boolean required) {
        // 解析xsd
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClass(beanClass);
        beanDefinition.setLazyInit(false);
        String id = element.getAttribute("id");

        // 生成bean Id  注册Bean
        if ((id == null || id.length() == 0) && required) {
            String generatedBeanName = element.getAttribute("name");
            if (generatedBeanName == null || generatedBeanName.length() == 0) {
                generatedBeanName = beanClass.getSimpleName();
            }
            id = generatedBeanName;
            int counter = 2;
            while(parserContext.getRegistry().containsBeanDefinition(id)) {
                id = generatedBeanName + (counter ++);
            }
        }

        if (id != null && id.length() > 0) {
            if(parserContext.getRegistry().containsBeanDefinition(id)){
                throw new IllegalStateException("Duplicate spring bean id " + id);
            }
            // 注册Bean
            System.out.println("registerBeanDefinition: id " + id + "getBeanClassName: " + beanDefinition.getBeanClassName());
            parserContext.getRegistry().registerBeanDefinition(id,beanDefinition);
            beanDefinition.getPropertyValues().addPropertyValue("id", id);
        }


        if (RegistryConfig.class.equals(beanClass)) {
            parseRegistry(element, parserContext, beanClass, beanDefinition);
        } else if (ProtocolConfig.class.equals(beanClass)) {
            parseProtocol(element, parserContext, beanClass, beanDefinition);
        } else if (ReferenceBean.class.equals(beanClass)) {
            parseReference(element, parserContext, beanClass, beanDefinition);
        } else if (ServiceBean.class.equals(beanClass)) {
            parseService(element, parserContext, beanClass, beanDefinition);
        }

        return beanDefinition;
    }

    private static void parseRegistry(Element element, ParserContext parserContext, Class<?> beanClass, RootBeanDefinition beanDefinition) {
        if(element.hasAttribute("address")){
            String address = element.getAttribute("address");
            beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue("address",address));
        }
        if(element.hasAttribute("protocol")){
            String protocol = element.getAttribute("protocol");
            beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue("protocol",protocol));
        }
    }

    private static void parseReference(Element element, ParserContext parserContext, Class<?> beanClass, RootBeanDefinition beanDefinition) {
        if(element.hasAttribute("protocol")){
            String protocol = element.getAttribute("protocol");
            beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue("protocol",protocol));
        }
        if(element.hasAttribute("interfaceName")){
            String interfaceName = element.getAttribute("interfaceName");
            beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue("interfaceName",interfaceName));
        }
        if(element.hasAttribute("cluster")){
            String cluster = element.getAttribute("cluster");
            beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue("interfaceName",cluster));
        }
        if(element.hasAttribute("loadBalance")){
            String loadBalance = element.getAttribute("loadBalance");
            beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue("loadBalance",loadBalance));
        }
        if(element.hasAttribute("retries")){
            String retries = element.getAttribute("retries");
            beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue("retries",retries));
        }
    }

    private static void parseProtocol(Element element, ParserContext parserContext, Class<?> beanClass, RootBeanDefinition beanDefinition) {
        if(element.hasAttribute("name")){
            String name = element.getAttribute("name");
            beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue("name",name));
        }
        if(element.hasAttribute("host")){
            String host = element.getAttribute("host");
            beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue("host",host));
        }
        if(element.hasAttribute("port")){
            String port = element.getAttribute("port");
            beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue("port",port));
        }
    }

    private static void parseService(Element element, ParserContext parserContext, Class<?> beanClass, RootBeanDefinition beanDefinition) {
        if(element.hasAttribute("interfaceName")){
            String interfaceName = element.getAttribute("interfaceName");
            beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue("interfaceName",interfaceName));
        }
        if(element.hasAttribute("ref")){
            String ref = element.getAttribute("ref");
            beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue("ref",ref));
        }
        if(element.hasAttribute("protocol")){
            String protocol = element.getAttribute("protocol");
            beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue("protocol",protocol));
        }
    }

}
