package LambdaPractice;

import LambdaPractice.Model.Student;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

public class OperationPractice {
    private static List<Student> list = Arrays.asList(
            new Student("길동", 99, 97),
            new Student("길동", 99, 97)
    );

    public static double avg(ToIntFunction<Student> function){
        int sum = 0;
        for(Student student : list){
            sum += function.applyAsInt(student);
        }
        double avg = (double) sum / list.size();
        return avg;
    }

    public static void main(String[] args){
        double englishAvg = avg(t -> t.getEnglish_score());
        System.out.println("영어 평균 점수 : " + englishAvg);

        double mathAvg = avg(t -> t.getMath_score());
        System.out.println("수학 평균 점수 : " + mathAvg);

    }
}
