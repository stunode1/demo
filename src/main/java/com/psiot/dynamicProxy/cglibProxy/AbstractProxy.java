package com.psiot.dynamicProxy.cglibProxy;

/**
 * 类名称: AbStractProxy
 * 功能描述:
 * 日期:  2018/8/27 15:50
 *
 * @author: renpengfei
 * @since: JDK1.8
 */
public abstract class AbstractProxy implements Proxy {


    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {

        Object result = null ;
        before ();
        result = proxyChain.doProxyChain ();
        after ();
        return result;
    }

    abstract void before();

    abstract void after();
}
