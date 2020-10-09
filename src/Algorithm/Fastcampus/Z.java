package Algorithm.Fastcampus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z {
    static int K, N;
    static int idx, find_x, find_y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        idx = 0;
        N = Integer.parseInt(st.nextToken());
        K = (int) Math.pow(2,N);
        find_y = Integer.parseInt(st.nextToken());
        find_x = Integer.parseInt(st.nextToken());
        drawal(K, 0, 0);

    }

    static void drawal(int M, int x, int y){

        if (M == 2){
            if(find_x == x && find_y == y){
                System.out.println(idx);
                return;
            }
            idx+=1;
            if(find_x == (x+1) && find_y == y){
                System.out.println(idx);
                return;
            }
            idx+=1;
            if(find_x == x && find_y == (y+1)){
                System.out.println(idx);
                return;
            }
            idx+=1;
            if(find_x == (x+1) && find_y == (y+1)){
                System.out.println(idx);
                return;
            }
            idx+=1;
            return;
        }

        drawal(M/2, x, y);
        drawal(M/2, x + M/2, y);
        drawal(M/2, x, y + M/2);
        drawal(M/2, x + M/2, y + M/2);

    }


}