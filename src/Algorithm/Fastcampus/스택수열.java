package Algorithm.Fastcampus;

import sun.awt.image.ImageWatched;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        ArrayList<Integer> n_list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        LinkedList<String> result = new LinkedList<>();

        boolean check[] = new boolean[n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            n_list.add(Integer.parseInt(st.nextToken()));
        }

        int cur_val = 1;
        int stack_val = 0;
        boolean sign = true;

        for(int i=0;i<n;i++){
            int target = n_list.get(i);

            if(target > stack_val){
                while(target > stack_val){
                    stack.push(cur_val);
                    result.push("+");
                    stack_val = cur_val;
                    cur_val++;
                }
                //System.out.println(stack_val);
                stack_val = stack.pop();
                if(target == stack_val){
                    check[i] = true;
                }
                if(!stack.isEmpty())
                    stack_val = stack.peek();
                else
                    stack_val = 0;
                result.push("-");
            }else if(target < stack_val){
                while(target < stack_val){
                    stack.pop();
                    stack_val = stack.peek();
                    result.push("-");
                }
                stack_val = stack.pop();
                //System.out.println(stack_val);
                if(target == stack_val){
                    check[i] = true;
                }
                stack_val--;
                result.push("-");
            }else{
                while(!stack.isEmpty()){
                    stack_val = stack.pop();
                    if(stack_val == target){
                        //System.out.println(stack_val);
                        result.push("-");
                        check[i] = true;
                        if(!stack.isEmpty())
                            stack_val = stack.peek();
                        break;
                    }
                }
            }
        }

        for(boolean b : check){
            if(!b)
                sign = false;
        }

        if(sign){
            while(!result.isEmpty()){
                System.out.println(result.pollLast());
            }
        }else{
            System.out.println("NO");
        }
    }
}
