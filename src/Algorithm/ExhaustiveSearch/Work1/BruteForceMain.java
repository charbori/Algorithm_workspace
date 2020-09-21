package Algorithm.ExhaustiveSearch.Work1;

/**
 * ���� Ž���� �ϳ��� �з������̴�.
 * ���� ������� �������� �˰��� ������ �ִ�.
 * ����Ž��, ��Ʈ����ũ, ����, ��Ʈ��ŷ, BFS
 * ������ 10�� ����� ���ϱ�� ���ߴ�.
 * @author jaehyeok
 *
 */
public class BruteForceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] numArr = {1,2,3,4,5,6,7,8,9,10};
		
		int sum = 0;
		
		for(int i=0;i < numArr.length; i++) {
			if( 10 % numArr[i] == 0 ) {
				sum += numArr[i];
			}
		}
		
		System.out.println("for�� ����� ��:" + sum);
		
		BackTrackingExam backTracking = new BackTrackingExam();
		
		backTracking.getResult(0, 0);
		System.out.println(backTracking.getBackTracking(0));
		
	}

}

class BackTrackingExam{

	int[] numArr = {1,2,3,4,5,6,7,8,9,10};
	
	//int sum = 0;
	int backTrackingSum = 0;
	int answer = 0;
	
	void getResult(int idx, int sum) {
		
		//���� �۾�
		if(10 % numArr[idx] == 0) {
			sum += numArr[idx];
		}
		
		//�ݺ� ����
		if(idx < numArr.length - 1) {
			
			getResult(idx+1, sum);
		}else {
			System.out.println("Ʈ��ŷ ����� ��:" + sum);
		}
		
	}
	
	int getBackTracking(int idx) {
		
		//���� �۾�
		
		
		//�ݺ� ����
		if(idx < numArr.length - 1) {
			getBackTracking(idx + 1);
		}else {
			System.out.println("getBackTracking ����� ��:" + answer);
		}
		
		//��Ʈ��ŷ �۾�
		if(10 % numArr[idx] == 0) {
			answer += numArr[idx];
		}
		
		if(idx == 0) {
			System.out.println("��Ʈ��ŷ ����� ��:" + backTrackingSum);
		}
		
		return answer;
	}
	
}
