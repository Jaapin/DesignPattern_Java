package com.dp.staticProxy;

import java.util.Random;

public class MicPhone implements Speaker {

	public void speak() {
		
		System.out.println("MicPhone Speak....");
		try {
			Thread.sleep(new Random().nextInt(1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
