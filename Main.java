package assign3;

public class Main {

public static void main(String[] args) {
 
    Thread A = new Thread(new Table("A"));
    Thread B = new Thread(new Table("B"));
    Thread C = new Thread(new Table("C"));
    Thread D = new Thread(new Table("D"));
    Thread E = new Thread(new Table("E"));

    A.start();
    //B.start();
    //C.start();
    //D.start();
    //E.start();
  }
}