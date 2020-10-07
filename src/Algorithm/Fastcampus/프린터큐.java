package Algorithm.Fastcampus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 프린터큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        LinkedList<Pair> list = new LinkedList<>();

        int testCase = Integer.parseInt(st.nextToken());

        //test case
        for(int i=0;i<testCase;i++){
            int result = 0;

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int idx_p = 0;

            while(st.hasMoreTokens()) {
                int value = Integer.parseInt(st.nextToken());
                queue.add(value);
                list.add(new Pair(idx_p, value));
                idx_p++;
            }

            int count = 0;
            while(!queue.isEmpty()){
                int target = queue.poll();
                Pair p = list.pollFirst();

                count += 1;

                while(!list.isEmpty() && target != p.value){
                    list.add(p);
                    p = list.pollFirst();
                }

                if(idx == p.idx){
                    System.out.println(count);
                }
            }
        }
    }
}

class Pair{
    int idx;
    int value;
    public Pair(int idx, int value){
        this.idx = idx;
        this.value = value;
    }
}
