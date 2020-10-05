package MultiTasking.StateControl.ThreadGroup;

import MultiTasking.StateControl.DaemonPractice.AutoSaveThread;
import MultiTasking.StateControl.Work2.ConsumerThread;
import MultiTasking.StateControl.Work2.DataBox;
import MultiTasking.StateControl.Work2.ProductThread;

import java.util.Map;
import java.util.Set;

public class ThreadInfoPractice {
    public static void main(String[] args){
        AutoSaveThread autoSaveThread = new AutoSaveThread();
        autoSaveThread.setName("AutoSaveThread");
        autoSaveThread.setDaemon(true);
        autoSaveThread.start();

        Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
        Set<Thread> threads = map.keySet();

        for(Thread thread : threads){
            System.out.println("Name : " + thread.getName() + ((thread.isDaemon())?"(데몬)" : "(주)"));
            System.out.println("\t" + "소속그룹:" + thread.getThreadGroup().getName());
            System.out.println();
        }

        ThreadGroup tg = new ThreadGroup("자동 저장");
        WorkThread workThreadA = new WorkThread(tg, "workThreadA");
        WorkThread workThreadB = new WorkThread(tg, "workThreadB");

        workThreadA.start();
        workThreadB.start();

        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        mainGroup.list();
        System.out.println();

        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
        }
        System.out.println("[자동 저장 스레드 그룹의 interrupt 호출]");
        tg.interrupt();
    }
}
