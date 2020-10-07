package Algorithm.Fastcampus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 수정렬하기 {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = st.nextToken();

        String strArr[] = str.split("");

        Arrays.sort(strArr, Collections.reverseOrder());

        StringBuffer answer = new StringBuffer();

        for(String s : strArr){
            answer.append(s);
        }

        System.out.println(answer);
    }
}
