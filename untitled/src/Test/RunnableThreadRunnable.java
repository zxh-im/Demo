package Test;

public class RunnableThreadRunnable implements Runnable {
    public static void main(String[] args) {
        new Thread(new RunnableThreadRunnable()).start();
    }
    @Override
    public void run() {

        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
