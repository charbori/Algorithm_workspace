package Algorithm.Union_Find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Lets_Travel {

    static HashMap<Integer, Integer> map;
    static int[] num_arr;
    static int n, m;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        num_arr = new int[n + 1];

        for(int i=1;i<n+1;i++)  num_arr[i] = i;

        sb = new StringBuilder();

        for(int i=1;i<n+1;i++){
            st = new StringTokenizer(br.readLine());

            int pos_idx = 1;

            while(st.hasMoreTokens())
            {
                int pos_val = Integer.parseInt(st.nextToken());

                if(pos_val == 1)
                    union(i,pos_idx);

                pos_idx++;

            }
        }

        st = new StringTokenizer(br.readLine());

        int answer[] = new int[m];

        int idx_answer = 0;
        while(st.hasMoreTokens())
        {
            answer[idx_answer] = Integer.parseInt(st.nextToken());
            idx_answer++;
        }

        String result = "YES";

        for(int i=0;i<m;i++){
            if(find_way(answer[0]) != find_way(answer[i])){
                result = "NO";
            }
        }

        System.out.print(result);

    }

    static int find_way(int u){
        if (num_arr[u] == u)
            return u;
        return num_arr[u] = find_way(num_arr[u]);
    }

    static void union(int u, int v){
        u = find_way(u);
        v = find_way(v);

        if (u == v)
            return ;

        num_arr[u] = v;
    }
}
