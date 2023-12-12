package com.example.spring6.bean2;

/*
    Bean的生命周期按照粗略的五步的话：
    1：实例化Bean（调用无参数构造方法）
    2：给Bean属性赋值（调用set方法）
    3：初始化Bean（会调用Bean的init方法。注意：这个init方法需要自己写，自己配）
    4：使用Bean
    5：销毁Bean（会调用Bean的destroy方法。注意：这个destroy方法需要自己写，自己配）
 */

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

//第一个点位需要实现的接口：BeanNameAware, BeanClassLoaderAware, BeanFactoryAware
//第二个点位要实现的接口：InitializingBean
//第三个点位要实现的接口：DisposableBean

public class User implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, InitializingBean, DisposableBean {

    private String name;

    public User() {
        System.out.println("第一步：无参构造方法执行");
    }

    public void setName(String name) {
        System.out.println("第二步：给对象的属性赋值");
        this.name = name;
    }

    //这个方法需要自己写，自己配。方法名随意。
    public void initBean() {
        System.out.println("第四步：初始化Bean");
    }

    //这个方法需要自己写，自己配。方法名随意。
    public void destroyBean() {
        System.out.println("第七步：销毁Bean");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("Bean这个类的加载器：" + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("生产这个Bean的工厂对象是：" + beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("这个Bean的名字是：" + name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean的afterPropertiesSet执行。");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Disposable的destroy方法执行");
    }
}
