package Algorithm.DFS_BFS.Work1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class VirusProgram {
    static int tot_node;
    static int tot_network;
    static ArrayList<Pair> list;
    static LinkedList<Integer> queue;
    static boolean[] check;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        tot_node = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        tot_network = Integer.parseInt(st.nextToken());

        queue = new LinkedList<>();
        list = new ArrayList<>();
        check = new boolean[tot_node + 1];

        for(int i=0;i<tot_network;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Pair(a, b));
            list.add(new Pair(b, a));
        }

        BFS(1);
        System.out.print(result - 1);

    }

    static void BFS(int start){
        queue.add(start);

        while(!queue.isEmpty()){
            int cur_node = queue.poll();

            if(check[cur_node] == true) continue;

            check[cur_node] = true;
            result++;
            for(int i=0;i<list.size();i++){
                Pair p = list.get(i);
                if(p.getX() == cur_node){
                    queue.add(p.getY());
                }
            }
        }
    }
}
