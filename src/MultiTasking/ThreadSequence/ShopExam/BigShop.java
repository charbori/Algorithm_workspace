package MultiTasking.ThreadSequence.ShopExam;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class BigShop {
    private final String name;
    private final Random random;

    public BigShop(String name){
        this.name = name;
        random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    public Future<Double> getAsyncPrice(String product){
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(
                () -> {
                    double price = calculatePrice(product);
                    futurePrice.complete(price);
                }
        ).start();
        return futurePrice;
    }

    public Future<Double> getSimpleAsyncPrice(String product){
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    private double calculatePrice(String product){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public String getName(){
        return this.name;
    }
}
