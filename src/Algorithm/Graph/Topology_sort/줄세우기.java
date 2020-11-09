package Algorithm.Graph.Topology_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/2252">백준 2252번 줄세우기 - 위상정렬</a>
 */
public class 줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        Stack<Integer> answer = new Stack<>();
        boolean check[] = new boolean[N + 1];
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        int[] arr = new int[N + 1];


        for(int i=0;i<list.length;i++){
            list[i] = new ArrayList<>();
        }

        int i = 0;
        while(M > i){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x]++;

            list[y].add(x);

            i++;
        }

        arr[0] = -1;

        for(int j=0;j<N+1;j++){
            if(arr[j] == 0){
                queue.add(j);
                check[j] = true;
            }
        }

        while(!queue.isEmpty()){
            int node = queue.poll();
            answer.add(node);

            for(int next : list[node]){
                arr[next]--;

                if(arr[next] == 0 && !check[next]){
                    queue.add(next);
                    check[next] = true;
                }
            }
        }

        while(!answer.isEmpty())
            System.out.print(answer.pop() + " ");

    }
}