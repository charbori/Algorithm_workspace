package MultiTasking.ThreadSequence;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        System.out.println("[작업 처리 요청]");
        Callable<Integer> task = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for(int i=0;i<=10;i++){
                    sum += i;
                }
                return sum;
            }
        };

        List<Shop> list = new ArrayList<>();
        list.add(new Shop(1000,"연필"));
        list.add(new Shop(2000,"공책"));
        list.add(new Shop(3000,"필통"));


        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {

                System.out.println("최저가 알아내기");

                int price = Integer.MAX_VALUE;

                for(Shop s : list){
                    price = Math.min(price, s.price);
                }

                return price;
            }
        });

        try{
            int sum = future.get();
            System.out.println("[처리 결과] " + sum);
            System.out.println("[작업 처리 완료]");
        }catch (Exception e){
            System.out.println("[실행 예외 발생함]" + e.getMessage());
        }
    }
}
