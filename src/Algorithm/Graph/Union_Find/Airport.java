package Algorithm.Graph.Union_Find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Airport {

    static HashMap<Integer, Integer> map;
    static int[] num_arr;
    static int g, p;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        g = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());

        num_arr = new int[100001];

        for(int i=1;i<num_arr.length;i++){
            num_arr[i] = i;
        }

        int answer = 0;

        for(int i=1;i<p+1;i++){
            st = new StringTokenizer(br.readLine());

            int g = Integer.parseInt(st.nextToken());
            int p = find_parent(g);

            if (p != 0){
                union(p-1,p);
                answer++;
            }
            else
                break;

        }

        System.out.print(answer);
    }

    static boolean union(int u, int v){
        u = num_arr[u];
        v = num_arr[v];

        if(u==v){
            return false;
        }

        if(u<v)
            num_arr[v] = u;
        else
            num_arr[u] = v;

        return true;
    }

    static int find_parent(int idx){
        if(num_arr[idx] == idx) return idx;
        return num_arr[idx] = find_parent(num_arr[idx]);
    }
}
