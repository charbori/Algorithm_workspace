package Algorithm.StackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class PassBridge {
    public static void main(String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int bridge_length = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int bridge_weight = Integer.parseInt(st.nextToken());

        int cur_time = 0;
        int cur_bridge_weight = 0;

        LinkedList<Integer> truck_list = new LinkedList<>();
        LinkedList<Truck> truck_list_on_bridge = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[1024];

        while(st.hasMoreTokens()){
            truck_list.add(Integer.parseInt(st.nextToken()));
        }

        while(!truck_list.isEmpty() || !truck_list_on_bridge.isEmpty()){
            cur_time++;
            int truck_weight = 0;

            if(!truck_list_on_bridge.isEmpty()){
                Truck temp = truck_list_on_bridge.peek();

                if(cur_time - temp.time_in >= bridge_length){
                    cur_bridge_weight -= truck_list_on_bridge.poll().weight;
                }
            }

            if(!truck_list.isEmpty()){
                truck_weight = truck_list.peek();

                if(bridge_weight >= cur_bridge_weight + truck_weight){
                    truck_list.poll();
                    truck_list_on_bridge.add(new Truck(cur_time, truck_weight));
                    cur_bridge_weight += truck_weight;
                }
            }

        }

        System.out.println(cur_time);

        for(int i=0;i<stack.size();i++){
            System.out.print(stack.pop() + " ");
        }
    }
}

class Truck{
    int time_in;
    int weight;
    public Truck(int time, int weight){
        this.time_in = time;
        this.weight = weight;
    }
}
