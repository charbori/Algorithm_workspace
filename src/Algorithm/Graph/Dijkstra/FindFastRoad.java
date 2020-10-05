package Algorithm.Graph.Dijkstra;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FindFastRoad {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Play_Dijkstra dij = new Play_Dijkstra(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        int tot = dij.tot_road;
        int j = 0;

        for(int i=1;i< dij.n + 1;i++){
            dij.road_list[i] = new ArrayList<Pair>();
        }

        while(tot > j){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            dij.road_list[start].add(new Pair(target, distance));
            dij.road_list[target].add(new Pair(start, distance));

            j++;
        }

        st = new StringTokenizer(br.readLine());

        dij.target1 = Integer.parseInt(st.nextToken());
        dij.target2 = Integer.parseInt(st.nextToken());

        dij.play_algorithm();
    }
}

class Pair implements Comparable<Pair>{
    int target;
    int dis;

    public Pair(int pos, int dis){
        this.target = pos;
        this.dis = dis;
    }

    @Override
    public int compareTo(Pair o) {
        return dis - o.dis;
    }
}

class Play_Dijkstra{
    ArrayList<Pair>[] road_list;
    int[] dist;
    boolean[] check;
    int target1, target2;
    int n, tot_road;
    private static final int INF = 200_000_000;

    public Play_Dijkstra(int n, int k){
        this.n = n;
        this.tot_road = k;
        road_list = new ArrayList[n + 1];
        dist = new int[n+1];
        check = new boolean[n+1];
    }

    public void play_algorithm() throws IOException{
        int result1 = 0;
        int result2 = 0;

        result1 += dijkstra(1, target1);
        result1 += dijkstra(target1, target2);
        result1 += dijkstra(target2, n);

        result2 += dijkstra(1, target2);
        result2 += dijkstra(target2, target1);
        result2 += dijkstra(target1, n);

        if(result1 >= INF && result2 >= INF) System.out.print(-1);
        else System.out.print(Math.min(result1, result2));
    }

    public int dijkstra(int start, int end){
        Arrays.fill(dist, INF);
        Arrays.fill(check, false);

        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(start, 0));
        dist[start] = 0;

        while(!queue.isEmpty()){
            Pair curPoint = queue.poll();
            int curNode = curPoint.target;
            int curDis = curPoint.dis;

            if(check[curNode] == true)    continue;
            check[curNode] = true;

            for(int i=0;i<road_list[curNode].size();i++){
                int nextNode = road_list[curNode].get(i).target;
                int nextDis = road_list[curNode].get(i).dis;

                if(check[nextNode] == false && dist[nextNode] > curDis + nextDis){
                    dist[nextNode] = curDis + nextDis;
                    queue.add(new Pair(nextNode, dist[nextNode]));
                }
            }
        }

        return dist[end];
    }
}