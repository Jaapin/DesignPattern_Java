package com.dp.builder;

public class Computer {
	
	private int cpu;
	private String mainBorad;
	private int hd;
	
	
	public void setCpu(int cpu) {
		this.cpu = cpu;
	}
	
	public void setMainBorad(String mainBorad) {
		this.mainBorad = mainBorad;
	}
	
	public void setHd(int hd) {
		this.hd = hd;
	}
	
	public int getCpu() {
		return cpu;
	}
	
	public String getMainBorad() {
		return mainBorad;
	}
	
	public int getHd() {
		return hd;
	}

	public String toString() {
		StringBuffer stringBuffer =new StringBuffer();
		stringBuffer.append("Computer:");
		stringBuffer.append(" CpuSize:"+getCpu());
		stringBuffer.append(" MainBorad:"+getMainBorad());
		stringBuffer.append(" HD:"+getHd());
		return stringBuffer.toString();
	}
}
