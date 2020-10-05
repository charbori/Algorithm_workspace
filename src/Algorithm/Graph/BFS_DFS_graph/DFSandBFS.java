package Algorithm.Graph.BFS_DFS_graph;

/**
 * @see <a href="https://www.acmicpc.net/problem/1260">DFS and BFS</a>
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class DFSandBFS {

    static int n;
    static int m;
    static int s;

    static ArrayList<Node> data_hash_key;
    static ArrayList<Node> data_hash_value;

    static int move_x[] = {0,0,1,-1};
    static int move_y[] = {1,-1,0,0};

    static ArrayList<Integer> stack;
    static LinkedList<Integer> visited;
    static LinkedList<Integer> need_visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        data_hash_key = new ArrayList<>();
        data_hash_value = new ArrayList<>();

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            if(data_hash_key.contains(node1))
            {
                data_hash_key.get(node1).addValue(node2);
            }
            else
            {
                data_hash_key.add(new Node(node1, node2));
            }

            if(data_hash_value.contains(node2))
            {
                data_hash_value.get(node2).addValue(node1);
            }
            else
            {
                data_hash_value.add(new Node(node2, node1));
            }

        }

        stack = new ArrayList<>();
        visited = new LinkedList<>();
        need_visit = new LinkedList<>();

        DFS(s);

        while(!visited.isEmpty()){
            System.out.print(visited.poll()+ " ");
        }
        System.out.println();

        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                BFS(i, j);
            }
        }

        while(!stack.isEmpty()){
            System.out.print(stack.get(0) + " ");
            stack.remove(0);
        }
    }

    static void BFS(int x, int y){

        for(int i=0;i<4;i++){
            int moved_x = x + move_x[i];
            int moved_y = y + move_y[i];

            if(!stack.contains(x))
                stack.add(x);
            if(!stack.contains(y))
                stack.add(y);
//
//            checked_arr[x][y] = 1;
//            // 1 <= moved_x < n + 1
//            // &&
//            // 1 <= moved_y < n + 1
//            if(moved_x >= 1  &&  moved_x < n + 1  &&  moved_y >= 1  &&  moved_y < n + 1){
//                if(arr[moved_x][moved_y] == 1 && checked_arr[moved_x][moved_y] == 0){
//                    BFS(moved_x, moved_y);
//                }
//            }
        }
    }

    static void DFS(int s) {
        for (int i = 1; i < n + 1; i++) {
            if (data_hash_key.contains(s)) {
                if (!need_visit.contains(s))
                    need_visit.add(s);
            }

            if (data_hash_value.contains(s)) {
                if (!need_visit.contains(s))
                    need_visit.add(s);
            }
        }
    }
}

/**
 *
 */
class Node{
    int x;
    ArrayList<Integer> y;
    public Node(int x, int y){
        this.x = x;
        this.y = new ArrayList<>();
        this.y.add(y);
    }

    void addValue(int y){
        this.y.add(y);
    }
}

