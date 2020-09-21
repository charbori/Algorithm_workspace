package Algorithm.Search;

import java.util.ArrayList;
import java.util.Arrays;

public class BoardingPass {


    static int[] return_tables_times;
    static int[] remain_tables_times;
    
    static long cur_assigned_people;
    static long sum_assigned_people;
    
    static long cur_tables_times;
    static long sum_tables_times;
    
    static int binary_search_idx;
    static int tot_assigned;
    static int tot_times;
    static int[] times;
    
    public static void main(String args[]) {
        int n = 6;
        
        times = new int[2];
        times[0] = 7;
        times[1] = 10;
        
        //times = received_times;
        long answer = 0;
        
        tot_assigned = times.length;
        tot_times = times.length;
        
        ArrayList<Integer> not_assigned_tables = new ArrayList<>();
        
        Arrays.sort(times);
        
        return_tables_times = new int[times.length];
        remain_tables_times = new int[times.length];
       
        for(int i=0;i<tot_times;i++){
            int k = times[i];
            remain_tables_times[i] = k;
        }
        
        cur_assigned_people = 0L;
        sum_assigned_people = 0L;
        
        cur_tables_times = 0L;
        sum_tables_times = 0L;
        
        binary_search_idx = tot_assigned - 1;  
     
        int time_stamp = 0;

        while(n > 0)
        {
            for(int i=0;i<tot_times;i++){
                int k = remain_tables_times[i];
                return_tables_times[i] = k;
            }
            
            cur_assigned_people = binary_search(binary_search_idx);

            if(cur_assigned_people <= n)
            {
                n -= (long) cur_assigned_people;
                sum_tables_times += (long) times[binary_search_idx];
            }
            else
            {
                for(int i=0;i<tot_times;i++){
                    int k = return_tables_times[i];
                    remain_tables_times[i] = k;
                }
                
                if(binary_search_idx == 0 && cur_assigned_people > n) {
                	Arrays.sort(remain_tables_times);
                	sum_tables_times += times[n-1];
                	break;
                }
                
                double temp_divide = (double) binary_search_idx;
                temp_divide /= 2;
                binary_search_idx = (int) Math.floor(temp_divide);
                
            }

            System.out.println("remain people & tot_time " + n + " " + sum_tables_times);
            System.out.println("idx " + binary_search_idx + " " + cur_assigned_people);
            System.out.println("remain times " + remain_tables_times[0] + " " + remain_tables_times[1]);
            System.out.println("remain times " + return_tables_times[0] + " " + return_tables_times[1]);
        }

        System.out.println(sum_tables_times);
    }
    
    static long binary_search(int idx)
    {
        
        //cur_tables_times����
        int max_time = times[idx];
        long answer = 0L;
        
        for(int i=0;i<tot_times; i++)
        {
            answer += (long) (max_time / times[i]);
            
            if(remain_tables_times[i] - max_time % times[i] < 0)
            {
                remain_tables_times[i] = times[i] + remain_tables_times[i] - max_time % times[i];
                answer++;
            }
            else
            {
                remain_tables_times[i] = remain_tables_times[i] - max_time % times[i];
            }
        }
        
        return answer;
    }
    

}
