package Algorithm.DFS_BFS.Work1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import Lib_collection.Queue;

import java.util.Collections;
import java.util.StringTokenizer;


public class DFSBFS {

    static int n, m, s;
    static ArrayList<Integer>[] list;
    static Queue<Integer> queue;
    static ArrayList<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        answer = new ArrayList<>();
        queue = new Queue<Integer>();
        list = new ArrayList[n + 1];

        for(int i=0;i<n+1;i++){
            list[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int data1 = Integer.parseInt(st.nextToken());
            int data2 = Integer.parseInt(st.nextToken());

            list[data1].add(data2);
            list[data2].add(data1);
        }

        for (int i = 1; i < n + 1; i++) {
            Collections.sort(list[i]);
        }

        dfs(s);
        while(!answer.isEmpty()){
            System.out.print(answer.get(0) + " ");
            answer.remove(0);
        }

        answer.clear();
        System.out.println();

        bfs(s);
        while(!answer.isEmpty()){
            System.out.print(answer.get(0) + " ");
            answer.remove(0);
        }

    }

    static void dfs(int x){
        ArrayList<Integer> idx_start_list = list[x];

        answer.add(x);

        for(int i=0;i<idx_start_list.size();i++){
            if(!answer.contains(idx_start_list.get(i))){
                dfs(idx_start_list.get(i));
            }
        }
    }

    static void bfs(int x){

        ArrayList<Integer> idx_start_list = list[x];

        queue.add(x);

        while(!queue.isEmpty()){
            int target = (int) queue.poll();

            idx_start_list = list[target];

            if(!answer.contains(target)) {
                answer.add(target);
            }

            for(int i=0;i<idx_start_list.size();i++){
                if(!answer.contains(idx_start_list.get(i))){
                    answer.add(idx_start_list.get(i));
                    queue.add(idx_start_list.get(i));
                }
            }
        }
    }
}

