package com.psiot.dynamicProxy.cglibProxy;

import com.psiot.dynamicProxy.Hello;
import com.psiot.dynamicProxy.HelloImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称: ProxyChainTest
 * 功能描述:
 * 日期:  2018/8/27 16:03
 *
 * @author: renpengfei
 * @since: JDK1.8
 */
public class ProxyChainTest {

    public static void main(String[] args) {
        ConcreteProxy1 proxy1 = new ConcreteProxy1 ();
        ConcreteProxy2 proxy2 = new ConcreteProxy2 ();
        List<Proxy> proxyList = new ArrayList<> ();
        proxyList.add (proxy1);
        proxyList.add (proxy2);


        Hello hello = ProxyManager.creatProxy (HelloImpl.class, proxyList);

        hello.sayHello ();

    }
}
