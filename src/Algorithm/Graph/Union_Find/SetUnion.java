package Algorithm.Graph.Union_Find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SetUnion {

    static HashMap<Integer, Integer> map;
    static int[] num_arr;
    static int n,m;

    public static void main(String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        map = new HashMap<>();
        num_arr = new int[m];
        int num_idx = 0;

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int routine = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            //합집합
            if(routine == 0)
            {
                if(!map.containsKey(u))
                {
                    map.put(u,u);
                }
                if(!map.containsKey(v))
                {
                    map.put(v,v);
                }

                union(u,v);
            }
            else
            {
                if(map.containsKey(u) && map.containsKey(v))
                {
                    if(find_head(u) == find_head(v))
                    {
                        sb.append("YES" + "\n");
                    }
                    else
                    {
                        sb.append("NO" + "\n");
                    }
                }
                else
                {
                    sb.append("NO" + "\n");
                }
            }
        }
        System.out.print(sb.toString());
    }

    static int find_head(int u){
        if(map.get(u) == u)
            return u;
        return find_head(map.get(u));
    }

    static void union(int u, int v){
        u = find_head(u);
        v = find_head(v);

        if(u==v)
            return;

        map.put(u, v);
    }
}
