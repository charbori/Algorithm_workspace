package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 타일 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int DIVISION = 15746;

        int N = Integer.parseInt(st.nextToken());

        int[] dp = new int[1000001];

        dp[1] = 1;
        dp[2] = 2;

        for(int k=3;k <= N;k++){
            dp[k] = (dp[k-2] + dp[k-1]) % DIVISION;
        }
        System.out.print(dp[N]);

    }

}
