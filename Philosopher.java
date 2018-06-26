package assign3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Philosopher implements Runnable {

    Lock leftFork = new ReentrantLock();
    Lock rightFork = new ReentrantLock();
    String name; 

    public Philosopher(Lock leftFork, Lock rightFork, String name) {
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

    private void eat(Lock leftFork, Lock rightFork, String name){
        leftFork.lock();
        System.out.println(name + " picked up left fork");

        rightFork.lock(); 
        System.out.println(name + " picked up right fork");

        System.out.println(name + " began eating");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("BROKEN!!");
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
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("BROKEN!!");
        } 
    }
}