package Algorithm.Graph.BFS_DFS_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AttachNumber {
    static int[][] data_arr;
    static int[][] checked_arr;
    static int[] x_map = {0,0,1,-1};
    static int[] y_map = {1,-1,0,0};

    static int attach_data = 0;
    static StringBuilder sb;
    static int[][] need_visit;
    static int answer_val;

    public static void main(String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int data_size = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();
        answer_val = 0;

        data_arr = new int[data_size][data_size];
        checked_arr = new int[data_size][data_size];

        for(int i=0;i<data_size;i++){
            st = new StringTokenizer(br.readLine());
            int j_i=0;
            String[] str = st.nextToken().split("");
            while(str.length > j_i)
            {
                data_arr[i][j_i] = Integer.parseInt(str[j_i]);
                checked_arr[i][j_i] = 0;

                j_i++;
            }
        }

        attach_map();
        attach_map_cal();

        System.out.print(sb);
//
//        for(int i=0;i<data_size;i++){
//            for(int j=0;j<data_size;j++){
//                System.out.print(checked_arr[i][j]);
//            }
//            System.out.println();
//        }
    }

    static void attach_map(){

        int idx_num = 1;

        for(int i = 0;i<data_arr.length;i++){
            for(int j=0;j<data_arr[i].length;j++){
                if(data_arr[i][j] == 1 && checked_arr[i][j] == 0)
                    attach_map_num(i,j,idx_num++);
            }
        }

        attach_data = idx_num - 1;
        sb.append(attach_data + "\n");
    }

    static void attach_map_num(int x, int y, int idx_num){

        if(data_arr[x][y] == 1 && checked_arr[x][y] == 0){
            checked_arr[x][y] = idx_num;
        }

        for(int i=0;i<4;i++){
            int moved_x = x + x_map[i];
            int moved_y = y + y_map[i];

            if(moved_x >= 0 && moved_x < data_arr.length && moved_y >= 0 && moved_y < data_arr.length){
                if(data_arr[moved_x][moved_y] == 1 && checked_arr[moved_x][moved_y] == 0)
                    attach_map_num(moved_x,moved_y, idx_num);
            }
        }
    }

    static void attach_map_cal(){
        int idx_num = 1;

        need_visit = new int[attach_data + 1][2];

        for(int i = 0;i<data_arr.length;i++){
            for(int j=0;j<data_arr[i].length;j++){
                if(checked_arr[i][j] == idx_num){
                    attach_map_cal_city(i,j, idx_num++);
                    sb.append(answer_val + "\n");
                    answer_val=0;
                }
            }
        }

    }

    static void attach_map_cal_city(int x, int y, int idx_num){

        checked_arr[x][y] = 0;
        answer_val++;

        for(int i=0;i<4;i++){
            int moved_x = x + x_map[i];
            int moved_y = y + y_map[i];


            if(moved_x >= 0 && moved_x < data_arr.length && moved_y >= 0 && moved_y < data_arr.length){
                if(data_arr[moved_x][moved_y] == 1 && checked_arr[moved_x][moved_y] == idx_num){
                    attach_map_cal_city(moved_x, moved_y, idx_num);
                }
            }
        }
    }
}
