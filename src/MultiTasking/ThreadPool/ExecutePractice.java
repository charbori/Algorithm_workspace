package MultiTasking.ThreadPool;

import java.util.concurrent.*;

public class ExecutePractice {
    public static void main(String[] args) throws Exception{
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(2,100,120L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for(int i=0;i<10;i++){
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    ThreadPoolExecutor threadPoolExecutor1 = (ThreadPoolExecutor) executorService;
                    int poolSize = threadPoolExecutor1.getPoolSize();
                    String threadName = Thread.currentThread().getName();
                    System.out.println("[총 스레드 개수: " + poolSize + "] 작업 스레드 이름 : " + threadName);
                    int value = Integer.parseInt("삼");
                }
            };

            //executorService.execute(runnable);
            executorService.submit(runnable);

            Thread.sleep(10);
        }

        executorService.shutdown();

    }
}
