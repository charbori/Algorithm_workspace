package Algorithm.AlgorithmShift;

public class BackTrackingCombi {
	
	int PICK_COUNT = 2;
	int arr[] = new int[1024];
	int dataArr[] = {4,5,13,52,91,43,17,32,85};
	int dataLth = dataArr.length;
	
	void process() {
		 
		backTrackingCombi(arr, 0, dataArr.length, PICK_COUNT, 0);
		 
	}
	 
	void backTrackingCombi(int arr[], int index, int n, int depth, int target) {
		 
		if(depth == 0) {
			String str = new String("[");
			for(int i=0;i<PICK_COUNT;i++) {
				str += (" " + arr[i] + " ");
			}
			str += "]";
			
			System.out.println(str);
			
			return;
		}else if( target == n) {
			return;
		}else {
			
			arr[index] = dataArr[target];
			backTrackingCombi(arr, index + 1, n, depth - 1, target + 1);
			backTrackingCombi(arr, index, n, depth, target + 1);
		
		}
	}
}
