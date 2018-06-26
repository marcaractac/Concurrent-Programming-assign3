package assign3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Table implements Runnable{

    public Table (String name){
        Lock forks[] = new ReentrantLock[5];

        for(int i = 0; i<5; i++){
            forks[i] = new ReentrantLock(); 
        }

        Thread p1 = new Thread(new Philosopher(forks[4], forks[0], "Aristotle"));
        Thread p2 = new Thread(new Philosopher(forks[0], forks[1], "Socrates"));
        Thread p3 = new Thread(new Philosopher(forks[1], forks[2], "Plato"));
        Thread p4 = new Thread(new Philosopher(forks[2], forks[3], "Pythagoras"));
        Thread p5 = new Thread(new Philosopher(forks[3], forks[4], "Confucius"));

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
    }

    @Override
    public void run() {
        while(true){}
    }
}