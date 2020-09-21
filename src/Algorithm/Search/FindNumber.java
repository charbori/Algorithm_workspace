package Algorithm.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FindNumber {

	static int n;
	static int n_arr[];
	static int m;
	static int m_arr[];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		n_arr = new int[n];
		
		st = new StringTokenizer(br.readLine());	
		int idx_token = 0;
		while(st.hasMoreTokens())
		{
			n_arr[idx_token] = Integer.parseInt(st.nextToken());
			idx_token++;
		}

		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		m_arr = new int[m];

		st = new StringTokenizer(br.readLine());
		idx_token = 0;
		while(st.hasMoreTokens())
		{
			m_arr[idx_token] = Integer.parseInt(st.nextToken());
			idx_token++;
		}

		Arrays.sort(n_arr);
		int idx_m = 0;
		
		while(idx_m < m)
		{
			int start = 0;
			int end = n - 1;
			int mid = 0;
			int target = m_arr[idx_m];
			boolean answer = true;
			
			while(start <= end)
			{
				mid = (start + end) / 2;
				
				if(target < n_arr[mid])
					end = mid - 1;
				else if(target == n_arr[mid])
				{
					answer = false;
					break;
				}
				else
					start = mid + 1;
			}
			
			if(answer)
				System.out.println("0");
			else
				System.out.println("1");
		
			idx_m++;
		}
		
	}	

}
















