package com.aero.o2o.util;

public class BaseThread implements Runnable{
	
	private ThreadOpration opration;
	private boolean start = false;
	private int interval = 1000*60;
	public BaseThread(boolean start,int interval){
		this.start = start;
		this.interval = interval;
	}
	public BaseThread(boolean start,int interval,ThreadOpration opration){
		this.start = start;
		this.interval = interval;
		this.opration = opration;
	}
	public void run() {
		while(start){
			try {
				if(opration != null)
					opration.Opration();
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				if(opration != null){
					opration.Log(e);
				}
			}
		}
			
		
	}

	public void setStart(boolean start) {
		this.start = start;
	}

	public boolean isStart() {
		return start;
	}

	public void setOpration(ThreadOpration opration) {
		this.opration = opration;
	}

	public ThreadOpration getOpration() {
		return opration;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public int getInterval() {
		return interval;
	}

}
