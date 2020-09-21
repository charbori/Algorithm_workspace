package Algorithm.DFS_BFS.Work1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Laboratory {

	static int column, row;
	
	static int[][] map;
	static int safe_area;
	static int area;
	
	static int tot_safe_block;
	static int virus;
	static int safe_block;

	static final int BLANK = 0;
	static final int WALL = 1;
	static final int VIRUS = 2;
	static final int[] dx = {0,0,1,-1};
	static final int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		column = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		
		map = new int[column][row];
		
		for(int i=0;i<column;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<row;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		DFS(0,0);
		System.out.println(safe_block);
		
	}
	
	static void DFS(int bfs_idx, int safe_block_count) {
		if(safe_block_count == 3) 
		{
			BFS();
			return ;
		}
		else if(bfs_idx == column) 
		{
			return ;
		}
		else
		{
			//��� ����
		}
		
		for(int column_idx=bfs_idx;column_idx<column;column_idx++) {
			for(int row_idx=0;row_idx<row;row_idx++) {
				if(map[column_idx][row_idx] == 0) {
					map[column_idx][row_idx] = 1;
					DFS(column_idx, safe_block_count + 1);
					map[column_idx][row_idx] = 0;
				}
			}
		}
	}
	
	static boolean BFS() {
		
		int virus_spread_count = -1;
		int[][] virus_map = new int[column][row];

		for(int column_idx=0;column_idx<column;column_idx++)
			for(int row_idx=0;row_idx<row;row_idx++)
				virus_map[column_idx][row_idx] = map[column_idx][row_idx];
		
		Queue<Pair> virus_queue = new LinkedList<Pair>();
		
		for(int column_idx=0;column_idx<column;column_idx++)
			for(int row_idx=0;row_idx<row;row_idx++)
				if(virus_map[column_idx][row_idx] == VIRUS)
					virus_queue.add(new Pair(column_idx,row_idx));
		
		while(!virus_queue.isEmpty()) {
			Pair p = virus_queue.remove();
			int x = p.x;
			int y = p.y;
			
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >= 0 && ny >= 0 && nx < column && ny < row) {
					if(virus_map[nx][ny] == BLANK) {
						virus_map[nx][ny] = VIRUS;
						virus_queue.add(new Pair(nx,ny));
					}
				}
			}
		}
		
		int total_safe_area = 0;
		
		
		for(int i=0;i<column;i++) {
			for(int j=0;j<row;j++) {
				if(virus_map[i][j] == 0) {
					total_safe_area++;
				}
			}
		}
		
		if(total_safe_area > safe_block) {
			
			for(int i=0;i<column;i++) {
				for(int j=0;j<row;j++) {
					System.out.print(virus_map[i][j] + " ");
				}
				System.out.println();
			}

			System.out.println();
			
			safe_block = total_safe_area;
			
			return true;	
		}
		else
			return false;
	}
	
}
