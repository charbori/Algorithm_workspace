package Algorithm.DFS_BFS.Work1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SearchMaze {
	  
	public static final int[] dx = {0,0,1,-1};
	public static final int[] dy = {1,-1,0,0};
		
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
		
        int[][] a = new int[n][m];
        for(int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for(int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        int[][] b = new int[n][m];
        boolean[][] check = new boolean[n][m];
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(0,0));
        b[0][0] = 1;
        check[0][0] = true;
		
        while(!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if(!check[nx][ny] && a[nx][ny] == 1) {
                        q.add(new Pair(nx, ny));
                        b[nx][ny] = b[x][y] + 1;
                        check[nx][ny] = true;
                    }
                }
            }
        }
        System.out.println(b[n-1][m-1]);
    }

}
