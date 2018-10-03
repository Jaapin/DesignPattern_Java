package com.dp.builder;
/**
 * 建造者：
 * 将产品和建造分离：也就是变与不变分离
 * 产品对外提供是不变的
 * 而建造过程是可变的
 * 
 * @author Administrator
 *
 */
public class main {

	public static void main(String[] args) {
		ComputerCrl computerCrl = new ComputerCrl();
		Computer computer = computerCrl.construct(new HightBuilder());
		System.out.println(computer.toString());
		
	}

}
