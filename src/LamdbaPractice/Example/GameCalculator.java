package LamdbaPractice.Example;

import java.util.ArrayList;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;

public class GameCalculator {
    GameData gameData;

    public GameCalculator(GameData gameData){
        this.gameData = gameData;
    }

    public void printAllHitterInfo(Function<Hitter,Object> function){
        System.out.println("[타자 정보 출력]");
        for(Hitter h : gameData.hitterList){
            System.out.println(function.apply(h));
        }
    }

    public void printAllPitcherInfo(Function<Pitcher, Object> function){
        System.out.println("[투수 정보 출력]");
        for(Pitcher p : gameData.pitcherList){
            System.out.println(function.apply(p));
        }
    }

    public void printPredicateHitterInfo(Predicate<Hitter> predicate, Function<Hitter, Object> function){
        int count = 0;

        System.out.println("[타자 정보 출력]");

        for(Hitter hitter : gameData.hitterList){
            if(predicate.test(hitter)){
                count++;
                System.out.println(function.apply(hitter));
            }
        }
    }

    public void printPredicatePitcherInfo(Predicate<Pitcher> predicate, Function<Pitcher, Object> function){
        int count = 0;

        System.out.println("[투수 정보 출력]");

        for(Pitcher pitcher : gameData.pitcherList){
            if(predicate.test(pitcher)){
                count++;
                System.out.println(function.apply(pitcher));
            }
        }
    }

    public int printOperatorPitcherInfo(BinaryOperator operator){
        int result = gameData.pitcherList.get(0).era;
        for(Pitcher pitcher : gameData.pitcherList){
            result = (Integer) operator.apply(result, pitcher.era);
        }
        //System.out.println("[해당 조건의 era] " + result);
        return result;
    }

    public int printOperatorHitterInfo(BinaryOperator operator, Function<Hitter, Object> function){
        int result = (int) function.apply(gameData.hitterList.get(0));
        for(Hitter hitter : gameData.hitterList){
            int data = (int) function.apply(hitter);
            result = (Integer) operator.apply(result, data);
        }
        //System.out.println("[해당 조건의 era] " + result);
        return result;
    }
}
