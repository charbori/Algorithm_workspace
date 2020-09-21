package Algorithm.Union_Find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SetUnionArr {

    static int[] num_arr;
    static int n,m;

    public static void main(String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        num_arr = new int[n + 1];
        for(int j=0;j<n+1;j++){
            num_arr[j] = j;
        }
        int num_idx = 0;

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int routine = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            //합집합
            if(routine == 0)
            {
                if(!search(u)){
                    num_arr[u] = u;
                }

                if(!search(v)){
                    num_arr[v] = v;
                }

                union(u,v);
            }
            else
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
        }
        System.out.print(sb.toString());
    }

    static int find_head(int u){
        if(num_arr[u] == u)
            return u;
        return num_arr[u] = find_head(num_arr[u]);
    }

    static boolean search(int target){


        if(num_arr[target] != -1)
            return true;
        else
            return false;
    }

    static void union(int u, int v){
        u = find_head(u);
        v = find_head(v);

        if(u==v)
            return;

        num_arr[u] = v;
    }
}
