package org.myspringframework.core;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPathXmlApplicationContext implements ApplicationContext {

    private static final Logger logger = LoggerFactory.getLogger(ClassPathXmlApplicationContext.class);

    //String是beanName，Object是这个bean的类的实例对象
    private Map<String, Object> singletonObjects = new HashMap<>();

    public ClassPathXmlApplicationContext(String configLocation) {
        /*
            解析spring的配置文件
         */
        try {
            //是dom4j解析XML文件的核心对象
            SAXReader reader = new SAXReader();
            //获取一个输入流，指向配置文件（这行ClassLoader代码，就是习惯用法，有时间可以深究一下）
            InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(configLocation);  //这个代码只适合从类路径下加载资源

            //读文件。document对象就代表这个spring配置文件
            Document document = reader.read(in);
            //获取所有的bean标签。
            //参数为什么两个斜杠？Xpath语法，获取所有名字是bean的标签。返回Node类型的List集合。
            List<Node> nodes = document.selectNodes("//bean");
            //遍历bean标签（这个遍历用来实例化bean）
            nodes.forEach(node -> {
                try {
                    //System.out.println(node);
                    //把Node向下转型成Element，因为Element有更多方法
                    Element beanElt = (Element) node;
                    //获取id属性，需要用到Element的attributeValue方法
                    String id = beanElt.attributeValue("id");
                    //获取class属性
                    String className = beanElt.attributeValue("class");
                    //logger记录不了日志，需要看一下。（答案：log4j配置文件的名字必须是log4j2.xml）
                    logger.info("beanName=" + id);
                    logger.info("beanClassName=" + className);
                    //通过反射机制创建对象，将其放到Map集合众个，提前曝光
                    Class<?> aClass = Class.forName(className);
                    //获取无参构造方法
                    Constructor<?> defaultCon = aClass.getDeclaredConstructor();
                    //调用无参构造方法实例化Bean
                    Object bean = defaultCon.newInstance();
                    //将Bean曝光，加入Map集合
                    singletonObjects.put(id, bean);
                    //记录日志
                    logger.info(singletonObjects.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            //再次重新把所有bean标签再次遍历一遍，这一次主要是给对象的属性赋值
            nodes.forEach(node -> {
                try {
                    Element beanElt = (Element) node;
                    //获取id
                    String id = beanElt.attributeValue("id");
                    //获取className
                    String className = beanElt.attributeValue("class");
                    //获取Class
                    Class<?> aClass = Class.forName(className);
                    //获取该bean标签下所有的属性property标签
                    List<Element> properties = beanElt.elements("property");
                    //遍历所有的属性标签
                    properties.forEach(property -> {
                        try {
                            //获取property标签的属性名
                            String propertyName = property.attributeValue("name");
                            //由于getDeclaredMethod需要传入的第二个参数是属性类型，所以需要获取属性类型。后面需要field.getType()一下，来获取该属性的类型
                            Field field = aClass.getDeclaredField(propertyName);
                            logger.info("属性名：" + propertyName);
                            //获取set方法名（拼接）
                            String setMethodName = "set" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);
                            //获取set方法
                            Method setMethod = aClass.getDeclaredMethod(setMethodName, field.getType());
                            //获取下面invoke需要传入的值（第二个参数）
                            String value = property.attributeValue("value");
                            Object actualValue = null;
                            String ref = property.attributeValue("ref");
                            if (value != null) {
                                //说明这个值是简单类型
                                //调用set方法(set方法没有返回值)
                                //获取属性类型名（简单名，不带包名的）
                                String propertyTypeSimpleName = field.getType().getSimpleName();
                                System.out.println("simplename: " + propertyTypeSimpleName);
                                switch (propertyTypeSimpleName) {
                                    case "int":
                                        System.out.println(propertyTypeSimpleName);
                                        actualValue = Integer.valueOf(value);
                                        break;
                                    case "String":
                                        actualValue=value;
                                }
                                System.out.println("actualValue: " + actualValue);
                                setMethod.invoke(singletonObjects.get(id), actualValue);
                            }
                            if (ref != null) {
                                //说明这个值是非简单类型
                                //调用set方法(set方法没有返回值)
                                setMethod.invoke(singletonObjects.get(id), singletonObjects.get(ref));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getBean(String beanName) {
        return singletonObjects.get(beanName);
    }
}
