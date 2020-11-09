package MultiTasking.ThreadSequence.ShopExam;

import com.sun.xml.internal.ws.util.CompletedFuture;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

//https://pjh3749.tistory.com/280

public class PriceFinder {
    private final List<BigShop> shops = Arrays.asList(
            new BigShop("cool"),
            new BigShop("card"),
            new BigShop("board"),
            new BigShop("clothes"),
            new BigShop("sunglass")
    );

    public String findPrices(String product){
        boolean existProduct = shops.stream().anyMatch(shop -> shop.getName().equals(product));
        System.out.println(product);
        if(existProduct){
            Future<Double> priceRe;
            for(BigShop shop : shops){

                if(shop.getName().equals(product)){
                    priceRe = shop.getSimpleAsyncPrice(product);
                    try {
                        return new String("가격은 " + priceRe.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            }

        }else{
            return "해당 상품이 없음";
        }

        return new String("에러!");
    }
}
