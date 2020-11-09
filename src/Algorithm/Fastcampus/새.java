package Algorithm.Fastcampus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 새 {
    static int strData;
    static int target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        strData = 0;
        target = 0;
        strData = Integer.parseInt(br.readLine());
        int count = 0;
        int i = 0;

        while(strData != 0){
            if(target < strData){
                target++;
            }else{
                target = 1;
            }

            strData -= target;
            count++;
        }
        System.out.println(count);
    }
}
