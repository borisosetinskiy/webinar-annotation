package com.actforex.webinar.annotation.lesson1;


import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RequiredParameterHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method[] methods =  proxy.getClass().getDeclaredMethods();
        for(Method m : methods){
            if(m.getName().equals(method.getName())) {
                Annotation[][] annotations = m.getParameterAnnotations();
                for(int index =0; index < annotations.length; ++index) {
                    for(Annotation a: annotations[index]){
                        if(a.annotationType().equals(Required.class) && args[index] == null){
                            throw new RuntimeException("Parameter ["+index+"] is required.");
                        }
                    }
                }
            }
        }
        return method.invoke(proxy, args);
    }
}
