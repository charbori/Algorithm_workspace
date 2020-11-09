package Algorithm.SortPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class QuickSort_saveMemory {
    static int arr[];
    static int N;
    static int idx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        idx = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        int i = 0;

        while(st.hasMoreTokens()){
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        sort(arr, 0, arr.length - 1);

        System.out.println(arr[idx]);
    }

    private static void sort(int arr[], int low, int high){
        if(low >= high) return;

        int mid = partition(arr, low, high);
        sort(arr, low, mid - 1);
        sort(arr, mid, high);
    }

    private static int partition(int arr[], int low, int high){
        int pivot = arr[(low + high) / 2];
        while(low <= high){
            while(arr[low] < pivot) low++;
            while(arr[high] > pivot) high--;
            if(low <= high){
                swap(arr ,low, high);
                low++;
                high--;
            }
        }
        return low;
    }

    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
