package Algorithm.DFS_BFS.Work1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Tomato {
	
	static int[][] map_data;
	static int[][] map_check;
	
	static int tot_column,tot_row;
	static int result, count;
	
	static int[] d_row = {0,0,1,-1};
	static int[] d_col = {1,-1,0,0};
	
	/**
	 * @param args
	 * @throws IOException
	 */
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		tot_row = Integer.parseInt(st.nextToken());
		tot_column = Integer.parseInt(st.nextToken());
		
		map_data = new int[tot_column][tot_row];
		map_check = new int[tot_column][tot_row];
		
		result = 0;
		count = 0;
		
		LinkedList<MapPair> visited = new LinkedList<>();
		LinkedList<MapPair> need_visit = new LinkedList<>();
		
		for(int i=0;i<tot_column;i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			
			int j = 0;
			while(st.hasMoreTokens()) {
				map_data[i][j] = Integer.parseInt(st.nextToken());
				j++;
			}
		}
		
		for(int i=0;i<tot_column;i++)
		{
			for(int j=0;j<tot_row;j++)
			{
				if(map_data[i][j] == 1)
				{
					map_check[i][j] = 1;
					need_visit.add(new MapPair(i,j));
				}
				else if(map_data[i][j] == -1)
				{
					map_check[i][j] = -1;
				}
			}
		}
		
		
		while(!need_visit.isEmpty())
		{
			MapPair map_value = need_visit.poll();
			
			if(map_data[map_value.col][map_value.row] == 1)
			{
				visited.add(new MapPair(map_value.col, map_value.row));
				
				for(int i=0;i<4;i++)
				{
					int d_col_value = map_value.col + d_col[i];
					int d_row_value = map_value.row + d_row[i];
					
					if(0 <= d_col_value && d_col_value < tot_column && 0 <= d_row_value && d_row_value < tot_row)
					{
						if(map_data[d_col_value][d_row_value] == 0)
						{
							need_visit.add(new MapPair(d_col_value, d_row_value));
							
							map_check[d_col_value][d_row_value] = map_check[map_value.col][map_value.row] + 1;
							map_data[d_col_value][d_row_value] = 1;
						}
					}
				}
			}
		}
		
		for(int i=0;i<tot_column;i++)
		{
			for(int j=0;j<tot_row;j++)
			{
				if(map_check[i][j] > result)
				{
					result = map_check[i][j];
				}
				if(map_check[i][j] == 0) {
					count = -1;
				}
			}
		}
		
		if(count == -1)
			System.out.println(count);
		else
			System.out.println(result - 1);
		
	}
}

class MapPair{
	int col;
	int row;
	public MapPair(int col, int row) {
		this.col = col;
		this.row = row;
	}
}