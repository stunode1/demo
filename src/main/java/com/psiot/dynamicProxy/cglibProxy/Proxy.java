package com.psiot.dynamicProxy.cglibProxy;

/**
 * 类名称: Proxy
 * 功能描述:
 * 日期:  2018/8/27 15:35
 *
 * @author: renpengfei
 * @since: JDK1.8
 */
public interface Proxy {

    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
