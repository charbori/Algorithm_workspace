package Algorithm.Graph.MST.Prim;

import Algorithm.Graph.MST.Kruskal.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 프림 {
    static int tot_line;
    static int tot_node;

    static ArrayList<Pair>[] line_list;
    static ArrayList<Pair> result_list;
    static PriorityQueue<Pair> queue;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        tot_node = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        tot_line = Integer.parseInt(st.nextToken());

        line_list = new ArrayList[tot_node + 1];
        result_list = new ArrayList<>();
        check = new boolean[tot_node + 1];
        queue = new PriorityQueue<>();

        for(int i=0;i<tot_node + 1;i++){
            line_list[i] = new ArrayList<>();
        }

        for (int i = 0; i < tot_line; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            line_list[start].add(new Pair(start, target, distance));
            line_list[target].add(new Pair(target, start, distance));
        }

        prim(1);

        for (Pair p : result_list){
            System.out.println(p.start + " " + p.target + " " + p.value);
        }
    }

    static public void prim(int start){

//        for(int i=0;i<line_list[start].size();i++){
//            queue.add(line_list[start].get(i));
//        }
        queue.add(new Pair(start, start, 0));

        while(!queue.isEmpty()){
            Pair node_pair = queue.poll();

            if(check[node_pair.target] == true) continue;
            check[node_pair.target] = true;
            result_list.add(node_pair);

            for(int i=0;i<line_list[node_pair.target].size();i++){
                Pair adjacent_node = line_list[node_pair.target].get(i);
                if(check[adjacent_node.target] == false)
                    queue.add(adjacent_node);
            }
        }
    }
}
