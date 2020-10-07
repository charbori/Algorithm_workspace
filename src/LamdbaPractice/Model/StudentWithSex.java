package LamdbaPractice.Model;

public class StudentWithSex {
    String name;
    String sex;
    int english_score;

    public StudentWithSex(String name, String sex, int english){
        this.name = name;
        this.sex = sex;
        this.english_score = english;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getEnglish_score() {
        return english_score;
    }

    public void setEnglish_score(int english_score) {
        this.english_score = english_score;
    }

}
