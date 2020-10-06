package Algorithm.Graph.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class exam1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        //점의 개수
        //int s = Integer.parseInt(st.nextToken());
        //시작점
        //int n = Integer.parseInt(st.nextToken());
        //도착점
        //int e = Integer.parseInt(st.nextToken());

        Graph g = new Graph(8);

        g.input(1, 2, 3);
        g.input(1, 5, 4);
        g.input(1, 4, 4);
        g.input(2, 3, 2);
        g.input(3, 4, 1);
        g.input(4, 5, 2);
        g.input(5, 6, 4);
        g.input(4, 7, 6);
        g.input(7, 6, 3);
        g.input(3, 8, 3);
        g.input(6, 8, 2);

        g.dijkstra(1);
    }
}

class Graph{
    int map[][];
    int n;
    LinkedList<Pair> list = new LinkedList<>();

    public Graph(int n){
        this.n = n;
        map = new int[n+1][n+1];
    }

    public void input(int x, int y, int z){
        map[x][y] = z;
        map[y][x] = z;
    }

    public void dijkstra(int v){
        int distance[] = new int[n+1];
        boolean[] check = new boolean[n+1];

        for(int i=1;i<n+1;n++){
            distance[i] = Integer.MAX_VALUE;
        }

        distance[v] = 0;
        check[v] = true;

        for(int i=1;i<n+1;i++){
            if(!check[i] && map[v][i] != 0){
                distance[i] = map[v][i];
            }
        }

        for(int i=1;i<n+1;i++){
            if(map[v][i] != 0){
                list.add(new Pair(v, i));
            }
        }

        for(int i=1;i<n+1;i++){
            System.out.print(distance[i] + " ");
        }

    }
}