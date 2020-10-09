package LambdaPractice.Model;

public class Student{
    String name;
    int math_score;
    int english_score;

    public Student(String name, int math, int english){
        this.name = name;
        this.math_score = math;
        this.english_score = english;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMath_score() {
        return math_score;
    }

    public void setMath_score(int math_score) {
        this.math_score = math_score;
    }

    public int getEnglish_score() {
        return english_score;
    }

    public void setEnglish_score(int english_score) {
        this.english_score = english_score;
    }
}