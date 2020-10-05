package Algorithm.Graph.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DijkstraPrintVertex {

    static ArrayList<Pair>[] road_list;
    static int tot_terminal;
    static int tot_road;
    static int departure;
    static int arrival;
    static int dist[][];
    static boolean check[];
    static PriorityQueue<Pair> queue;
    static final int INF = 200_000_000;
    static int D_NODE = 0;
    static int D_DISTANCE = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        tot_terminal = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        tot_road = Integer.parseInt(st.nextToken());

        road_list = new ArrayList[tot_terminal + 1];
        check = new boolean[tot_terminal + 1];
        queue = new PriorityQueue<>();
        dist = new int[tot_terminal + 1][2];

        for(int i=0;i<tot_terminal + 1;i++) {
            road_list[i] = new ArrayList<>();
            dist[i][D_DISTANCE] = INF;
            dist[i][D_NODE] = 0;
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

        System.out.println("result: " + dijkstra(departure, arrival));

        int path = arrival;

        System.out.print(departure + "->");
        while(dist[path][D_NODE] != departure){
            System.out.print(dist[path][D_NODE] + "->");
            path = dist[path][D_NODE];
        }
        System.out.print(arrival);

    }

    static int dijkstra(int start, int end){
        for(int i=0;i<tot_terminal + 1;i++) {
            dist[i][D_NODE] = start;
        }

        dist[start][D_DISTANCE] = 0;

        queue.add(new Pair(start, 0));

        while(!queue.isEmpty()){
            Pair cur_pair = queue.poll();
            int cur_node = cur_pair.target;
            int cur_dist = cur_pair.dis;

            if(check[cur_node] == true) continue;
            check[cur_node] = true;

            for(int i=0;i<road_list[cur_node].size();i++){
                Pair adjacent_pair = road_list[cur_node].get(i);
                int next_node = adjacent_pair.target;
                int next_dist = adjacent_pair.dis;

                if(check[next_node] == false && dist[next_node][D_DISTANCE] > cur_dist + next_dist){
                    dist[next_node][D_DISTANCE] = cur_dist + next_dist;
                    queue.add(new Pair(next_node, dist[next_node][D_DISTANCE]));
                    dist[cur_node][D_NODE] = next_node;
                }
            }
        }


        return dist[end][D_DISTANCE];
    }
}
