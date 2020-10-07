package LamdbaPractice;

import LamdbaPractice.Model.Member;

import java.util.function.Consumer;

public class ConsumerAndThenPractice {
    public static void main(String[] args){
        Consumer<Member> consumerA = (m) -> {
            System.out.println("consumerA : " + m.getName());
        };

        Consumer<Member> consumerB = (m) -> {
            System.out.println("consumerB : " + m.getName());
        };

        Consumer<Member> consumerAB = consumerA.andThen(consumerB);
        consumerAB.accept(new Member("홍길동", "charbori",null));
    }
}
