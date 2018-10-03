package com.dp.staticProxy;

import java.lang.reflect.Proxy;

/**
 * 静态代理模式
 * 
 * @author Administrator
 *
 */
public class Main {

	public static void main(String[] args) {
		
		//直接调用
		/*MicPhone micPhone = new MicPhone();
		micPhone.speak();*/
		
		//代理方法的意义是外部通过代理类去执行
		MicPhone micPhone = new MicPhone();
		/*SpeakerTimeProxy sTimeProxy = new SpeakerTimeProxy(micPhone);
		sTimeProxy.speak();*/
		
		SpeakerLogProxy sLogProxy = new SpeakerLogProxy(micPhone);
		sLogProxy.speak();
		
		
		
	}

}
