package com.dp.builder;

public class HightBuilder implements Builder{

	Computer computer = new Computer();
	public void BuildCPU() {
		computer.setCpu(8);
	}

	public void BuildMainboard() {
		computer.setMainBorad("Hight");
	}

	public void BuildHD() {
		computer.setHd(1024);
	}

	public Computer GetComputer() {
		return computer;
	}

}
