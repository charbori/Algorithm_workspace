package Algorithm.ExhaustiveSearch.Work1;

import java.util.ArrayList;

public class BackTracking {
	
	public ArrayList<Integer> list = new ArrayList<>();
	int[] numArr = {1,2,3,4,5,6,7,8,9,10};
	
	public int sum;
	public int backTrackingSum;
	public int trackingSum;
	
	int MAX = 10;
	
	//for���� ����
	public void getDataTracking(int idx, int sum) {
		
		//���� �۾�
		if(MAX % numArr[idx] == 0)
			sum += numArr[idx];
		
		//���� ���� ��Ž��
		if(idx != 9)
			getDataTracking(idx + 1, sum);
		else
			System.out.println("getTracking:" + sum);
		
	}
	
	//��Ʈ��ŷ
	public void getBackDataTracking(int idx) {
		
		//���� ���� ��Ž��
		if(idx != 9)
			getBackDataTracking(idx + 1);
		
		//���� �۾�
		if(MAX % numArr[idx] == 0)
			backTrackingSum += numArr[idx];
		
		if(idx == 0) {
			System.out.println("backTrackingSum:" + backTrackingSum);
		}

	}
	
	public int getBackTracking(int idx, int sum) {
		
		//���� ���� ��Ž�� ����
		if(idx != 9)
			sum = getBackTracking(idx + 1, sum);
		
		//���� �۾�
		if(MAX % numArr[idx] == 0)
			sum += numArr[idx];
		
		return sum;
	}
}
