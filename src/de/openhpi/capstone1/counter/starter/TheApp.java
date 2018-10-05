package de.openhpi.capstone1.counter.starter;


import de.openhpi.capstone1.counter.builder.GUIComponent;
import de.openhpi.capstone1.counter.builder.InteractiveComponent;
import de.openhpi.capstone1.counter.builder.InteractiveCounterBuilder;
import processing.core.PApplet;

public class TheApp extends PApplet {

	InteractiveComponent interactiveCounter;

	/**
	 * Defines the dimension of the display window width and height in units of pixels.
	 * If size() is not used, the window will be given a default size of 100 x 100 pixels.
	 */
	@Override
	public void settings() {
		size(500, 500);
	}

	/**
	 * The setup() function is run once, when the program starts. 
	 * It's used to define initial environment properties such as screen size and to load media such as images and fonts as the program starts. 
	 * There can only be one setup() function for each program and it shouldn't be called again after its initial execution.
	 * If the sketch is a different dimension than the default, the size() function or fullScreen() function must be the first line in setup().
	 */
	@Override
	public void setup() {
		frameRate(30);		//Specifies the number of frames to be displayed every second.
		InteractiveCounterBuilder builder = new InteractiveCounterBuilder();
		GUIComponent.construct(this, builder);
		interactiveCounter = builder.getComponent();
	}

	@Override
	public void draw() {  // draw() loops forever, until stopped
		background(204);
		fill(255);
		rect(random(100),random(100), 10, 10);
		interactiveCounter.update();
	}
	
	@Override
	public void mouseClicked() {
		interactiveCounter.handleEvent();
	}
}
