package MultiTasking.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NoResultPractice {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        System.out.println("[작업 처리 요청]");
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for(int i=1;i<=10;i++){
                    sum += 1;
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("[실행 쓰레드] " + Thread.currentThread().getName());
                System.out.println("[순서] 1");
                System.out.println("[처리 결과] " + sum);
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for(int i=1;i<=10;i++){
                    sum += 1;
                }
                System.out.println("[실행 쓰레드] " + Thread.currentThread().getName());
                System.out.println("[순서] 2");
                System.out.println("[처리 결과] " + sum);
            }
        };

        Runnable runnable3 = new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for(int i=1;i<=10;i++){
                    sum += 1;
                }
                System.out.println("[실행 쓰레드] " + Thread.currentThread().getName());
                System.out.println("[순서] 3");
                System.out.println("[처리 결과] " + sum);
            }
        };

        Future future = executorService.submit(runnable1);
        //future = executorService.submit(runnable2);
        //future = executorService.submit(runnable3);

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println("[작업 반환 완료]");
                    future.get();
                }catch (Exception e){
                    System.out.println("[실행 예외 발생함] " + e.getMessage());
                }
            }
        });


        System.out.println("[작업 처리 완료]");
        executorService.shutdown();
    }
}
