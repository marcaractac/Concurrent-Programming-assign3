package assign3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Random;

public class Philosopher implements Runnable {

    ReentrantLock leftFork = new ReentrantLock();
    ReentrantLock rightFork = new ReentrantLock();
    String name; 
    Random random = new Random();
    SimulatedClock time = new SimulatedClock();
    float eatTime = 0;
    float thinkTime = 0;
    float forkWait = 2;
    float currentTime = 0;

    public Philosopher(ReentrantLock leftFork, ReentrantLock rightFork, String name) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.name = name; 
    }

    @Override
    public void run() {
        while(true){
            time.incrementTime();
            think(name);
            eat(leftFork, rightFork, name); 
        }
    }

    private void eat(ReentrantLock leftFork, ReentrantLock rightFork, String name){
        time.incrementTime();
        leftFork.lock();
        System.out.println(name + " picked up left fork");
        System.out.println(time.getCurrentTime());

        while(forkWait > 0){    //wait 2 seconds before picking up right fork
            forkWait--;
            time.incrementTime();
        }    
        rightFork.lock(); 

        System.out.println(name + " began eating");

        eatTime = random.nextInt(5) + 2;

        while(eatTime > 0){
            eatTime--;
            time.incrementTime();
        }

        leftFork.unlock();
        rightFork.unlock(); 
        System.out.println(name + " finished eating");
    }

    private void think(String name){
        time.incrementTime();
        System.out.println(name + " is thinking");
        thinkTime = random.nextInt(10) + 5;

        while(thinkTime > 0){
            thinkTime--;
            time.incrementTime();
        } 
    }

    public boolean forkCheck(){
        if(leftFork.isHeldByCurrentThread()){
             return true;
        }else{
            return false;
        }
    }

    public float getTime(){
        return time.getCurrentTime();
    }
}