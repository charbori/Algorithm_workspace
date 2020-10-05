package Algorithm.Graph.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class FindMinCost {
    static ArrayList<Pair>[] road_list;
    static int tot_terminal;
    static int tot_road;
    static int departure;
    static int arrival;
    static int dist[];
    static boolean check[];
    static PriorityQueue<Pair> queue;
    static final int INF = 200_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        tot_terminal = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        tot_road = Integer.parseInt(st.nextToken());

        road_list = new ArrayList[tot_terminal + 1];
        dist = new int[tot_terminal + 1];
        check = new boolean[tot_terminal + 1];
        queue = new PriorityQueue<>();

        for(int i=0;i<tot_terminal + 1;i++) {
            road_list[i] = new ArrayList<>();
        }

        for(int i=0;i<tot_road;i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            road_list[start].add(new Pair(target, distance));
        }

        st = new StringTokenizer(br.readLine());

        departure = Integer.parseInt(st.nextToken());
        arrival = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(departure, arrival));

    }

    static int dijkstra(int start, int end){
        Arrays.fill(dist,INF);
        Arrays.fill(check,false);

        dist[start] = 0;
        queue.add(new Pair(start, 0));

        while(!queue.isEmpty()){
            Pair cur_pair= queue.poll();
            int cur_node = cur_pair.target;
            int cur_dist = cur_pair.dis;

            if(check[cur_node] == true) continue;
            check[cur_node] = true;

            for(int i=0; i<road_list[cur_node].size();i++){
                Pair adjacent_pair = road_list[cur_node].get(i);
                if(check[adjacent_pair.target] == false && dist[adjacent_pair.target] > cur_dist + adjacent_pair.dis)
                {
                    dist[adjacent_pair.target] = cur_dist + adjacent_pair.dis;
                    queue.add(new Pair(adjacent_pair.target, dist[adjacent_pair.target]));
                }
            }
        }

        return dist[end];
    }
}
