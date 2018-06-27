package assign3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Philosopher implements Runnable {

    ReentrantLock leftFork = new ReentrantLock();
    ReentrantLock rightFork = new ReentrantLock();
    String name; 

    public Philosopher(ReentrantLock leftFork, ReentrantLock rightFork, String name) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.name = name; 
    }

    @Override
    public void run() {
        while(true){
            think(name);
            eat(leftFork, rightFork, name); 
        }
    }

    private void eat(ReentrantLock leftFork, ReentrantLock rightFork, String name){
        leftFork.lock();
        System.out.println(name + " picked up left fork");

        rightFork.lock(); 
        System.out.println(name + " picked up right fork");

        System.out.println(name + " began eating");

        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
        finally{
            leftFork.unlock();
            rightFork.unlock(); 
            System.out.println(name + " finished eating");
        }
    }

    private void think(String name){
        System.out.println(name + " is thinking");

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
    }

    public boolean forkCheck(){
        if(leftFork.isHeldByCurrentThread()){
             return true;
        }else{
            return false;
        }
    }
}