package Algorithm.순열조합.Permutation;

import Algorithm.순열조합.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 일곱난쟁이 {

    static ArrayList<Pair> visited;
    static LinkedList<Pair> need_visit;

    static int[] heights;
    static ArrayList<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        visited = new ArrayList<>();
        need_visit = new LinkedList<>();

        heights = new int[9];
        heights[0] = Integer.parseInt(st.nextToken());
        stack = new ArrayList<>();

        for(int i = 1;i<9;i++)
        {
            st = new StringTokenizer(br.readLine());
            heights[i] = Integer.parseInt(st.nextToken());
        }

        BF(0);
    }

    static void BF(int idx){
        if(stack.size() == 7){
            int sum = 0;
            for(int i:stack){
                sum += i;
            }
            if(sum == 100){
                Collections.sort(stack);
                for(int i:stack){
                    System.out.println(i);
                }
            }
            return ;
        }

        for(int i=idx;i<heights.length;i++){
            stack.add(heights[i]);
            BF(i + 1);
            stack.remove(stack.size()-1);
        }
    }
}
