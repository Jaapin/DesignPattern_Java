package com.dp.observer;
import java.util.ArrayList;
import java.util.List;

public class State {

	private int state;
	private List<Observer> observersList = new ArrayList<Observer>();

	public int getState() {
		return state;
	}

	public void attach(Observer observer) {
		observersList.add(observer);
	}

	public void disattch() {
		observersList.clear();
	}

	public void setState(int state) {
		this.state = state;
		notifyAllObserver();
	}

	private void notifyAllObserver() {

		for (Observer observer : observersList) {
			observer.update();
		}
	}

}
