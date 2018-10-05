package de.openhpi.capstone1.counter.view;

import processing.core.PApplet;

public abstract class AbstractView {
	protected PApplet display;				//Initialize an object of PApplet (display)
	
	public AbstractView(PApplet display) {
		this.display = display;
	}
	
	public abstract void update();
}
