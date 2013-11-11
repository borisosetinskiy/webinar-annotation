package com.actforex.webinar.annotation.rtti;

import java.lang.annotation.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtils {

    public static <T> T createAnnotationProxy(
            final Object target,
            final InvocationHandler handler
    )throws Exception {
        Class<?> proxyInterface = getDynamicProxy(target.getClass());
        if(proxyInterface == null) throw new Exception("At least one interface should be with annotation @ProxyUtils.DynamicProxy");
        return (T) Proxy.newProxyInstance(
                proxyInterface.getClassLoader(),
                new Class<?>[]{proxyInterface},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args)
                            throws Throwable {
                        if (handler != null)
                            return handler.invoke(target, method, args);
                        else
                            return method.invoke(target, args);
                    }
                });
    }

    private static Class<?> getDynamicProxy(Class<?> clazz){
        Class<?> [] proxyInterfaces =  clazz.getInterfaces();
        Class<?> proxyInterface = null;
        for(Class<?> i : proxyInterfaces){
            if(i.getAnnotation(DynamicProxy.class)!=null){
                proxyInterface = i;
                break;
            }
        }
        if(proxyInterface == null)
            proxyInterface = getDynamicProxy(clazz.getSuperclass());
        return proxyInterface;
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    public @interface DynamicProxy {}
}
