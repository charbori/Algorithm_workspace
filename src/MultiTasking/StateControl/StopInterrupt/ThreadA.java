package MultiTasking.StateControl.StopInterrupt;

public class ThreadA extends Thread {
    private boolean stop;

    public ThreadA(){
        Thread.currentThread().setName("A-thread(setStop)");
    }

    public void run(){

        //case1
        //interruptedException을 while문에 감싸서
        //interrupt를 방생시켜 반복문 중단하는 방법
        /*
        try {
            while(!stop){
                System.out.println(Thread.currentThread().getName() + " is run");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */

        //case2
        //interrupted를 캐치하여 중단하는 방법
        while(!stop){
            System.out.println(Thread.currentThread().getName() + " is run");
            if(Thread.interrupted())
                break;
        }

        System.out.println("stop!");
    }

    public void setStop(){
        stop = true;
    }
}
