package de.openhpi.capstone1.counter.model;

public class Counter {

	private int count = 0;					//Initialize the score number

	public void updateCount(int value) {	//Update score number
		this.count += value;
	}
	
	public int getCount() {					//Get score number
		return this.count;
	}
}
