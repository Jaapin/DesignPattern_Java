package com.dp.observer;
import javax.security.auth.Subject;

public class DataObserver extends Observer {

	private State state;

	public DataObserver(State state) {
		this.state = state;
		this.state.attach(this);
	}

	@Override
	public void update() {
		System.out.println("update: "
				+ Integer.toHexString(state.getState()).toUpperCase());
	}

}
