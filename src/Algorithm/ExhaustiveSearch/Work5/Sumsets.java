package Algorithm.ExhaustiveSearch.Work5;

import java.util.Arrays;

/**
 * @see <a href="https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=1066">https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=1066</a>
 * @author jaehyeok
 *
 */
public class Sumsets {

	public static void main(String[] args) {

		int dataList[] = {5,2,3,5,7,12,5,2,16,256,1024,0};
		
		int low = 0;
		int mid = 0;
		int high = dataList.length;
		
		int target = 0;
		int answer = 0;
		int answerIdx = 0;
		
		Arrays.sort(dataList);

		for(int firstPickIdx = 0; firstPickIdx < dataList.length - 2; firstPickIdx++) {
			
			for(int secondPickIdx = firstPickIdx + 1; secondPickIdx < dataList.length - 1; secondPickIdx++) {

				for(int thirdPickIdx = secondPickIdx + 1; thirdPickIdx < dataList.length; thirdPickIdx++) {
					
					target = dataList[firstPickIdx] + dataList[secondPickIdx] + dataList[thirdPickIdx];
							
					low = 0;
					mid = 0;
					high = dataList.length;
					
					while(low < high) {
						mid = (low + high) / 2;
						//System.out.println("low:" + low  + " mid: " + mid + " high:" + high);
						
						if(dataList[mid] == target) {
							if(answer < dataList[mid]) {
								answer = dataList[mid];
								//System.out.println("�� : " + answer);
								answerIdx = mid;
							}
							break;
						}else if(dataList[mid] > target) {
							high = mid - 1;
						}else
							low = mid + 1;
						
					}
					
//					for(int answerIdxF = 0; answerIdxF < dataList.length; answerIdxF++) {
//						if(dataList[answerIdxF] == target) {
//							if(target > answer)
//								answer = dataList[answerIdxF];
//						}
//					}
					
				}
			}
		}
		
		System.out.println("�� : " + answer);
	}
}