package LambdaPractice;

import LambdaPractice.Model.Member;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ConstructorReferencesPractice {
    public static void main(String[] args){
        Function<String, Member> function = Member :: new;
        Member member1 = function.apply("angel");

        BiFunction<String, String, Member> function2 = Member :: new;
        Member member2 = function2.apply("신천사","angel");


    }
}
