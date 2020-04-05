package com.gupao.java_core.annotation.demo5.ioc;

import com.gupao.java_core.annotation.demo5.anno.SevenBean;
import com.gupao.java_core.annotation.demo5.anno.SevenComponent;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * Every oak must be an acorn ...
 * Author : Seven
 */
public class Main {

    public static void main( String[] args) throws Exception {

        //装 类 全路径的集合
        HashSet<String> allClassPathSet = new HashSet<String>();

        doScanner(allClassPathSet, "com.gupao.java_core.annotation.demo5");

        for (String className : allClassPathSet) {
            Class<?> clazz = Class.forName(className);

            //SevenComponent注解  处理方式  默认的构造bean实例化的过程..
            if (clazz.isAnnotationPresent(SevenComponent.class)) {
                IOCContainer.putBean(className, clazz.newInstance());
            }

            Method[] methods = clazz.getDeclaredMethods();
            for (int i = 0; i < methods.length; i++) {
                Method method = methods[i];
                if (method.isAnnotationPresent(SevenBean.class)) {

                    String beanName = method.getAnnotation(SevenBean.class).value();

                    //判断 静态工厂
                    if (Modifier.isStatic(method.getModifiers())) {
                        IOCContainer.putBean(beanName, method.invoke(null));

                    } else {//实例工厂

                        //从容器中获取当前这实例对象

                        IOCContainer.putBean(beanName, method.invoke(IOCContainer.getBean(className)));

                    }

                    //IOCContainer.putBean(beanName, method.invoke(clazz.newInstance()));
                }
            }

        }

    }

    /**
     * 得到指定包下所有的class 的全路径
     *
     * @param scanPackage
     * @return
     */
    public static void doScanner(Set<String> allClassPathSet, String scanPackage) {
        URL url = Main.class.getResource("/" + scanPackage.replaceAll("\\.", "/"));
        File classDir = new File(url.getFile());
        for (File file : classDir.listFiles()) {
            if (file.isDirectory()) {
                //是文件夹,递归循环
                doScanner(allClassPathSet, scanPackage + "." + file.getName());
            } else {

                //如果文件不是.class结尾
                if (!file.getName().endsWith(".class")) {
                    continue;
                }
                //拼装类的全路径
                String clazzName = (scanPackage + "." + file.getName().replace(".class", ""));

                //添加到集合中
                allClassPathSet.add(clazzName);
            }
        }
    }
}
