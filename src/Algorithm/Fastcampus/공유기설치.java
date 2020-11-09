package Algorithm.Fastcampus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int array[] = new int[N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        // 공유기 간 거리
        int d = 0;

        int start = array[1] - array[0];
        int end = array[N-1] - array[0];
        int result = 0;

        while(start <= end){
            int mid = (start + end) / 2;
            int value = array[0];
            int cnt = 1;

            for(int i=1;i<N;i++){
                if(array[i] >= value + mid){
                    value = array[i];
                    cnt += 1;
                }
            }

            if(cnt >= M){
                start = mid + 1;
                result = mid;
            }
            else{
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}
