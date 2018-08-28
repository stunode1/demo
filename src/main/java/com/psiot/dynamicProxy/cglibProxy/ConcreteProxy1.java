package com.psiot.dynamicProxy.cglibProxy;

/**
 * 类名称: ConcreteProxy1
 * 功能描述:
 * 日期:  2018/8/27 15:53
 *
 * @author: renpengfei
 * @since: JDK1.8
 */
public class ConcreteProxy1 extends AbstractProxy {

    @Override
    void before() {
        System.out.println (" concrete proxy 1 before ");
    }

    @Override
    void after() {
        System.out.println (" concrete proxy 1 after ");
    }
}
