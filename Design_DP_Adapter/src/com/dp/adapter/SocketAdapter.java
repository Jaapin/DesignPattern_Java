package com.dp.adapter;

/**
 * 1 适配器必须实现原有的旧的接口
 * 2 适配器对象中持有对新接口的引用，当调用旧接口时，将这个调用委托给实现新接口的对象来处理，也就是在适配器对象中组合一个新接口。
 * 注意：接口数不一致时，需要提供空的复写
 * @author Administrator
 *
 */
public class SocketAdapter implements DBInterface {

	private GBInterface gbInterface;
	public SocketAdapter() {
		
	}
	public void setSocket(GBInterface gbInterface){
		this.gbInterface = gbInterface;
	}
	public void provideTwoHole() {
		gbInterface.provideThreeHole();
	}

}
