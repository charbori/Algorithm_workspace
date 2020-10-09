package LambdaPractice;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;

public class ConsumerPractice {
    public static void main(String[] args){
        Consumer<String> consumer = t -> System.out.println(t + "8");
        consumer.accept("java");

        BiConsumer<String, String> biConsumer = (t, u) -> System.out.println(t + u);
        biConsumer.accept("java", "8");

        DoubleConsumer doubleConsumer = d -> System.out.println(d);
        doubleConsumer.accept(8.0);

        ObjIntConsumer<String> objIntConsumer = (t, i) -> System.out.println(t + i);
        objIntConsumer.accept("java", 8);
    }
}
