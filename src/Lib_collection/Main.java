package Lib_collection;

import java.util.Random;

public class Main {
    public static void main(String[] args){
        Random random = new Random();
        Heap heap = new Heap();

        for(int i=0;i<10;i++){
            heap.add(random.nextInt(1000));
        }

        heap.describe();

        for(int i=0;i<5;i++){
            heap.pop();
        }

        heap.describe();

    }
}
