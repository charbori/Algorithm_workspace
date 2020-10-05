package MultiTasking.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ResultByRunnablePractice {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors());

        System.out.println("[작업 처리 요청]");

        class Task implements Runnable{
            Result result;
            String taskName;
            Task(Result result, String taskName){
                this.result = result;
                this.taskName = taskName;
            }
            @Override
            public void run(){
                int sum = 0;
                for(int i=1;i<=10;i++){
                    sum += i;
                }
                result.addValue(sum);
                result.addStr(taskName + "가 수행됨");
            }
        }

        Result result = new Result();
        Runnable task1 = new Task(result, "task1");
        Runnable task2 = new Task(result, "task2");
        Runnable task3 = new Task(result, "task3");
        Runnable task4 = new Task(result, "task4");
        Runnable task5 = new Task(result, "task5");
        Future<Result> future1 = executorService.submit(task1, result);
        Future<Result> future2 = executorService.submit(task2, result);
        Future<Result> future3 = executorService.submit(task3, result);
        Future<Result> future4 = executorService.submit(task4, result);
        Future<Result> future5 = executorService.submit(task5, result);

        try{
            result = future1.get();
            result = future2.get();
            result = future3.get();
            result = future4.get();
            result = future5.get();
            System.out.println("[처리 결과] " + result.getSum());
            System.out.println("[처리 결과] " + result.getWorkName());
            System.out.println("[작업 처리 완료]");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("[실행 예외 발생함] " + e.getMessage());
        }

        executorService.shutdown();
    }
}

class Result{
    private int sum;
    private String workName;

    public Result(){
        this.sum = sum;
        this.workName = "";
    }

    public synchronized void addValue(int sum){
        this.sum += sum;
    }

    public synchronized void addStr(String name){
        this.workName += "\n" + name;
    }

    public int getSum(){
        return this.sum;
    }

    public String getWorkName(){
        return this.workName;
    }
}