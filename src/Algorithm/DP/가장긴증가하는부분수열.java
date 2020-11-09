package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        ArrayList<Integer> data = new ArrayList<>();
        int temp = 0;
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int a = Integer.parseInt(st.nextToken());
            data.add(a);
        }

        temp = arr[0];
        int newResult = 0;
        int rescue = 0;

        for(int i=0;i<N;i++){
            arr[i] = 1;
            for(int j=0;j<i;j++){
                if(data.get(j) < data.get(i)){
                    arr[i] = Math.max(arr[i], arr[i] + 1);
                }
            }
            result = Math.max(result, arr[i]);
        }

        System.out.println(result);
    }
}
