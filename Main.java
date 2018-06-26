package assign3;

public class Main {

public static void main(String[] args) {
    //Table A = new Table("A"); 
    Thread A = new Thread(new Table("A"));
    A.start();
  }
}