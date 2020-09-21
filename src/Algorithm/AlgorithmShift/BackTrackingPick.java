package Algorithm.AlgorithmShift;

import java.util.ArrayList;

public class BackTrackingPick {

	int DEPTH_END = 2;
	int noneTarget = 0;
	
	int dataArr[] = {4,5,13,52,91,43,17,32,85};
	int arr[] = {0,0,0,0};
	
	StringBuilder st[] = new StringBuilder[2];
	
	ArrayList <DataList> dataList;

	int dataLth = dataArr.length;
	
	void process() {
		
		dataList = new ArrayList<>();
		
		st[0] = new StringBuilder("");
		st[1] = new StringBuilder("");
		
		backTrackingPick(arr, 0, 0, noneTarget);

		System.out.println("����� �� : " + dataList.size());
		
		for(int j=0;j<dataList.size();j++) {
			dataList.get(j).showData();
		}
	}
	

	void backTrackingPick(int[] arr, int index, int curDepth, int target) {
		
		if(DEPTH_END == curDepth) {
			dataList.add(new DataList(arr[0], arr[1], arr[2], arr[3]));
			
			return ;
			
		}
		
		for(int j=index;j<dataLth-(DEPTH_END - curDepth - 1);j++) {
			
			arr[curDepth] = dataArr[j];
			
			backTrackingPick(arr, j + 1, curDepth + 1, j + 1);
			
		}
	}
}

class DataList{
	
	int a = 0;
	int b = 0;
	int c = 0;
	int d = 0;
	
	public DataList(int a, int b, int c, int d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	void showData() {
		System.out.println("[" + a + " " + b + " " + c + " " + d + "]");
	}
	
}
