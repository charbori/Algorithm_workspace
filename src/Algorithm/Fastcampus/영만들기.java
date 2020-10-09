package Algorithm.Fastcampus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 영만들기 {
    static int N;
    static ArrayList<Character[]> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        for(int i=0;i<testCase;i++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            Character[] dataArr = new Character[N * 2 - 1];

            for(int j=0;j<N;j++){
                dataArr[j*2] = (char)(j + 49);
            }

            fow( N-1, dataArr);

            for(Character[] c : list){
                String str = "";
                for(int k=0;k<N-1;k++){
                    //str += ()
                }
            }
        }

    }

    static void fow(int idx, Character[] charArr){
        if(charArr.length == idx){
            list.add(charArr.clone());
            return ;
        }

        if(idx * 2 + 1 < N * 2 - 1){
            charArr[idx * 2 + 1] = '+';
            fow(idx * 2 + 1, charArr);
            charArr[idx * 2 + 1] = '-';
            fow(idx * 2 + 1, charArr);
            charArr[idx * 2 + 1] = ' ';
            fow(idx * 2 + 1, charArr);
        }
    }
}
