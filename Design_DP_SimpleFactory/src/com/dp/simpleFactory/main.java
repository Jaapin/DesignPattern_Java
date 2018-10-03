package com.dp.simpleFactory;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Moveble car = new Car();
		Moveble airPlane = new Airplane();
		car.run();
		airPlane.run();*/
		
		/*SinpleFactory factory = new SinpleFactory();
		Car car =(Car)factory.createCar();
		car.run();
		Airplane airplane = (Airplane)factory.createAirPlane();
		airplane.run();*/
		
		
		SinpleFactory factory = new SinpleFactory();
		Car car = (Car)factory.getMoveble("car");
		car.run();
		
	}

}
