package Algorithm.Graph.BFS_DFS_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ApartNumber {
    static int[][] data_arr;
    static int[][] checked_arr;
    static int[] x_map = {0,0,1,-1};
    static int[] y_map = {1,-1,0,0};

    static int attach_data = 0;
    static StringBuilder sb;
    static int[][] need_visit;
    static int answer_val;
    static int apart_num = 0;
    static int[] aparts = new int[25*25];
    public static void main(String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int data_size = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();
        answer_val = 0;

        data_arr = new int[data_size][data_size];
        checked_arr = new int[data_size][data_size];

        Arrays.fill(aparts,0);

        for(int i=0;i<data_size;i++){
            st = new StringTokenizer(br.readLine());
            String[] str = st.nextToken().split("");
            for(int j_i=0;j_i<data_size;j_i++)
            {
                data_arr[i][j_i] = Integer.parseInt(str[j_i]);
            }
        }

        br.close();

        for(int i=0;i<data_size;i++){
            for(int j_i=0;j_i<data_size;j_i++)
            {
                if(data_arr[i][j_i] == 1 && checked_arr[i][j_i] == 0){
                    attach_map_cal_city(i,j_i);
                    apart_num++;
                }
            }
        }

        //Arrays.sort(aparts);
        System.out.println(apart_num);

        for(int i=0; i<aparts.length; i++){
            System.out.println(aparts[i]);
            if(aparts[i] == 0){

            }else{
                System.out.println(aparts[i]);
            }
        }

    }


    static void attach_map_cal_city(int x, int y){

        checked_arr[x][y] = 1;
        aparts[apart_num]++;

        for(int i=0;i<4;i++){
            int moved_x = x + x_map[i];
            int moved_y = y + y_map[i];

            if(moved_x >= 0 && moved_x < data_arr.length && moved_y >= 0 && moved_y < data_arr.length){
                if(data_arr[moved_x][moved_y] == 1 && checked_arr[moved_x][moved_y] == 0){
                    attach_map_cal_city(moved_x, moved_y);
                }
            }
        }
    }
}
