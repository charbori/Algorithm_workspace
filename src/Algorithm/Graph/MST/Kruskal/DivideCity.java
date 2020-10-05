package Algorithm.Graph.MST.Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @author jaehyeok
 * <a href="https://www.acmicpc.net/problem/1396">도시분할계획</a>
 */
public class DivideCity {
    static int tot_line;
    static int tot_node;

    static ArrayList<Pair> line_list;
    static ArrayList<Pair> result_list;

    static int parent[], rank[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        tot_node = Integer.parseInt(st.nextToken());
        tot_line = Integer.parseInt(st.nextToken());

        line_list = new ArrayList<>();
        result_list = new ArrayList<>();

        parent = new int[tot_node+1];
        rank = new int[tot_node+1];

        for(int i=0;i<tot_line;i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            line_list.add(new Pair(start, target, distance));

        }

        kruskal();

        int ans = 0;
        for(int i=0;i<line_list.size()-1;i++){
            ans += line_list.get(i).value;
        }
        System.out.print(ans);
    }

    static void union(int node_v, int node_u){
        int parent_v = find(node_v);
        int parent_u = find(node_u);

        if(rank[parent_v] > rank[parent_u]){
            parent[parent_u] = parent_v;
        }else if(rank[parent_v] == rank[parent_u]){
            rank[parent_u] += 1;
            parent[parent_u] = parent_v;
        }else{
            parent[parent_v] = parent_u;
        }
    }

    static int find(int node_v){
        if(parent[node_v] != node_v){
            return parent[node_v] = find(parent[node_v]);
        }
        return node_v;
    }

    static void kruskal(){
        int ans = 0, max = -1;
        line_list.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.compareTo(o2);
            }
        });

        for(int i=0;i<tot_node;i++){
            parent[i] = i;
            rank[i] = i;
        }

        for(int i=0;i<line_list.size();i++){
            if(find(line_list.get(i).start) != find(line_list.get(i).target)){
                union(line_list.get(i).start, line_list.get(i).target);
                result_list.add(line_list.get(i));

                //max = Math.max(line_list.get(i).value, max);
                //ans += line_list.get(i).value;
            }
        }
        //System.out.println(ans - max);
    }

}
