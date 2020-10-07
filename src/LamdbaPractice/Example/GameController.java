package LamdbaPractice.Example;

import java.util.function.Predicate;

public class GameController {

    GameData gameData;

    public GameController(){
        this.gameData = new GameData(new Score(0, 0));
    }

    public void process(){

        Hitter hitter = new Hitter(177, 21, 103, 11, "third base", "arenado", 309);
        Hitter hitter2 = new Hitter(177, 21, 103, 11, "second base", "jose", 299);
        Hitter hitter3 = new Hitter(177, 21, 103, 11, "first base", "choo", 289);
        Hitter hitter4 = new Hitter(177, 21, 103, 11, "shortstop base", "ryu", 279);
        Hitter hitter5 = new Hitter(177, 21, 103, 11, "out fielder", "manny", 269);
        gameData.addHitter(hitter);
        gameData.addHitter(hitter2);
        gameData.addHitter(hitter3);
        gameData.addHitter(hitter4);
        gameData.addHitter(hitter5);

        Pitcher pitcher = new Pitcher(177, 21, 103, 11, "starter", "cole", 123);
        Pitcher pitcher2 = new Pitcher(177, 21, 103, 11, "starter", "kim", 394);
        Pitcher pitcher3 = new Pitcher(177, 21, 103, 11, "longrelief", "hirky", 384);
        Pitcher pitcher4 = new Pitcher(177, 21, 103, 11, "closer", "jack", 239);
        Pitcher pitcher5 = new Pitcher(177, 21, 103, 11, "bullpen", "danaka", 304);
        gameData.addPitcher(pitcher);
        gameData.addPitcher(pitcher2);
        gameData.addPitcher(pitcher3);
        gameData.addPitcher(pitcher4);
        gameData.addPitcher(pitcher5);

        GameCalculator cal = new GameCalculator(gameData);
        cal.printAllHitterInfo(t -> t.getbAvg());
        cal.printAllHitterInfo(t -> t.getName());

        cal.printAllPitcherInfo(t -> t.getERA());
        cal.printAllPitcherInfo(t -> t.getName());

        cal.printPredicateHitterInfo(t -> t.getType().equals("out fielder"),
                t -> t.getName());
        cal.printPredicatePitcherInfo(t -> t.getType().equals("starter"),
                t -> t.getName());

        int result = cal.printOperatorPitcherInfo((a, b) -> {
            return ((Integer) a < (Integer) b) ? a : b;
        });
        System.out.println("[가장 뛰어난 투수] " + result);

        result = cal.printOperatorPitcherInfo((a, b) -> {
            return ((Integer) a > (Integer) b) ? a : b;
        });
        System.out.println("[era 높은 투수] " + result);

        int result_hitter = cal.printOperatorHitterInfo((a, b) ->{
            return ((Integer) a > (Integer) b) ? a : b;
        }, t -> t.getbAvg());
        System.out.println("[타율 높은 타자] " + result_hitter);
    }
}
