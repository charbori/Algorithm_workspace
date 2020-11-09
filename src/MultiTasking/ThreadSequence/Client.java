package MultiTasking.ThreadSequence;

import MultiTasking.ThreadSequence.ShopExam.BigShop;
import MultiTasking.ThreadSequence.ShopExam.PriceFinder;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) {
        PriceFinder priceFinder = new PriceFinder();
        long start = System.nanoTime();

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("[가격] " + priceFinder.findPrices("cool"));

                long end = (System.nanoTime() - start)/ 1_000_000;

                System.out.println("[수행 시간] " + end + "msec");
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("[가격] " + priceFinder.findPrices("brand"));

                long end = (System.nanoTime() - start)/ 1_000_000;

                System.out.println("[수행 시간] " + end + "msec");
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("[가격] " + priceFinder.findPrices("board"));

                long end = (System.nanoTime() - start)/ 1_000_000;

                System.out.println("[수행 시간] " + end + "msec");
            }
        });

        executorService.shutdown();

        long end = (System.nanoTime() - start)/ 1_000_000;

        System.out.println("[수행 시간] " + end + "msec");
    }
}
