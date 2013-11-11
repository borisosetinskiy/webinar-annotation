package com.actforex.webinar.annotation.lesson1;

import com.actforex.webinar.annotation.rtti.ProxyUtils;


public class Lesson1ProxyFactory {
    public static <T> T create(T o)throws Exception{
        return ProxyUtils.createAnnotationProxy(o, new RequiredParameterHandler()) ;
    }
}
