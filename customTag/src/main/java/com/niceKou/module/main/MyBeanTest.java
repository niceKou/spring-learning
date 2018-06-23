package com.niceKou.module.main;

import com.niceKou.module.rpc.config.ProtocolConfig;
import com.niceKou.module.rpc.config.RegistryConfig;
import com.niceKou.module.rpc.config.spring.ReferenceBean;
import com.niceKou.module.rpc.config.spring.ServiceBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class MyBeanTest {
    public static void main(String[] args) {
        // BeanFactroy采用的是延迟加载形式来注入Bean的，即只有在使用到某个Bean时(调用getBean())，才对该Bean进行加载实例化
        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("spring-rpc.xml"));
        // 是在容器启动时，一次性创建了所有的Bean
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-rpc.xml");
        listAllSpringBeans(context);

        RegistryConfig registry = context.getBean("myRegistry",RegistryConfig.class);
        System.out.println(registry.toString());

        ReferenceBean referenceBean = context.getBean("myReference",ReferenceBean.class);
        System.out.println(referenceBean.toString());
//
        ServiceBean serviceBean = context.getBean("testService",ServiceBean.class);
        System.out.println(serviceBean.toString());

    }

    /**
     * 获取Spring加载的所有bean
     * @param context
     */
    private static void listAllSpringBeans(ApplicationContext context) {
        String[] beanNames = context.getBeanDefinitionNames();
        int allBeansCount = context.getBeanDefinitionCount();

        System.out.println("\r\n");

        System.out.println("所有beans的数量是：" + allBeansCount);
        for (String beanName : beanNames) {
            Class<?> beanType = context.getType(beanName);
            Package beanPackage = beanType.getPackage();

            Object bean = context.getBean(beanName);

            System.out.println("BeanName:" + beanName);
            System.out.println("Bean的类型：" + beanType);
            System.out.println("Bean所在的包：" + beanPackage);

            System.out.println("\r\n");
        }
    }
}
