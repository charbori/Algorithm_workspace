package Algorithm.StackExam;

import java.util.LinkedList;

class Solution {
	public static void main(String [] age) {
		int bridge_length = 2;
		int weight = 10;
		int truck_weights[] = {7,4,5,6};
//        int answer = 0;
//        ArrayList<Truck> on_bridge_truck_list = new ArrayList<>();
//        
//        int time = 1;
//        int arrival_truck_count = 0;
//        int on_bridge_truck_count = 1;
//        int on_bridge_weight = truck_weights[0];
//        
//        on_bridge_truck_list.add(new Truck(truck_weights[0], 1));
//
//        while(arrival_truck_count != truck_weights.length){
//        	
//        	int truck_idx = 0;
//              
//        	while(truck_idx < on_bridge_truck_list.size()){
//                
//                if(on_bridge_truck_list.get(truck_idx).getTime() + 1 == bridge_length){
//                    on_bridge_weight -= on_bridge_truck_list.get(truck_idx).getWeight();
//                    on_bridge_truck_list.remove(truck_idx);
//                    on_bridge_truck_count--;
//                    arrival_truck_count++;
//                }else{
//                    on_bridge_truck_list.get(truck_idx).addTime();
//                }
//                
//                truck_idx++;
//            }
//            
//            if((arrival_truck_count + on_bridge_truck_count < truck_weights.length) && on_bridge_weight + truck_weights[arrival_truck_count + on_bridge_truck_count - 1] <= weight){
//                on_bridge_truck_count++;
//                on_bridge_weight += truck_weights[arrival_truck_count + on_bridge_truck_count - 1];
//                
//                on_bridge_truck_list.add(new Truck(truck_weights[arrival_truck_count + on_bridge_truck_count - 1], 1));
//                
//            }
//             
//            
//            time++;
//        }
//        System.out.println(time);
		 	int tot_w = 0;
	        int t_front = 0;
	        int t_cur = 0;
	        int time = 0;
	        LinkedList<Integer> queue = new LinkedList<>();
	        
	        while(t_front < truck_weights.length)
	        {
	        	while(!queue.isEmpty() && (time - queue.peek() == bridge_length))
	            {
	                tot_w -= truck_weights[t_front];
	                t_front++;
	                queue.poll();
	            }
	            
	            while(t_cur < truck_weights.length && tot_w + truck_weights[t_cur] <= weight)
	            {
	                tot_w += truck_weights[t_cur];
	                t_cur++;

	                queue.add(time);
	            }
	            
	            time += 1;

	        }
	        
	        System.out.println(time);
    }
}

class Truck{
    int truckWeight;
    int driveTime;
    
    public Truck(int truckWeight, int driveTime){
        this.truckWeight = truckWeight;
        this.driveTime = driveTime;
    }
    void addTime(){
        this.driveTime++;
    }
    int getTime(){
        return this.driveTime;
    }
    
    int getWeight(){
        return this.truckWeight;
    }
}