package MultiTasking.ThreadPool;

import MultiTasking.ThreadPool.Model.Pair;

import java.nio.channels.CompletionHandler;
import java.util.concurrent.*;

public class Practice1 {
    ExecutorService executorService;
//    CompletionService completionService;
    public Practice1(){
        executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//        completionService = new ExecutorCompletionService<>(executorService);
    }
    private CompletionHandler<Integer, Void> callback =
            new CompletionHandler<Integer, Void>() {
                @Override
                public void completed(Integer result, Void attachment) {
                    System.out.println("completed() 실행: " + result);
                }

                @Override
                public void failed(Throwable exc, Void attachment) {
                    System.out.println("failed() 실행: " + exc.toString());
                }
            };

    public static void main(String[] args){
        //class ThreadPractice implements Runnable{
        class ThreadPractice implements Callable<Pair>{
            int time;
            String name;
            Pair p;
            public ThreadPractice(int time, String name, Pair p){
                this.time = time;
                this.name = name;
                this.p = p;
            }
            @Override
            public Pair call() throws Exception{
                while(true){
                    System.out.println("run");
                    try {
                        Thread.sleep(this.time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("run");
                    try {
                        Thread.sleep(this.time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    p.key = this.name;
                    p.data = this.time;

                    break;
                }
                System.out.println(this.name + " 작업 완료");

                return p;
            }
        }
        Pair p = new Pair("1번", 100);
        Pair p2 = new Pair("1번", 100);
        Pair p3 = new Pair("1번", 100);

//        Future<Pair> future = completionService.submit(new ThreadPractice(1000, "1번", p));
//        future = completionService.submit(new ThreadPractice(500, "2번", p));
//        future = completionService.submit(new ThreadPractice(100, "3번", p));

//        completionService.submit(new ThreadPractice(1000, "1번", p));
//        completionService.submit(new ThreadPractice(1000, "2번", p2));
//        completionService.submit(new ThreadPractice(1000, "3번", p3));
//
//        System.out.println("[처리 완료된 작업 확인]");
//        executorService.submit(new Runnable() {
//            @Override
//            public void run() {
//                while(true){
//                    try{
//                        Future<Pair> future = completionService.take();
//                        Pair p = future.get();
//                        System.out.println("[처리 결과]" + p.key + " " + p.data);
//                    }catch (Exception e){
//                        break;
//                    }
//                }
//            }
//        });

//        try {
//            p = future.get();
//            System.out.println("[작업 처리 완료]" + p.key + " " + p.data);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//            System.out.println("[작업 중단]");
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//            System.out.println("[작업 에러]");
//        }
//        try {
//            p = future2.get();
//            System.out.println("[작업 처리 완료]" + p.key + " " + p.data);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//            System.out.println("[작업 중단]");
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//            System.out.println("[작업 에러]");
//        }
//        try {
//            p = future3.get();
//            System.out.println("[작업 처리 완료]" + p.key + " " + p.data);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//            System.out.println("[작업 중단]");
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//            System.out.println("[작업 에러]");
//        }

        try { Thread.sleep(5000);}
        catch(InterruptedException e){}

        Practice1 practice1 = new Practice1();

        //executorService.shutdownNow();
        practice1.doWork("1","2");
        practice1.finish();
    }

    public void finish(){
        executorService.shutdown();
    }

    
    public void doWork(final String x, final String y){
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try{
                    int intX = Integer.parseInt(x);
                    int intY = Integer.parseInt(y);
                    int result = intX + intY;
                    callback.completed(result, null);
                }catch (NumberFormatException e){
                    callback.failed(e, null);
                }
            }
        };
        executorService.submit(task);
    }

}
