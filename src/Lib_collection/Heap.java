package Lib_collection;

import java.util.ArrayList;
import java.math.*;
public class Heap {
    int[] arr;
    int auto_count;

    public Heap(int data){
        arr = new int[1024];
        arr[0] = 0;
        arr[1] = data;
        auto_count = 2;
    }

    public Heap(){
        arr = new int[1024];
        arr[0] = 0;
        auto_count = 1;
    }

    private boolean move_up(int idx){

        if(idx > 1 && arr[idx/2] > arr[idx]){
            return true;
        }

        return false;
    }

    private boolean move_down(int idx){

        int idx_left_child = idx * 2;
        int idx_right_child = idx * 2 + 1;

        if(auto_count - 1 <= idx_left_child){
            return false;
        }else if(auto_count - 1 <= idx_right_child){
            if(arr[idx_left_child] <= arr[idx]){
                return true;
            }else
                return false;
        }
        else{
            if(arr[idx_left_child] < arr[idx_right_child]){
                if(arr[idx_left_child] <= arr[idx]){
                    return true;
                }else{
                    return false;
                }
            }
            else{
                if(arr[idx_right_child] <= arr[idx]){
                    return true;
                }else{
                    return false;
                }
            }
        }
    }

    public void add(int data){
        if(auto_count < arr.length - 1) {
            arr[auto_count] = data;
            auto_count += 1;
        }
        else
        {
            int[] arr2 = new int[auto_count * 2];
            System.arraycopy(arr, 0, arr2, 0, arr.length);
            arr = arr2;
            auto_count += 1;
        }

        int idx = auto_count - 1;

        while (move_up(idx)){
            arr[idx] = arr[(idx)/2];
            arr[(idx)/2] = data;
            idx = (idx)/2;
        }
    }

    public void pop(){
        int idx = auto_count;
        arr[1] = arr[idx];
        arr[idx] = 0;

        idx = 1;

        while(move_down(idx)){
            int idx_left_child = idx * 2;
            int idx_right_child = idx * 2 + 1;

            if(idx_right_child < auto_count){
                if(arr[idx_left_child] <= arr[idx]) {
                    int temp = arr[idx];
                    arr[idx] = arr[idx_left_child];
                    arr[idx_left_child] = temp;
                    idx = idx_left_child;
                }else{
                    int temp = arr[idx];
                    arr[idx] = arr[idx_right_child];
                    arr[idx_right_child] = temp;
                    idx = idx_right_child;
                }
            }else{
                if(arr[idx_left_child] > arr[idx_right_child]){
                    if(arr[idx_left_child] >= arr[idx]){
                        int temp = arr[idx];
                        arr[idx] = arr[idx_right_child];
                        arr[idx_right_child] = temp;

                        idx = idx_right_child;
                    }
                }else{
                    if(arr[idx_right_child] >= arr[idx]){
                        int temp = arr[idx];
                        arr[idx] = arr[idx_left_child];
                        arr[idx_left_child] = temp;

                        idx = idx_left_child;
                    }
                }
            }
        }

        auto_count -= 1;
    }

    public void describe(){
        int idx = 1;
        for(int i=0;i<arr.length;i++){
            if(i % idx == 0){
                System.out.println();
                idx *= 2;
            }
            System.out.print(arr[i] + " ");
        }
    }
}
