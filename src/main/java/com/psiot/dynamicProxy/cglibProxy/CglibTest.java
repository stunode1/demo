package com.psiot.dynamicProxy.cglibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 类名称: CglibTest
 * 功能描述:
 * 日期:  2018/8/27 15:07
 *
 * @author: renpengfei
 * @since: JDK1.8
 */
public class CglibTest {

    public void test(){
        System.out.println ("hello");
    }
    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer ();
        enhancer.setSuperclass (CglibTest.class);
        enhancer.setCallback (new MethodInterceptor () {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

                System.out.println ("cglibTest method run before");
                Object result = methodProxy.invokeSuper (o, objects);
                System.out.println ("cglibTest method run end");
                return result;
            }
        });

        CglibTest cglibTest = (CglibTest) enhancer.create ();
        cglibTest.test ();
    }
}
