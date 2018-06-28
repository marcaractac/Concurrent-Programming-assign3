package assign3;

public class SimulatedClock implements Runnable {

    private Thread thread;
    private int currentTime;
    private float time;

    public SimulatedClock(){
        currentTime = 0;
        time = currentTime;
        thread = new Thread(this);
        thread.start();
    }
    public void run(){
        while(true){
        }
    }

    public void incrementTime(){
        currentTime++;
    }

    public int getCurrentTime(){
        return currentTime;
    }
}