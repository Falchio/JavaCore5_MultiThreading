package lesson5;

public class MyRunnable implements Runnable {
    private String name;

    public MyRunnable(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run (){
        for (int i = 0; i <30 ; i++) {
            System.out.println(getName() + " " + i);
        }
    }
}
