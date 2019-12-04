import java.util.Arrays;

public class MultiThreading {


    public static void main(String[] args) {
        firstMethod(); //без разбиения массива
        secondMethod(); //четыре потока
    }


    public static void firstMethod() {

        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long timeStart = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5)
                    * Math.cos(0.2f + i / 5)
                    * Math.cos(0.4f + i / 2));
        }

        System.out.println("Метод с одним массивом отработал за "+ (System.currentTimeMillis() - timeStart) +" миллисекунд(ы)");
    }

    public static void secondMethod() {

        final int size = 10000000;
        final int h = size / 4;
        float[] arr = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        float[] a3 = new float[h];
        float[] a4 = new float[h];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long timeStart = System.currentTimeMillis();

        Thread A1 = new Thread(()->{
            System.arraycopy(arr, 0, a1, 0, h);
            for (int i = 0; i < a1.length; i++) {
                a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5)
                        * Math.cos(0.2f + i / 5)
                        * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(a1, 0, arr, 0, h);
        });

        Thread A2 = new Thread(()->{
            System.arraycopy(arr, h, a2, 0, h);
            for (int i = 0; i < a2.length; i++) {
                a2[i] = (float) (a2[i] * Math.sin(0.2f + i / 5)
                        * Math.cos(0.2f + i / 5)
                        * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(a2, 0, arr, h, h);
        });

        Thread A3 = new Thread(()->{
            System.arraycopy(arr, h*2, a3, 0, h);
            for (int i = 0; i < a3.length; i++) {
                a3[i] = (float) (a3[i] * Math.sin(0.2f + i / 5)
                        * Math.cos(0.2f + i / 5)
                        * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(a3, 0, arr, h*2, h);
        });

        Thread A4 = new Thread(()->{
            System.arraycopy(arr, h*3, a4, 0, h);
            for (int i = 0; i < a4.length; i++) {
                a4[i] = (float) (a4[i] * Math.sin(0.2f + i / 5)
                        * Math.cos(0.2f + i / 5)
                        * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(a4, 0, arr, h*3, h);
        });

        A1.start();
        A2.start();
        A3.start();
        A4.start();

        try {
            A1.join();
            A2.join();
            A3.join();
            A4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Метод с разбивкой массивов отработал за "+ (System.currentTimeMillis() - timeStart) +" миллисекунд(ы)");
    }

}
