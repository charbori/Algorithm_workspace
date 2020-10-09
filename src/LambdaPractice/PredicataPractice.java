package LambdaPractice;

import LambdaPractice.Model.StudentWithSex;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicataPractice {
    private static List<StudentWithSex> list = Arrays.asList(
            new StudentWithSex("홍길동", "남자", 99),
            new StudentWithSex("도곡", "남자", 92),
            new StudentWithSex("강하", "남자", 93),
            new StudentWithSex("최열", "여자", 99),
            new StudentWithSex("김덕수", "여자", 91)
    );

    public static double avg( Predicate<StudentWithSex> predicate ){
        int count = 0, sum = 0;
        for(StudentWithSex StudentWithSex : list){
            if( predicate.test(StudentWithSex)){
                count++;
                sum += StudentWithSex.getEnglish_score();
            }
        }
        return (double) sum / count;
    }

    public static void main(String[] args){
        double male_result = avg(t -> t.getSex().equals("남자"));
        double female_result = avg(t -> t.getSex().equals("여자"));

        System.out.println(male_result + " " + female_result);

    }
}


