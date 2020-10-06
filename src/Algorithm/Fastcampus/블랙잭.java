package Algorithm.Fastcampus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 블랙잭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> n_list = new ArrayList<>();

        int result = 0;
        int temp = 0;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()) {
            n_list.add(Integer.parseInt(st.nextToken()));
        }

        for(int i=0;i<n;i++){
            temp = 0;
            temp += n_list.get(i);

            for(int j=i;j<n;j++){
                if(j != i){
                    temp += n_list.get(j);

                    for(int k=j;k<n;k++){
                        if(k != j){
                            temp += n_list.get(k);

                            if( temp <= m && result < temp){
                                result = temp;
                            }
                            temp -= n_list.get(k);
                        }
                    }
                    temp -= n_list.get(j);
                }
            }
        }

        System.out.println(result);
    }
}
