package LamdbaPractice;

import LamdbaPractice.Model.Fruit;

import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

public class OperatorMinByMaxPractice {
    public static void main(String[] args){
        BinaryOperator<Fruit> binaryOperator;
        Fruit fruit;

        binaryOperator = BinaryOperator.minBy((f1,f2)->Integer.compare(f1.price, f2.price));
        fruit = binaryOperator.apply(new Fruit("딸기", 6000), new Fruit("수박", 10000));
        System.out.println(fruit.name);

        binaryOperator = BinaryOperator.maxBy((f1,f2)->Integer.compare(f1.price, f2.price));
        fruit = binaryOperator.apply(new Fruit("메론", 9000), new Fruit("망고", 5000));
        System.out.println(fruit.name);

        IntBinaryOperator operator = Math :: max;
        Calculator obj = new Calculator();
        operator = (x, y) -> obj.instanceMethod(x, y);
        System.out.println("결과3:" + operator.applyAsInt(5, 6));

        operator = obj :: instanceMethod;
        System.out.println("결과4:" + operator.applyAsInt(7,8));

    }
}
