package Algorithm.ExhaustiveSearch.Work5;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class ThreeSquare {

	public static void main(String[] args) {
		
		int dataArr[] = new int [225];
		int target = 50000;
		Map <Integer, Integer> dataMapList = new HashMap<>();
		
		int dataLength = dataArr.length;
		String answer = "-1";
		
		for(int dataSette = 0; dataSette < dataLength; dataSette++) {
			dataArr[dataSette] = dataSette * dataSette;
		}
		
		for(int firstPickIdx = 0; firstPickIdx < dataLength; firstPickIdx++) {

			for(int secondPickIdx = 0; secondPickIdx < dataLength; secondPickIdx++) {
				
				for(int thirdPickIdx = 0; thirdPickIdx < dataLength; thirdPickIdx++) {
					
//					if(target == (int) (dataMapList.get(firstPickIdx) + dataMapList.get(secondPickIdx) + dataMapList.get(thirdPickIdx))) {
//						
//					}
					if(target == (dataArr[firstPickIdx] + dataArr[secondPickIdx] + dataArr[thirdPickIdx])) {
						answer = String.valueOf(dataArr[firstPickIdx])
								 + " " + String.valueOf(dataArr[secondPickIdx]) 
								 + " " + String.valueOf(dataArr[thirdPickIdx]);
					}
				}
			}
		}
		
		if(answer.equals("-1"))
			System.out.println("no solution");
		else
			System.out.println("�� : " + answer);
		
		answer = "-1";
		
	}

}

class SolutionGithub{
	
	double k = 5000;
	Vector<Integer> vector = new Vector<Integer>();
	boolean flag = false;
	
	void process() {

		int powM = (int) Math.sqrt(k);
		
		for(int j=0; j<powM; j++) {
			double tempK = k - (j*j);
			for(int z=0; z<=powM;z++) {
				double tempK2 = tempK - (z*z);
				int temp = (int) Math.sqrt(tempK2);
				if((temp * temp) == (int) tempK2) {
					vector.add(j);
					vector.add(z);
					vector.add(temp);
					flag = true;
					break;
				}
			}
			if(flag) break;
		}
		
		if(vector.size() == 3)	System.out.println(vector.get(0) + " " + vector.get(1) + " " + vector.get(2));
		else System.out.println("-1");
	}
}


















