package com.dp.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;

/**
 * 静态代理模式
 * 
 * @author Administrator
 *
 */
public class Main {

	static class StandradProxy implements InvocationHandler{
		
		Object orignObject;
		public Object onBind(Object orignObject){
			this.orignObject = orignObject;
			Object object =Proxy.newProxyInstance(orignObject.getClass().getClassLoader(), orignObject.getClass().getInterfaces(), this);
			return object;
			
		}
		@Override
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			long start = System.currentTimeMillis();
			Object object =method.invoke(orignObject, args);
			long end = System.currentTimeMillis();
			System.out.println("speakMathod: costTime:" + (end - start));
			return object;
		}
	}
	
	public static void main(String[] args) {
		//官方提供的动态代理方法
		/*Speaker sp =(Speaker) new StandradProxy().onBind(new MicPhone());
		sp.speak();*/
		//手写的动态代理方法
		
		try {
			Speaker sp =(Speaker) Proxy.newSpeakerInstanceProxy();
			sp.speak();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
