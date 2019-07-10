package Test;

public class ThreadTest extends Thread{

    public static void main(String[] args) {

        new ThreadTest().start();
        new ThreadTest().start();
        new ThreadTest().start();
    }

    private int i=0;

    @Override
    public void run() {
        for (int i1 = 0; i1 < 50; i1++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+ i1);
        }
    }
}
