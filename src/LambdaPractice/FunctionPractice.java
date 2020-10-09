package LambdaPractice;

import LambdaPractice.Model.Student;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class FunctionPractice {
    private static List<Student> list = Arrays.asList(
            new Student("길동",96, 99),
            new Student("길동",89,97)
    );

    public static void printString(Function<Student, String> function){
        for(Student student : list){
            System.out.println(function.apply(student) + " " );
        }
        System.out.println();
    }

    public static void printInt(ToIntFunction<Student> function){
        for(Student student : list){
            System.out.println(function.applyAsInt(student) + " " );
        }
    }
    public static void main(String[] args){
        printString(t -> t.getName());
        printInt(t -> t.getEnglish_score());
        printInt(t -> t.getMath_score());
    }
}
