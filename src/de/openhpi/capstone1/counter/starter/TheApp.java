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

	/**
	 * draw() loops forever, until stopped
	 */
	@Override
	public void draw() {
		/*
		 * Background color of the game window. The RGB value of GREEN is (0, 255, 0)
		 */
		background(0, 255, 0);						
		
		/*
		 * Draw a cycle within the game window and fill in color. 
		 * The cycle is showing randomly within the game window.
		 * The RGB value of RED is (255,0,0).
		 * Use rect(random(100),random(100), 50, 50) to draw a rectangle
		 * Use ellipse(random(100),random(100), 50, 50) to draw a cycle
		 */
		ellipse(random(100),random(100), 50, 50);
		fill(255, 0, 0);
		
		interactiveCounter.update();
	}
	
	/*
	 * The mouseClicked() function is called after a mouse button has been pressed and then released. 
	 * Mouse and keyboard events only work when a program has draw(). 
	 * Without draw(), the code is only run once and then stops listening for events.
	 */
	
	@Override
	public void mouseClicked() {
		interactiveCounter.handleEvent();
	}
}
