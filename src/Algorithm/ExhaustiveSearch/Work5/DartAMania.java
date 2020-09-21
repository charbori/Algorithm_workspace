package Algorithm.ExhaustiveSearch.Work5;

import java.util.ArrayList;

/**
 * @see <a href="https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=676">https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=676</a>
 * @author jaehyeok
 *
 */

public class DartAMania {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int scoreList[] = {162,175,2,68,211,114};
		
		ArrayList <Integer> dartScore = new ArrayList<>();
		
		int combinationCount = 0;
		int permutationCount = 0;
		
		for(int index = 1; index < 21; index++) {
			
			if(!dartScore.contains(index)) {
				dartScore.add(index);	
			}
			if(!dartScore.contains(index * 2)) {
				dartScore.add(index * 2);
			}
			if(!dartScore.contains(index * 3)) {
				dartScore.add(index * 3);
			}
			
		}
		
		dartScore.add(0);
		dartScore.add(50);
		
		int dartLength = dartScore.size();
		
		int testCase = 0;
		
		while(testCase < scoreList.length) {
			
			for(int i = 0; i < dartLength; i++) {
				
				for(int k = 0; k < dartLength; k++) {
					
					for(int m = 0; m < dartLength; m++) {
						
						if(scoreList[testCase] == (int) ((int)dartScore.get(i) + (int)dartScore.get(k) + (int)dartScore.get(m))) {
							combinationCount += 1;
						}
						
					}
				}
			}

			System.out.println("combinationcount : " + combinationCount);
			
			combinationCount = 0;
			
			testCase++;
		}
		
	}

}
