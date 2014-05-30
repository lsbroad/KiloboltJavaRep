package kiloboltGame;

import java.awt.Graphics;

public class Robot {
	
	private int centreX = 100;
	private int centreY = 382;
	private boolean jumped = false;
	
	private int speedX = 0;
	private int speedY  = 1;
	
	public void update() {
		
		//Moves characters or scrolls background accordingly.
		if (speedX < 0) {
			centreX = centreX + speedX;
		}
		else if (speedX == 0) {
			System.out.println("Do Not scroll the background");
		}
		else {
			if (centreX <= 150){
				centreX = centreX + speedX;
			}
			else {
				System.out.println("Scroll backgroud here");
			}
		}
		
		//Updates Y position
		if (centreY + speedY >= 382){ //382 is where the character's centerY would be if he were standing on the ground.
			centreY = 382;
		}
		else {
			centreY = centreY + speedY;
		}
		
		//Handles Jumping
		if (jumped == true){
			speedY = speedY + 1;
			
			if (centreY + speedY >= 382){
				centreY = 382;
				speedY = 0;
				jumped = false;
			}
		}
		
		//Prevents gong beyond X coordinate of 0
		if (centreX + speedX <=60){ // if speed x + centre x would bring the character outside the screen
			centreX = 61;			// fix x position at 60 pixels
		}
	}
		
	public void moveRight(){
		speedX = 6;
	}
	
	public void moveLeft(){
		speedX = -6;
	}
	
	public void stop(){
		speedX = 0;
	}
	
	public void jump(){
		if (jumped == false){
			speedY = -15;
			jumped = true;
		}
	}

	public int getCentreX() {
		return centreX;
	}

	public int getCentreY() {
		return centreY;
	}

	public boolean isJumped() {
		return jumped;
	}

	public int getSpeedX() {
		return speedX;
	}

	public int getSpeedY() {
		return speedY;
	}

	public void setCentreX(int centreX) {
		this.centreX = centreX;
	}

	public void setCentreY(int centreY) {
		this.centreY = centreY;
	}

	public void setJumped(boolean jumped) {
		this.jumped = jumped;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}
}
