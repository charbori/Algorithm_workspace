package Algorithm.Fastcampus;

import sun.awt.image.ImageWatched;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class 키로거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());
        String data = "";


        for(int i=0;i<testCase;i++){
            LinkedList<Character> queue = new LinkedList<>();
            Stack<Character> stack = new Stack<>();

            st = new StringTokenizer(br.readLine());
            data = st.nextToken();
            StringBuffer strBuffer = new StringBuffer();

            char[] dataArr = data.toCharArray();

            for(int j=0;j<dataArr.length;j++){
                if(dataArr[j] == '<'){
                    if(stack.size() > 0){
                        queue.push(stack.pop());
                    }
                }else if(dataArr[j] == '>'){
                    if(queue.size() > 0){
                        stack.push(queue.pollFirst());
                    }
                }
                //문자 삭제
                else if(dataArr[j] == '-'){
                    if(stack.size() > 0){
                        stack.pop();
                    }
                }
                //문자 추가
                else{
                    stack.push(dataArr[j]);
                }
            }

            while(!queue.isEmpty()){
                stack.push(queue.pollFirst());
            }

            String result = stack.toString();

            result = result.replaceAll(", ","");
            result = result.replace("[","");
            result = result.replace("]","");

            System.out.println(result);
        }
    }
}
