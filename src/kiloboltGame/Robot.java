package kiloboltGame;

import java.awt.Graphics;

public class Robot {
	
	//constants
	final int JUMPSPEED = -15;
	final int MOVESPEED = 5;
	final int GROUND = 382;
	
	private int centreX = 100;
	private int centreY = GROUND;
	private boolean jumped = false;
	private boolean movingLeft = false;
	private boolean movingRight = false;
	private boolean ducked = false;
	
	private static Background bg1 = StartingClass.getBg1();
	private static Background bg2 = StartingClass.getBg2();
	
	private int speedX = 0;
	private int speedY  = 1;
	
	public void update() {
		
		//Moves characters or scrolls background accordingly.
		if (speedX < 0) {
			centreX = centreX + speedX;
		}
		else if (speedX == 0 || speedX < 0) {
			bg1.setSpeedX(0);
			bg2.setSpeedX(0);
		}
		else {
			if (centreX <= 200 && speedX >0){
				centreX = centreX + speedX;
			}
			else if (speedX > 0 && centreX > 200){
				bg1.setSpeedX(-MOVESPEED);
				bg2.setSpeedX(-MOVESPEED);
			}
		}
		
		//Updates Y position
		if (centreY + speedY >= GROUND){ //382 is where the character's centerY would be if he were standing on the ground.
			centreY = GROUND;
		}
		else {
			centreY = centreY + speedY;
		}
		
		//Handles Jumping
		if (jumped == true){
			speedY = speedY + 1;
			
			if (centreY + speedY >= GROUND){
				centreY = GROUND;
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
		if (ducked == false){
		speedX = MOVESPEED;			
		}
	}
	
	public void moveLeft(){
		if (ducked == false){
		speedX = -MOVESPEED;			
		}
	}
	
	public void stopRight(){
		setMovingRight(false);
		stop();
	}
	
	public void stopLeft(){
		setMovingLeft(false);
		stop();
	}
	
	public void stop(){
		if (isMovingRight() == false && isMovingLeft() == false){
			speedX = 0;
		}
		
		if (isMovingRight() == false && isMovingLeft() == true){
			moveLeft();
		}
		
		if (isMovingRight() == true && isMovingLeft() == false){
			moveRight();
		}
	}
	
	public void jump(){
		if (jumped == false){
			speedY = JUMPSPEED;
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
	
	public boolean isDucked(){
		return ducked;
	}
	
	public void setDucked(boolean ducked){
		this.ducked = ducked;
	}
	
	public boolean isMovingRight(){
		return movingRight;
	}
	
	public void setMovingRight(boolean movingRight){
		this.movingRight = movingRight;
	}
	
	public boolean isMovingLeft() {
		return movingLeft;
	}
	
	public void setMovingLeft (boolean movingLeft){
		this.movingLeft = movingLeft;
	}
}
