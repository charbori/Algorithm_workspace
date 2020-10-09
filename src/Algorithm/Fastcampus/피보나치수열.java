package Algorithm.Fastcampus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;
import java.util.StringTokenizer;

public class 피보나치수열 {

    static int[] data;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        int arr[] = new int[46];

        arr[0] = 0;
        arr[1] = 1;

        data = new int[46];
        data[0] = 0;
        data[1] = 1;

        for(int i=2;i<=N;i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        pibo(45);

        System.out.println(arr[N]);
        System.out.println(data[N]);
    }

    static int pibo(int idx){
        if(idx <= 1){
            return data[idx];
        }
        return data[idx] = (pibo(idx-1) + pibo(idx-2));
    }
}
