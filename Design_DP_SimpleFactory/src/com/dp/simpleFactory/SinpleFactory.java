package com.dp.simpleFactory;
/**
 * 简单工厂
 * @author Administrator
 *
 */
public class SinpleFactory {
	//方法一：提供不同的方法
	
	/*public Moveble createCar (){
		return new Car();
	}
	
	public Moveble createAirPlane (){
		return new Airplane();
	}*/
	
	
	//方法二：提供类型
	public Moveble getMoveble(String type){
		System.out.println("type:"+type);
		switch (type) {
		case "car":
			return new Car();
		case "airplane":
			return new Airplane();
		default:
			return null;
		}
	}
}
