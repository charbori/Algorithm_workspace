package Algorithm.Fastcampus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 친구네트워크 {

    static Map<String, Integer> friends;
    static int[] parents;
    static int[] relation;
    static int count;
    //static int[] rank;

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());

        friends = new HashMap<>();
        parents = new int[200001];
        relation = new int[200001];

        StringBuffer answer = new StringBuffer();

        for(int i=0;i<testCase;i++){
            friends.clear();
            count = 0;
            for(int m=0;m<parents.length;m++){
                parents[m] = m;
                relation[m] = 1;
            }

            st = new StringTokenizer(br.readLine());

            int seq = Integer.parseInt(st.nextToken());

            for(int j=0;j<seq;j++){
                st = new StringTokenizer(br.readLine());

                String node_v = st.nextToken();

                if(!friends.containsKey(node_v)){
                    friends.put(node_v, count);
                    count++;
                }

                String node_u = st.nextToken();

                if(!friends.containsKey(node_u)){
                    friends.put(node_u, count);
                    count++;
                }

                union(node_v, node_u);

                answer.append(relation[find(friends.get(node_v))] + "\n");
            }
        }

        System.out.println(answer);
    }

    static void union(String node_v, String node_u){
        int parent_v = find(friends.get(node_v));
        int parent_u = find(friends.get(node_u));

        if(parent_v < parent_u){
            parents[parent_u] = parent_v;
            relation[parent_v] += relation[parent_u];
        }else{
            parents[parent_v] = parent_u;
            relation[parent_u] += relation[parent_v];
        }
    }

    static int find(int node){
        if(parents[node] == node){
            return node;
        }
        return parents[node] = find(parents[node]);
    }
}
