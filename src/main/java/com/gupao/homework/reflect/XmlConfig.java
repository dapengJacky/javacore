package com.gupao.homework.reflect;

/**
 * @author peng.chen12@hand-china.com
 * @description
 * @date 2020/3/29
 */
public class XmlConfig {

    private String id;
    private String clazz;
    private String factoryBean;
    private String factoryMethod;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getFactoryBean() {
        return factoryBean;
    }

    public void setFactoryBean(String factoryBean) {
        this.factoryBean = factoryBean;
    }

    public String getFactoryMethod() {
        return factoryMethod;
    }

    public void setFactoryMethod(String factoryMethod) {
        this.factoryMethod = factoryMethod;
    }
}
