package org.myspringframework.core;

/*
    MySpring框架应用上下文接口
 */
public interface ApplicationContext {
    Object getBean(String beanName);
}
