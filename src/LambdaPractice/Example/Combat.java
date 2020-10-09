package LambdaPractice.Example;

import java.util.Random;

public class Combat {
    Pitcher p;
    Hitter h;

    public Combat(Pitcher p, Hitter h){
        this.p = p;
        this.h = h;
    }

    public boolean process(){
        Random rand = new Random();

        if((p.getERA() + rand.nextInt(200) ) > (h.getbAvg() + rand.nextInt(200))){
            return true;
        }else
            return false;
    }
}
