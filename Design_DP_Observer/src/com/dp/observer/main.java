package com.dp.observer;

public class main {

	public static void main(String[] args) {
		State state = new State();
		new DataObserver(state);
		state.setState(85);

		state.disattch();

		state.setState(100);

	}

}
