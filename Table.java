package assign3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Table implements Runnable{

    private volatile boolean exit = false;
    Philosopher Aristotle;
    Philosopher Socrates;
    Philosopher Plato;
    Philosopher Pythagoras;
    Philosopher Confucius;

    public Table (String name){
        ReentrantLock forks[] = new ReentrantLock[5];

        for(int i = 0; i<5; i++){
            forks[i] = new ReentrantLock(); 
        }
        
        Aristotle = new Philosopher(forks[4], forks[0], "Aristotle");
        Socrates = new Philosopher(forks[0], forks[1], "Socrates");
        Plato = new Philosopher(forks[1], forks[2], "Plato");
        Pythagoras = new Philosopher(forks[2], forks[3], "Pythagoras");
        Confucius = new Philosopher(forks[3], forks[4], "Confucius");

        Thread p1 = new Thread(Aristotle);
        Thread p2 = new Thread(Socrates);
        Thread p3 = new Thread(Plato);
        Thread p4 = new Thread(Pythagoras);
        Thread p5 = new Thread(Confucius);

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
    }

    @Override
    public void run() {
        while(!exit){    
            if(Aristotle.forkCheck() && Socrates.forkCheck() && Plato.forkCheck() && Pythagoras.forkCheck() && Confucius.forkCheck()){
                exit = true;
                System.out.println("Table has deadlocked!!");
            }       
        }
    }
}