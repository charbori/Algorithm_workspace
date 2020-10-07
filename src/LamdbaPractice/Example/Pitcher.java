package LamdbaPractice.Example;

public class Pitcher extends Player{
    int era;
    public Pitcher(int height, int age, int weight, int number, String type, String name, int era){
        super(height, age, weight, number, type, name);
        this.era = era;
    }

    public String getName(){
        return this.name;
    }

    public int getERA(){
        return this.era;
    }

    public int getNumber(){
        return this.number;
    }

    public String getType(){
        return this.type;
    }
}
