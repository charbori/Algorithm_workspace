package MultiTasking.StateControl.StopInterrupt;

public class Main {
    public static void main(String[] args){
        ThreadA threadA = new ThreadA();

        threadA.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //threadA.setStop();
        threadA.interrupt();


    }
}
