package Algorithm.Fastcampus;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수정렬하기3 {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int []src = new int[10001];

        for(int i=0;i<N;i++){
            int val1 = Integer.parseInt(br.readLine());
            src[val1] += 1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; i<10001;i++){
            for(int j=0;j<src[i];j++){
                bw.write(Integer.toString(i) + "\n");
            }
        }
    }
}
