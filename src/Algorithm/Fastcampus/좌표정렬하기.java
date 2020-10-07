package Algorithm.Fastcampus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class 좌표정렬하기 {
    static int[] x, y;
    static int[] sorted_x, sorted_y;

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        x = new int[N];
        y = new int[N];
        sorted_x = new int[N];
        sorted_y = new int[N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int val1 = Integer.parseInt(st.nextToken());
            int val2 = Integer.parseInt(st.nextToken());

            x[i] = val1;
            y[i] = val2;
        }

        mergeSort(x, y, 0, N-1);

        for(int i=0;i<N;i++){
            System.out.println(x[i] + " " + y[i]);
        }
    }
    static void mergeSort(int[] x, int[] y, int left, int right){
        if(left < right) {
            int mid = (left + right) / 2;
            mergeSort(x, y, left, mid);
            mergeSort(x, y, mid + 1, right);
            merge(x, y, left, mid, right);
        }
    }
    static void merge(int[] x, int[] y, int left, int mid, int right){

        int p = left, q = mid + 1;
        int idx = left;

        // #1 left와 right가 각각 조건을 만족하는 경우
        while(p <= mid && q <= right){
            if (x[p] < x[q]){
                sorted_x[idx] = x[p];
                sorted_y[idx++] = y[p++];
            }else if(x[p] == x[q]){
                if(y[p] <= y[q]){
                    sorted_x[idx] = x[p];
                    sorted_y[idx++] = y[p++];
                }else{
                    sorted_x[idx] = x[q];
                    sorted_y[idx++] = y[q++];
                }
            }else{
                sorted_x[idx] = x[q];
                sorted_y[idx++] = y[q++];
            }
        }

        // #2 left만 만족
        while(p <= mid){
            sorted_x[idx] = x[p];
            sorted_y[idx++] = y[p++];
        }

        // #3 right만 만족
        while(q <= right){
            sorted_x[idx] = x[q];
            sorted_y[idx++] = y[q++];
        }

        for(int k=left; k<=right;k++){
            x[k] = sorted_x[k];
            y[k] = sorted_y[k];
        }
    }
}