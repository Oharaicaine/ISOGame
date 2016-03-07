package game.main;

public class Timer {
	
	public static long time = 0;
	
	
	public static void update(){
		time = System.currentTimeMillis();
	}
	
	public static long getTime() {
		return time;
	}
	
	public static double timePassed(long initTime){
		double tempTime = (time - initTime) / 1000;
		return tempTime;
	}

}
