package com.pemila.annotationdemo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理模式
 * @author 月在未央
 * @date 2019/5/24 10:22
 */
public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target){
        this.target = target;
    }

    /** 生成代理对象*/
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    valid(target);
                    return method.invoke(target,args);
                }
        );
    }


    private  <T> void valid(T t){
        Annotation[]  annotations = t.getClass().getAnnotations();
        for(Annotation an :annotations){
            AnnotationCheck.check(an);
        }
    }
}
