package thread;
/**
 * Created by lixiaoming on 2017/6/23.
 */
public class NormalThread2 implements Runnable {

    private volatile int count = 5;

    @Override
    public void run() {
        while (count > 0) {
            System.out.println(Thread.currentThread().getName() + ":" + count--);
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new NormalThread2();

        Thread t1 = new Thread(runnable, "a");
        Thread t2 = new Thread(runnable, "b");

        t1.start();
        t2.start();
    }
}
