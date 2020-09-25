package Algorithm.Graph.Union_Find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Union_find {

    static int[] parent;
    static int[] relation;
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = 8;
        parent = new int[n + 1];
        relation = new int[n + 1];

        for(int i=1;i<=n;i++){
            parent[i] = i;
            relation[i] = 1;
        }

        int idx_test_count = Integer.parseInt(st.nextToken());
        int idx = 0;

        while(idx < idx_test_count){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(find_parent(x) != find_parent(y))
            {
                union(x, y);
                relation_update(find_parent(x));
            }

            check_relation();

            idx++;
        }

        for(int i=1;i<n+1;i++){
            System.out.print(relation[i] + " ");
        }

    }

    static int find_parent(int x){
        if(x == parent[x])
        {
            return x;
        }
        else
        {
            int p = find_parent(parent[x]);
            parent[x] = p;

            return p;
        }
    }

    static void check_relation(){
        int i = 1;

        while(i < n){
            int idx = parent[i];

            relation[i] = relation[idx];

            i++;
        }
    }

    static void relation_update(int x){
        relation[x]++;
    }

    static void union(int x, int y){
        x = find_parent(x);
        y = find_parent(y);

        if(x != y)
        {
            parent[y] = x;
        }
    }
}