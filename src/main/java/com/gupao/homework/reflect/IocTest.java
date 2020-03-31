package com.gupao.homework.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jacky
 * @description
 * @date 2020/3/29
 */
public class IocTest {


    public static void main(String[] args) throws Exception {
        List<XmlConfig> xmlConfigList = parseXmlConfig();

        for (XmlConfig config:xmlConfigList) {
            if(config.getClazz()!=null){
                Class clazz=Class.forName(config.getClazz());
                if(config.getFactoryMethod()!=null){
                    //静态工厂
                    Method methodB = clazz.getDeclaredMethod(config.getFactoryMethod());//调用静态方法创建对象
                    IocContainer.putBean(config.getId(),methodB.invoke(null));
                }else{
                    //构造函数
                    Constructor constructor = clazz.getConstructor();
                    IocContainer.putBean(config.getId(),constructor.newInstance());
                }
            }else if(config.getFactoryBean()!=null){
                //通过实例工厂创建对象
                Object bean = IocContainer.getBean(config.getFactoryBean());
                Method method = bean.getClass().getMethod(config.getFactoryMethod());
                IocContainer.putBean(config.getId(),method.invoke(bean));
            }else {
                throw new RuntimeException("配置有误，请检查xml配置文件");
            }
        }

    }

    private static List<XmlConfig> parseXmlConfig() {
        List<XmlConfig> xmlConfigList = new ArrayList<XmlConfig>();
        XmlConfig configA = new XmlConfig();//通过构造方法创建对象A
        configA.setId("a");
        configA.setClazz("com.gupao.java_core.reflect.ioc.A");
        xmlConfigList.add(configA);


        XmlConfig configB = new XmlConfig();//通过静态工厂方法创建对象B
        configB.setId("b");
        configB.setClazz("com.gupao.java_core.reflect.ioc.A");
        configB.setFactoryMethod("createB");
        xmlConfigList.add(configB);

        XmlConfig configC = new XmlConfig();//通过实例工厂创建对象C
        configC.setId("c");
        configC.setFactoryBean("a");
        configC.setFactoryMethod("createC");
        xmlConfigList.add(configC);

        return xmlConfigList;
    }
}
