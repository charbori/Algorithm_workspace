package MultiTasking.ThreadSequence;

public class CustomThread implements Runnable{

    @Override
    public void run() {
        System.out.print(Thread.currentThread().getName() + " ");
    }
}
