package default;

/**
 * Created by lixiaoming on 2017/6/23.
 */
public class NormalThread extends Thread {

    private volatile int count = 5;
    private String name;

    public NormalThread(String name) {
        this.name = name;
    }

    @Override
    public void run(){
        while (count > 0) {
            System.out.println("thread " + name + ":" + count--);

            try {
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new NormalThread("a");
        Thread t2 = new NormalThread("b");

        t1.start();
        t2.start();
    }

}
