package Algorithm.Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MinHeap {

    static HashMap<String, Integer> map;
    static Long answer = 1L;
    static int parent[], relation[];

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder answer = new StringBuilder();

        Heap heap = new Heap(1);

        Random random = new Random();

        for(int i=0;i<1000;i++){
            int rand_val = random.nextInt(100000) + 1;
            heap.insert(rand_val);
        }

        heap.describe();

        for(int i=0;i<500;i++){
            heap.pop();
        }

        heap.describe();

    }
}

class Heap{
    ArrayList<Integer> heap_list;

    public Heap(int data){
        heap_list = new ArrayList<>();
        heap_list.add(0);
        heap_list.add(data);
    }

    boolean move_up(int inserted_idx){

        if(inserted_idx == 1){
            return false;
        }
        int parent_idx = (int) Math.floor(inserted_idx / 2);

        if(heap_list.get(inserted_idx) < heap_list.get(parent_idx)){
            return true;
        }

        return false;
    }

    boolean move_down(int popped_idx){

        int left_child_popped_idx = popped_idx * 2;
        int right_child_popped_idx = popped_idx * 2 + 1;

        //case1 바꾸려는 자식이 없을 때
        if(heap_list.size() <= left_child_popped_idx ){
            return false;
        }
        //case2 바꾸려는 자식이 왼쪽만 있음
        else if(heap_list.size() <= right_child_popped_idx){
            if(heap_list.get(left_child_popped_idx) <= heap_list.get(popped_idx))
                return true;
            else
                return false;
        }
        //case3 바꾸려는 자식이 둘 다 있음.
        else {
            if(heap_list.get(left_child_popped_idx) < heap_list.get(right_child_popped_idx)){
                if(heap_list.get(left_child_popped_idx) <= heap_list.get(popped_idx)){
                    return true;
                }
                else{
                    return false;
                }
            }
            else
                {
                if(heap_list.get(right_child_popped_idx) <= heap_list.get(popped_idx)){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
    }

    void insert(int data){

        heap_list.add(data);

        int inserted_idx = heap_list.size() - 1;

        while(move_up(inserted_idx)){

            int parent_idx = (int) Math.floor(inserted_idx/2);

            heap_list.remove(inserted_idx);
            heap_list.add(inserted_idx, heap_list.get(parent_idx));
            heap_list.remove(parent_idx);
            heap_list.add(parent_idx,data);

            inserted_idx = parent_idx;
        }

    }

    void pop(){
        if(heap_list.size() < 1)
            return ;

        int popped_idx = 1;

        heap_list.remove(1);
        heap_list.add(1,heap_list.get(heap_list.size() - 1));
        heap_list.remove(heap_list.size() - 1);

        while(move_down(popped_idx)){

            int left_child_popped_idx = popped_idx * 2;
            int right_child_popped_idx = popped_idx * 2 + 1;

//            //case1 바꾸려는 자식이 없을 때
//            if(heap_list.size() < left_child_popped_idx ){
//
//            }

            if(heap_list.size() <= right_child_popped_idx){
                if(heap_list.get(left_child_popped_idx) <= heap_list.get(popped_idx)){
                    int left_temp = heap_list.get(left_child_popped_idx);
                    int popped_temp = heap_list.get(popped_idx);

                    heap_list.remove(left_child_popped_idx);
                    heap_list.add(left_child_popped_idx, heap_list.get(popped_idx));

                    heap_list.remove(popped_idx);
                    heap_list.add(popped_idx, left_temp);

                    popped_idx = left_child_popped_idx;
                }
            }
            //case3 바꾸려는 자식이 둘 다 있음.
            else {
                if(heap_list.get(left_child_popped_idx) < heap_list.get(right_child_popped_idx)){
                    if(heap_list.get(left_child_popped_idx) <= heap_list.get(popped_idx)){
                        int left_temp = heap_list.get(left_child_popped_idx);
                        int popped_temp = heap_list.get(popped_idx);

                        heap_list.remove(left_child_popped_idx);
                        heap_list.add(left_child_popped_idx, heap_list.get(popped_idx));

                        heap_list.remove(popped_idx);
                        heap_list.add(popped_idx, left_temp);

                        popped_idx = left_child_popped_idx;
                    }
                }
                else
                {
                    if(heap_list.get(right_child_popped_idx) <= heap_list.get(popped_idx)){
                        int right_temp = heap_list.get(right_child_popped_idx);
                        int popped_temp = heap_list.get(popped_idx);

                        heap_list.remove(right_child_popped_idx);
                        heap_list.add(right_child_popped_idx, heap_list.get(popped_idx));

                        heap_list.remove(popped_idx);
                        heap_list.add(popped_idx, right_temp);

                        popped_idx = right_child_popped_idx;
                    }
                }
            }
        }
    }

    void describe(){
        int idx = 1;
        int line = 1;
        while(idx < heap_list.size()){
            if(idx == line){
                System.out.println();
                line*=2;
            }
            System.out.print(heap_list.get(idx) + " ");
            idx++;
        }
        System.out.println();
    }
}