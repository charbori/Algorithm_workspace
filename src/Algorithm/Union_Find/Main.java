package Algorithm.Union_Find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static HashMap<String, Integer> map;
    static Long answer = 1L;
    static int parent[], relation[];

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder answer = new StringBuilder();

        map = new HashMap<>();

        int test_case = Integer.parseInt(st.nextToken());
        int idx_test_case = 0;

        while(idx_test_case < test_case)
        {
            st = new StringTokenizer(br.readLine());

            int network_case = Integer.parseInt(st.nextToken());
            network_case += 1;
            int idx_network = 1;
            int idx_friend = 1;

            map = new HashMap<>();
            relation = new int[network_case * 2 + 1];
            parent = new int[network_case * 2 + 1];
            Arrays.fill(relation, 1);

            while(idx_network < network_case)
            {
                st = new StringTokenizer(br.readLine());

                String x = st.nextToken();
                String y = st.nextToken();

                if(!map.containsKey(x)){
                    map.put(x, idx_friend);
                    parent[idx_friend] = idx_friend;
                    idx_friend++;
                }

                if(!map.containsKey(y)){
                    map.put(y, idx_friend);
                    parent[idx_friend] = idx_friend;
                    idx_friend++;
                }

                union(map.get(x), map.get(y));

                //update_relation();

                idx_network++;

                answer.append(relation[find_parent(map.get(x))] + "\n");
            }


            idx_test_case++;
        }

        System.out.print(answer.toString());

    }

    static int find_parent(int idx_name)
    {

        if(parent[idx_name] == idx_name)
        {
            return idx_name;
        }

        return parent[idx_name] = find_parent(parent[idx_name]);
    }

    static void union(int u, int v)
    {
        u = find_parent(u);
        v = find_parent(v);

        if(u==v) return;
        parent[u] = v;
        relation[v] += relation[u];

    }

}