package Algorithm.DFS_BFS.Work1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class MakeBridge {
	
	static int[][] loc_arr;
	static int[][] loc_arr_check;
	
	static ArrayList<Pair> visited;
	static LinkedList<Pair> need_visit;

	static int[] move_x = {0,0,1,-1};
	static int[] move_y = {1,-1,0,0};
	
	static int answer = 100;
	static int return_value = 0;
	static int count = 0;
	
	static int tot_N;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		tot_N = Integer.parseInt(st.nextToken());
		
		//���� �ʱ�ȭ 
		loc_arr = new int[tot_N][tot_N];
		loc_arr_check = new int[tot_N][tot_N];
		
		visited = new ArrayList<>();
		need_visit = new LinkedList<>();
		
		for(int i=0;i<tot_N;i++)
		{
			st = new StringTokenizer(br.readLine());
			
			int j=0;
			
			while(st.hasMoreTokens())
			{
				loc_arr[i][j] = Integer.parseInt(st.nextToken());
				j++;
			}
			
		}
		
		for(int i=0;i<tot_N;i++) 
		{
			for(int j=0;j<tot_N;j++) 
			{
				if(loc_arr[i][j] == 1 && loc_arr_check[i][j] == 0)
				{
					DFS(new Pair(i,j),count + 1);
					count++;
				}
			}
		}
		
		visited.clear();
		need_visit.clear();
		
		for(int i=1;i<4;i++)
		{
			BFS(i);
			visited.clear();
			need_visit.clear();
		}
		
		System.out.print("\n" + answer);
	
	}
	
	static void DFS(Pair pos, int count) {
		
		boolean do_dfs = true;
		
		for(int i=0;i<visited.size();i++)
		{
			if(visited.get(i).getX() == pos.getX() && visited.get(i).getY() == pos.getY())
			{
				do_dfs = false;
			}
		}
		
		if(do_dfs)
		{
			visited.add(new Pair(pos.getX(), pos.getY()));
			loc_arr_check[pos.getX()][pos.getY()] = count;
			
			for(int i=0;i<4;i++)
			{
				int moved_pos_x = pos.getX() + move_x[i];
				int moved_pos_y = pos.getY() + move_y[i];
						
				if(0 <= moved_pos_x && moved_pos_x < tot_N && 0 <= moved_pos_y && moved_pos_y < tot_N)
				{
					if(loc_arr[moved_pos_x][moved_pos_y] == 1)
						DFS(new Pair(moved_pos_x,moved_pos_y), count);
				}
			}	
		}
	}
	
	static void BFS(int group_value) {
		
		int[][] loc_arr_group = new int[tot_N][tot_N];
		int[][] loc_arr_group_check = new int[tot_N][tot_N];

		int[] move_x = {0,0,1,-1};
		int[] move_y = {1,-1,0,0};
		
		for(int i=0;i<tot_N;i++)
		{
			for(int j=0;j<tot_N;j++)
			{
				if(loc_arr_check[i][j] == group_value)
				{
					loc_arr_group[i][j] = new Integer(1);
					loc_arr_group_check[i][j] = new Integer(1);
					need_visit.add(new Pair(i,j));
				}
				else if(loc_arr_check[i][j] == 0)
				{
					loc_arr_group[i][j] = new Integer(0);
					loc_arr_group_check[i][j] = new Integer(0);
				}
				else
				{
					loc_arr_group[i][j] = new Integer(-1);
					loc_arr_group_check[i][j] = new Integer(-1);
				}
			}
		}
		
		while (!need_visit.isEmpty())
		{
			Pair pos = need_visit.poll();
			
			//�ߺ� üũ
			boolean do_dfs = true;
			
			for(int i=0;i<visited.size();i++)
			{
				if(visited.get(i).getX() == pos.getX() && visited.get(i).getY() == pos.getY())
				{
					do_dfs = false;
				}
			}
			
			if(do_dfs && loc_arr_group_check[pos.getX()][pos.getY()] == 1)
			{
				visited.add(new Pair(pos.getX(), pos.getY()));
				
				for(int i=0;i<4;i++)
				{
					int moved_pos_x = pos.getX() + move_x[i];
					int moved_pos_y = pos.getY() + move_y[i];
							
					if(0 <= moved_pos_x && moved_pos_x < tot_N && 0 <= moved_pos_y && moved_pos_y < tot_N)
					{
						
						if(loc_arr_group_check[moved_pos_x][moved_pos_y] == 1)
						{
							need_visit.add(new Pair(moved_pos_x,moved_pos_y));
							
							for(int k=0;k<tot_N;k++) 
							{
								for(int j=0;j<tot_N;j++) 
								{
									System.out.print(loc_arr_group[k][j] + " ");
								}
								System.out.println();
							}

							
						}
						else if(loc_arr_group_check[moved_pos_x][moved_pos_y] == -1)
						{
							answer = Math.min(loc_arr_group[pos.getX()][pos.getY()], answer);
						}
						else if(loc_arr_group_check[moved_pos_x][moved_pos_y] == 0)
						{
							need_visit.add(new Pair(moved_pos_x,moved_pos_y));
							loc_arr_group_check[moved_pos_x][moved_pos_y] = 1;
							loc_arr_group[moved_pos_x][moved_pos_y] = loc_arr_group[pos.getX()][pos.getY()] + 1;
						}
					}
				}	
			}
		}
	}
}

