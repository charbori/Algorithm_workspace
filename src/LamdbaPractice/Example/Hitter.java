package LamdbaPractice.Example;

public class Hitter extends Player{
    int bAvg;
    public Hitter(int height, int age, int weight, int number, String type, String name, int bAvg){
        super(height, age, weight, number, type, name);
        this.bAvg = bAvg;
    }

    public String getName(){
        return this.name;
    }

    public int getbAvg(){
        return this.bAvg;
    }

    public String getType(){
        return this.type;
    }
}
