package Algorithm.Graph.MST.Kruskal;

public class Pair implements Comparable<Pair>{
    public int start;
    public int target;
    public int value;
    public Pair(int start, int target, int value){
        this.start = start;
        this.target = target;
        this.value = value;
    }

    @Override
    public int compareTo(Pair o) {
        return value - o.value;
    }
}
