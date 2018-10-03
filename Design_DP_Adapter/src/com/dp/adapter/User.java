package com.dp.adapter;

public class User {
	private DBInterface mDbSocket;
	public User() {
	}
	
	public User(DBInterface dbSocket){
		this.mDbSocket = dbSocket;
	}
	
	
	public void charge(){
		mDbSocket.provideTwoHole();
	}
}
