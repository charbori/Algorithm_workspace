package Algorithm.Fastcampus.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택수열 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();
        LinkedList<String> result = new LinkedList<>();

        int count = 1;

        for(int i=1;i<n+1;i++){
            st = new StringTokenizer(br.readLine());

            int data = Integer.parseInt(st.nextToken());

            while(count <= data){
                stack.push(count);
                count += 1;
                result.push("+");
            }
            if(stack.peek() == data){
                stack.pop();
                result.push("-");
            }
            else
            {
                System.out.println("NO");
                break;
            }
        }

        while(!result.isEmpty())
            System.out.println(result.pollLast());
    }
}
