package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;
import java.util.Timer;
import java.util.TimerTask;
public class TrainControllerImpl implements TrainController {

	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;
	private int delay = 500;
	private int period = 1000;
	private Timer timer;

	
	public TrainControllerImpl(){
		timer = new Timer();
		TimerTask tt = new TimerTask(){
			@Override	
			public void run(){
				followSpeed();
			}
			
		};
		timer.scheduleAtFixedRate(tt, delay, period);
	}	


	public TrainControllerImpl(int d, int p){
		timer = new Timer();
		delay = d;
		period = p;
		TimerTask tt = new TimerTask(){
			@Override	
			public void run(){
				followSpeed();
			}
			
		};
		timer.scheduleAtFixedRate(tt, delay, period);
	}	

	@Override
	public void followSpeed() {
		if (referenceSpeed < 0) {
			referenceSpeed = 0;
		} else {
		    if(referenceSpeed+step > 0) {
                referenceSpeed += step;
            } else {
		        referenceSpeed = 0;
            }
		}

		enforceSpeedLimit();
	}

	@Override
	public int getReferenceSpeed() {
		return referenceSpeed;
	}

	@Override
	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		enforceSpeedLimit();
		
	}

	private void enforceSpeedLimit() {
		if (referenceSpeed > speedLimit) {
			referenceSpeed = speedLimit;
		}
	}

	@Override
	public void setJoystickPosition(int joystickPosition) {
		this.step = joystickPosition;		
	}

}
