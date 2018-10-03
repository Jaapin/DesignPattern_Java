package com.dp.adapter;

/**
 * 需求 
 * 已有接口 DBInterface;有不同的实现
 * 在不改变调用者的情况下，实现新的接口DBInterface。
 * 
 * @author Administrator
 *
 */
public class mian {

	public static void main(String[] args) {
		
		new User(new DBSocket()).charge();
		
		//在不改调用接口的前提下
		SocketAdapter socketAdapter = new SocketAdapter();
		socketAdapter.setSocket(new GBSocket());
		new User(socketAdapter).charge();
	}

}
