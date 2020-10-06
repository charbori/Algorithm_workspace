package Algorithm.ArrayPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 음계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] data_arr = new int[8];
        int result = 0;

        int i=0;

        while(st.hasMoreTokens()){
            data_arr[i] = Integer.parseInt(st.nextToken());

            if((i+1) == data_arr[i]){
                result += 1;
            }else if((i+1) == (9-data_arr[i])){
                result -= 1;
            }else{
            }

            i++;
        }

        if(result == 8){
            System.out.println("ascending");
        }else if(result == -8){
            System.out.println("descending");
        }else
            System.out.println("mixed");

    }
}
