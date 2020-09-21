package Algorithm.AlgorithmShift;

public class BackTrackingShift {
	
	int dataBeforeSwap[] = {1,2,3,4};
	int end = 3;
	int dataLth = dataBeforeSwap.length;
	int noneTarget = 0;
	
	int targetCount = 0;
	
	StringBuilder dataListDepth[] = new StringBuilder[4];
	
	void process(int index) {

		dataListDepth[0] = new StringBuilder("");
		dataListDepth[1] = new StringBuilder("");
		dataListDepth[2] = new StringBuilder(""); 
		dataListDepth[3] = new StringBuilder(""); 
		
		backTracking(index, noneTarget, end);
		
		System.out.println(dataListDepth[0]);
		System.out.println(dataListDepth[1]);
		System.out.println(dataListDepth[2]);
		System.out.println(dataListDepth[3]);
		
		System.out.println("����� �� : " + targetCount);
	}
	
	void backTracking(int index, int end, int target) {
		
		if(this.end == end) {	
			
			StringBuilder b = new StringBuilder();
			
			b.append(String.valueOf(dataBeforeSwap[0]));
			b.append(String.valueOf(dataBeforeSwap[1]));
			b.append(String.valueOf(dataBeforeSwap[2]));
			b.append(String.valueOf(dataBeforeSwap[3]));
			
			System.out.println(b);
			targetCount++;
			
			return ;
		}
		
		for(int j=end;j<dataLth;j++) {
			
			swap(end, j);

			dataListDepth[end].append("[ ");
			
			for(int k=0;k<dataLth;k++) {
				dataListDepth[end].append(String.valueOf(dataBeforeSwap[k] + " "));
			}
			
			dataListDepth[end].append("]       ");
			
			backTracking(j, end + 1, noneTarget);
			swap(end, j);
		}
	}
	
	void swap(int i, int j) {
		int temp = dataBeforeSwap[i];
		dataBeforeSwap[i] = dataBeforeSwap[j];
		dataBeforeSwap[j] = temp;
	}
}
