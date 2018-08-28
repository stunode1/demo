package com.psiot.dynamicProxy.cglibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 类名称: ProxyManager
 * 功能描述:
 * 日期:  2018/8/27 15:14
 *
 * @author: renpengfei
 * @since: JDK1.8
 */
//使用组合,减少内聚性
public class ProxyManager {


    @SuppressWarnings ("unchecked")
    public static <T> T creatProxy(Class<?> targetClass, List<Proxy> proxyList){
        return (T) Enhancer.create (targetClass, new MethodInterceptor () {
            @Override
            public Object intercept(Object targetObject, Method targetMethod, Object[] methodParams, MethodProxy methodProxy) throws Throwable {
                return new ProxyChain (targetClass, targetObject, targetMethod,methodParams,proxyList).doProxyChain ();
            }
        });
    }
}
