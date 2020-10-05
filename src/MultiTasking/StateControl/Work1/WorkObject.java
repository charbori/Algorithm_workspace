package MultiTasking.StateControl.Work1;

public class WorkObject {
    public synchronized void methodA(){
        System.out.println("ThreadA의 methodA()의 작업 실행");
        notify();
        try{
            wait();
        }catch(InterruptedException e){}
    }

    public synchronized void methodB(){
        System.out.println("ThreadB의 methodB()의 작업 실행");
        notify();
        try{
            wait();
        }catch (InterruptedException e){}
    }
}
