package Lib_collection;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    static Queue<Integer> queue = new Queue<>();
    ArrayList<Integer> list;


    @BeforeAll
    static void clearAllData(){
        queue.clear();
    }

    @Test
    void size() {

    }

    @Test
    void isEmpty() {

        for(int i=1;i<100000;i++){
            queue.add(i);
            queue.remove(i);
            assertEquals(queue.isEmpty(), true);
        }
    }

    @Test
    void contains() {
    }

    @Test
    void toArray() {
    }

    @Test
    void add() {
        for(int i=1;i<100000;i++){
            queue.add(i);

            list = queue.queue;
            assertEquals(list.size(), i);
            assertEquals(list.get(i - 1),i);
        }
    }

    @Test
    void remove() {
    }

    @Test
    void clear() {
    }

    @Test
    void poll() {
        for(int i=0;i<100000;i++){
            queue.add(i);
        }

        for(int i=99999;i>=0;i--){
            assertEquals(queue.poll(), 99999 - i);
        }

    }

    @Test
    void peek() {
        for(int i=0;i<100000;i++){
            queue.add(i);
            assertEquals(queue.peek(), i);
            queue.poll();
        }
    }
}