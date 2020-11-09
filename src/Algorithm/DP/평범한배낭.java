package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <a href="https://www.acmicpc.net/problem/12865">12865 평범한 배낭</a>
 */
public class 평범한배낭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int arr[][] = new int[N+1][K+1];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            for(int j=1;j<=K;j++){
                if(j < X)
                    arr[i][j] = arr[i-1][j];
                else
                    arr[i][j] = Math.max(arr[i-1][j],arr[i-1][j-X] + Y);
            }
        }

        System.out.println(arr[N][K]);
    }
}
