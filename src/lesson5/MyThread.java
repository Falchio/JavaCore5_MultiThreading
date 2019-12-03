package lesson5;

public class MyThread extends Thread {

    public MyThread(String name){
        super(name);
    }

    public void run (){
        for (int i = 0; i <30 ; i++) {
            System.out.println(getName() + " " + i);
        }
    }
}
