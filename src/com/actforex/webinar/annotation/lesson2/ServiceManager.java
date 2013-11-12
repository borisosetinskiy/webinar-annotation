package com.actforex.webinar.annotation.lesson2;

import java.lang.reflect.Method;
import java.util.ServiceLoader;


public class ServiceManager {
    private static ServiceManager ourInstance = new ServiceManager();

    public static ServiceManager getInstance() {
        return ourInstance;
    }
    private ServiceManager() { }

    public <T> void start(Class<T> target){
        ServiceLoader<T> loader = ServiceLoader.load(target);
        for(T service : loader) {
            tryStart(service);
        }
    }
    private void tryStart(Object instance) {
        Class<?> target = instance.getClass();
        Method[]methods = target.getDeclaredMethods();
        for(Method method : methods){
            if(method.getAnnotation(Start.class) != null){
                try{
                    method.invoke(instance);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }

    }
}
