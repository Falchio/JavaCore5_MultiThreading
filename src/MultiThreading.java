import lesson5.MyRunnable;
import lesson5.MyThread;

public class MultiThreading {

    static final int size = 10000000;
    static final int h = size / 2;
    float[] arr = new float[size];

     public static void main(String[] args){

        long timeStart = System.currentTimeMillis();

//        MyThread t1 = new MyThread("t1");
////        MyThread t2 = new MyThread("t2");

//        t1.start();
//        t2.start();


         Thread t1 = new Thread(new MyRunnable("t1"));
         Thread t2 = new Thread(new MyRunnable("t2"));

         t1.start();
         t2.start();


        long timeEnd = System.currentTimeMillis();
        long timeElapsed = timeEnd - timeStart;
        System.out.println((String.format("%02d:%02d", timeElapsed / 60000, (timeElapsed % 60000) / 1000) ));

    }


}
