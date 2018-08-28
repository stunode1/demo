package com.psiot.dynamicProxy;

/**
 * 类名称: HelloImpl
 * 功能描述:
 * 日期:  2018/8/27 14:44
 *
 * @author: renpengfei
 * @since: JDK1.8
 */
public class HelloImpl implements Hello {
    @Override
    public void sayHello() {
        System.out.println ("This is helloImpl ");
    }
}
