package Algorithm.ExhaustiveSearch.Work4;

/**
 * UVa 750 - 8 8-�� ü�� ����
 * @see <a href="https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=691">https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=691</a>
 * @author jaehyeok
 *
 */
public class QueensChessProblem {
	int row[] = new int[8];
	int TC;
	int a,b;
	int lineCounter;
	
	int problemNum[] = {0,3};
	
	int end = 8;
	int p[] = {1,2,3,4,5,6,7,8};
	int resultCount = 0;
	
	boolean place(int r, int c) {
		for(int prev = 0; prev < c; prev++) {
			if(row[prev] == r || (Math.abs(row[prev] - r) == Math.abs(prev - c))) {
				return false;
			}
		}
		return true;
	}
	
	void backTrack(int c) {
		if(c == 8 && row[b] == a) {
			System.out.println("lineCount : " + ++lineCounter + "\n row:" + (row[0] + 1));
			for(int j = 1; j < 8; j++) {
				System.out.println("row:" + (row[j] + 1));
				
			}
		}
		
		for(int r = 0; r < 8; r++) {
			if(place(r,c)) {
				row[c] = r;
				backTrack(c + 1);
			}
		}
	}
	
	void backTracking(int startIndex) {
		
		for(int idx = startIndex; idx < end; idx++) {
			
			swapRow(startIndex, idx);
			
			//����ġ��
			if(placeCheck(idx)) {

				resultCount++;
				
				System.out.println("row name: " + p[0] + " " + p[1] + " " + p[2] + " " + p[3] + " "
						 + p[4] + " " + p[5] + " " + p[6] + " " + p[7] + " count : " + resultCount);
				
				backTracking(startIndex + 1);
			}
			
			
			
			swapRow(startIndex, idx);
		}
		
	}
	
	void swapRow(int x, int y) {
		int rowIndex = p[x];
		int columnIndex = p[y];
		
		p[x] = columnIndex;
		p[y] = rowIndex;
	}
	
	boolean placeCheck(int idx) {
		
		for(int k=0;k<idx;k++) {
			if( Math.abs((p[k]) - (p[idx])) == Math.abs(k - idx)) 
				return false;
		}
		
		return true;
	}
}
