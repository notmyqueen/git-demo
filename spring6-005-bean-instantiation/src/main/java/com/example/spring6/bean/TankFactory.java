package com.example.spring6.bean;

import org.springframework.beans.factory.FactoryBean;

public class TankFactory implements FactoryBean<Tank> {
    //TankFactory也是一个Bean。只不过这个Bean比较特殊，叫做工厂Bean。
    //通过工厂Bean这个特殊的Bean可以获取一个普通的Bean
    @Override
    public Tank getObject() throws Exception {
        return new Tank();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
