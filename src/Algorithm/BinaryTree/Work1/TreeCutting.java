package Algorithm.BinaryTree.Work1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TreeCutting {

	static int[] tree_heights;
	static int tot_tree;
	static int tot_tree_req;
	static long answer;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		tot_tree = Integer.parseInt(st.nextToken());
		tot_tree_req = Integer.parseInt(st.nextToken());
		
		tree_heights = new int[tot_tree];
		
		st = new StringTokenizer(br.readLine());
		
		int init_st_token_val = 0;
		
		while(st.hasMoreTokens())
		{
			tree_heights[init_st_token_val] = Integer.parseInt(st.nextToken());
			
			init_st_token_val++;
		}
		
		Arrays.sort(tree_heights);
		
		long start = 0;
		long mid = 0;
		long end = 0;
		long sum_trees = 0;
		
		start = 0;
		end = (long) tree_heights[tot_tree - 1];
		
		answer = 0L;
		
		while(start <= end)
		{
			sum_trees = 0L;
			mid = (start + end) / 2L;
			
			int start_height_idx = find_heights_idx((int) mid);
			
			for(;start_height_idx < tot_tree; start_height_idx++)
			{
				if(tree_heights[start_height_idx] - mid >= 0)
					sum_trees += tree_heights[start_height_idx] - mid;
			}
			
			if(sum_trees >= tot_tree_req)
			{
				start = mid + 1L;
			}
			else
			{
				end = mid - 1L;
			}
		}
		
		System.out.println(end);
	}
	
	static int find_heights_idx(int height) {
		
		int start = 0;
		int end = tot_tree - 1;
		
		int mid = 0;
		int answer = 0;
		
		while( mid <= end )
		{
			 mid = (start + end) / 2;
		
			 if(tree_heights[mid] <= height)
			 {
				 start = mid + 1;
				 if(answer < mid)
					 answer = mid;
			 }
			 else
			 {
				 end = mid - 1;
			 }
		}
		
		return answer;
		
	}

}
