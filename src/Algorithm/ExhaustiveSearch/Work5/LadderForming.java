package Algorithm.ExhaustiveSearch.Work5;

import java.util.ArrayList;
import java.util.Arrays;

public class LadderForming {
	
	static int result = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//make ladder list
		int[][] ladderList = new int[6][5];
		ArrayList<Integer> currentLadderList = new ArrayList<>();
		
		for(int[] arr:ladderList) {
			Arrays.fill(arr, -1);	
		}
		
		ladderList[0][0] = 1;
		ladderList[2][0] = 2;
		ladderList[1][0] = 3;
		ladderList[4][0] = 1;
		ladderList[4][1] = 4;
		
		int row = 6;
		int column = 5;
		int i=0;
		
		while(i < 5) {
			currentLadderList.add(i);
			
			int j=0;
			
			ladderForm(row, column, currentLadderList, ladderList, 0);
			currentLadderList.clear();
			
			i++;
		}
		
		System.out.println(result);
		
	}
	
	static int ladderForm(int row, int column, ArrayList<Integer> currentLadderList, int[][] ladderList, int extraLadder) {
		
		if(currentLadderList.size() == row) {
			if(currentLadderList.get(5) == currentLadderList.get(0)) {
				result += 1;

				return 0;
			}
			return 0;
		}
		
		for(int k=0;k<row;k++) {
			if(ladderAvailable(row, column, k, currentLadderList, ladderList) != -1) {
				
				int value = ladderAvailable(row, column, k, currentLadderList, ladderList);
				currentLadderList.add(value);
				
				int valueRes = ladderForm(row, column, currentLadderList, ladderList, extraLadder);
				currentLadderList.remove(currentLadderList.size() - 1);
			}
		}
		
		return 0;
	}
	
	static int ladderAvailable(int row, int column, int currentRow, ArrayList<Integer> currentLadderList, int[][] ladderList) {
		for(int k=0;k < ladderList[currentRow].length;k++) {
			if(currentLadderList.size() != 0 && currentRow < ladderList.length && currentRow < currentLadderList.size() &&
					ladderList[currentRow][k] != -1 && Math.abs(ladderList[currentRow][k] - currentLadderList.get(currentRow)) == 1) {
				return ladderList[currentRow][k];
			}
		}
		
		return -1;
	}
}
