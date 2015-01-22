package com.palm360.airport.fly;


/**
 * 定时读取 webserivcce内容
 * 并存放到redis中
 * @author zhangtong
 *
 */
public class ReadFlyThread implements Runnable{
	private boolean start = false;
	private int interval = 1000*60;
	public ReadFlyThread(boolean start,int interval){
		this.start = start;
		this.interval = interval;
	}
	public void run() {
		// TODO Auto-generated method stub
		while(start){
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
