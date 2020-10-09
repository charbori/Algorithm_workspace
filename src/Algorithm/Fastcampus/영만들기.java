package Algorithm.Fastcampus;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 영만들기 {
    static int N;
    static ArrayList<Character[]> answerList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");

        for(int i=0;i<testCase;i++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            Character[] dataArr = new Character[N-1];
            ArrayList<Integer> intArr = new ArrayList<>();
            answerList = new ArrayList<>();

            for(int j=0;j<N;j++){
                intArr.add(j+1);
            }

            fow(0, dataArr);

            Collections.sort(answerList, new Comparator<Character[]>() {
                        @Override
                        public int compare(Character[] o1, Character[] o2) {
                            String str1 = new String();
                            String str2 = new String();

                            for(int i=0;i<o1.length;i++){
                                str1 += String.valueOf(o1[i]);
                            }
                            for(int i=0;i<o2.length;i++){
                                str2 += String.valueOf(o2[i]);
                            }

                            return str1.compareTo(str2);
                        }
                    });

            for(Character[] c : answerList){
                //case start
                String str = new String();
                String strAnswer;
                String calStrArr[];
                ArrayList<Character> charStrArr = new ArrayList<>();

                int sum = 0;

                for(int j=0;j<c.length;j++){
                    str += String.valueOf((j+1));
                    str += c[j];
                }
                str += String.valueOf(N);

                strAnswer = new String(str);
                str = str.replaceAll(" ","");

                //수정된 숫자 배열
                calStrArr = str.split("\\+|\\-");

                //공백 문자가 빠진 문자 배열
                for(char ch : str.toCharArray()){
                    if(ch == '+'){
                        charStrArr.add(ch);
                    }else if(ch == '-'){
                        charStrArr.add(ch);
                    }
                }

                sum = Integer.parseInt(calStrArr[0]);

                for(int k=0;k<charStrArr.size();k++){
                    if(charStrArr.get(k) == '+'){
                        sum += Integer.parseInt(calStrArr[k+1]);
                    }else if(charStrArr.get(k) == '-')
                        sum -= Integer.parseInt(calStrArr[k+1]);
                }

                if(sum == 0){
                    System.out.println(strAnswer);
                }
            }
        }
    }

    static void fow(int idx, Character c[]){
        if(c.length == idx){
            answerList.add(c.clone());
            return ;
        }

        if(idx < N - 1){
            c[idx] = '+';
            fow(idx + 1, c);
            c[idx] = '-';
            fow(idx + 1, c);
            c[idx] = ' ';
            fow(idx + 1, c);
        }
    }
}
