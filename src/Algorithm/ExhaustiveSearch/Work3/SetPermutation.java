package Algorithm.ExhaustiveSearch.Work3;

public class SetPermutation {
	
	int dataList[] = {1,2,3,4};
	
	void permutation(int idx, int end) {
		
		//���
		if(idx == end) {
			String result = "";
			
			for(int data : dataList) {
				result += String.valueOf(data);
			}
			
			System.out.println(result);
		}
		
		
		//��Ģ�� ���� �ݺ� �۾�
		for(int i=idx;i<end;i++) {
			swap(idx, i);
			permutation(idx + 1, end);
			swap(idx, i);
		}
	}
	
	void swap(int idx1, int idx2) {
		int temp = dataList[idx1];
		dataList[idx1] = dataList[idx2];
		dataList[idx2] = temp;
	}
	
}
