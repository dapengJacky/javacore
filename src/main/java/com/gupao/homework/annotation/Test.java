package com.gupao.homework.annotation;

import org.springframework.util.CollectionUtils;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jacky
 * @description
 * @date 2020/4/5
 */
public class Test {

    public static void main(String[] args) throws Exception {
        Set<String> classPathSet = new HashSet<>();
        //扫描包路径下的class类
        doScanPackage(classPathSet,"com.gupao.homework.annotation.ioc");
        if(!CollectionUtils.isEmpty(classPathSet)){
            for(String className:classPathSet){
                Class<?> clazz = Class.forName(className);
                //判断类上是否有MyComponent注解
                if(clazz.isAnnotationPresent(MyComponent.class)){
                    IOCContainer.putBean(className,clazz.newInstance());
                }
                Method[] methods = clazz.getDeclaredMethods();
                for(Method method:methods){
                    //判断方法上是否有MyBean注解
                    if(method.isAnnotationPresent(MyBean.class)){
                        String name = method.getAnnotation(MyBean.class).value();
                        //静态工厂
                        if(Modifier.isStatic(method.getModifiers())){
                            IOCContainer.putBean(name,method.invoke(null));
                        }else{
                            //实例工厂
                            //从容器中取出实例
                            IOCContainer.putBean(name,method.invoke(IOCContainer.getBean(className)));
                        }
                    }
                }

            }
        }

    }

    private static void doScanPackage(Set<String> classPathSet, String packagePath) {
        URL url = Test.class.getResource("/" + packagePath.replaceAll("\\.", "/"));
        File classDir = new File(url.getFile());
        for(File file:classDir.listFiles()){
            if(file.isDirectory()){
                //如果是目录,递归遍历
                doScanPackage(classPathSet,packagePath+"."+file.getName());
            }else{
                //如果文件名称不是.class结尾
                if(!file.getName().endsWith(".class")){
                    continue;
                }
                //拼接类的全路径
                String  classPath=packagePath + "." + file.getName().replaceAll(".class", "");
                //添加到set集合中
                classPathSet.add(classPath);
            }
        }

    }
}
