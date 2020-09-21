package Algorithm.ExhaustiveSearch.Work5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ChickenDistance {
	
	private static int map[][];
	private static int n,m;
	private static int distance, result;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());	
			} 
		}
		
		distance = 0;
		result = 1000000;
		
		chickenDistance(0, 0, checkChickenStore());
		
		System.out.println(result);
		
	}

	static void chickenDistance(int searchIdx, int closeCount, int totChickenStore) {
		if(totChickenStore - closeCount == m) {
			checkChickenDistance();
		}
		else if(searchIdx == n) 
		{
			return ;
		}
		else
		{
			//��� ����
		}
		
		for(int i=searchIdx; i<n;i++) {
			for(int j=0;j<n;j++) {
				
				if(map[i][j] == 2) {
					map[i][j] = 0;
					chickenDistance(i, closeCount + 1, totChickenStore);
					map[i][j] = 2;
				}
			}
		}
		
	}
	static int checkChickenStore() {
		ArrayList <MapPosition> chickenList = new ArrayList<>();
		
		for(int i=0; i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j] == 2)
					chickenList.add(new MapPosition(i,j));
			}
		}
		
		return chickenList.size();
	}
	
	static boolean checkChickenDistance() {
		
		distance = 0;
		
		ArrayList <MapPosition> clientList = new ArrayList<>();
		ArrayList <MapPosition> chickenList = new ArrayList<>();
		
		for(int i=0; i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j] == 1)
					clientList.add(new MapPosition(i,j));
				if(map[i][j] == 2)
					chickenList.add(new MapPosition(i,j));
			}
		}
		
		for(int i=0;i<clientList.size();i++) {
			int tempDistance = 10000000;
			for(int j=0;j<chickenList.size();j++) {
				if((Math.abs(clientList.get(i).x - chickenList.get(j).x) + Math.abs(clientList.get(i).y - chickenList.get(j).y))
						< tempDistance) {
					tempDistance = Math.abs(clientList.get(i).x - chickenList.get(j).x) + Math.abs(clientList.get(i).y - chickenList.get(j).y);
					
				}
			}
			if(tempDistance != 10000000)
				distance += tempDistance;
			//System.out.println(distance);
		}
		
		
		
		if(distance < result) {
			//System.out.println(distance);
			result = distance;
			return true;	
		}
		else
			return false;
	}
}

class MapPosition{
	int x;
	int y;
	public MapPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
}



























