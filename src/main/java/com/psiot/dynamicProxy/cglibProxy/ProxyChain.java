package com.psiot.dynamicProxy.cglibProxy;

import lombok.Data;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 类名称: ProxyChain
 * 功能描述:
 * 日期:  2018/8/27 15:19
 *
 * @author: renpengfei
 * @since: JDK1.8
 */
@Data
public class ProxyChain {

    int proxyIndex = 0;
    Class<?> targetClass;
    Object targetObject;
    Method targetMethod;
    Object[] methodParams;
    MethodProxy methodProxy;
    List<Proxy> proxyList = new ArrayList<> ();

    public ProxyChain(Class<?> targetClass,Object targetObject, Method targetMethod, Object[] methodParams, List<Proxy> proxyList) {
        this.targetClass = targetClass;
        this.targetObject = targetObject;
        this.targetMethod = targetMethod;
        this.methodParams = methodParams;
        this.methodProxy = methodProxy;
        this.proxyList = proxyList;
    }

    public Object doProxyChain() throws Throwable {
        Object methodResult = null;
        if (proxyIndex < getProxyList ().size ()) {
            methodResult = proxyList.get (proxyIndex++).doProxy (this);
        }
        if (proxyIndex == getProxyList ().size ()) {
            methodResult = methodProxy.invokeSuper (targetObject, null);
        }
        return methodResult;
    }

}
