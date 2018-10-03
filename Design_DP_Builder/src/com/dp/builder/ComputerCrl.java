package com.dp.builder;

public class ComputerCrl {
	//逐步构建复杂产品对象
    public Computer construct(Builder ab){
       
        ab.BuildCPU();
        ab.BuildMainboard();
        ab.BuildHD();
        
        return ab.GetComputer();
    }

}
