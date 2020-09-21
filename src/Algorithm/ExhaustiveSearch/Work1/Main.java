package Algorithm.ExhaustiveSearch.Work1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BackTracking bt = new BackTracking();
		
		bt.getDataTracking(0, 0);
		bt.getBackDataTracking(0);
		int k = bt.getBackTracking(0, 0);
		System.out.println("return : " + k);
		
	}
	
	
}

class BruteForce{
	int result[] = new int[100];
	
	void pick(int n, int k, int toPick) {
		//���� ���
		if(toPick == 0 ) {
			System.out.println(result[0]);
		}
		//���� ���� ��ȣ ���

	}

}
