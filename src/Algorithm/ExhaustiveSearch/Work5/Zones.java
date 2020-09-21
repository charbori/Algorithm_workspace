package Algorithm.ExhaustiveSearch.Work5;

/**
 * 
 * @see <a href="https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=3488">https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=3488</a>
 * @author jaehyeok
 *
 */
public class Zones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ProcessZones pz = new ProcessZones();
		
		pz.process(0);
		
//		CombinationTool combiTool = new CombinationTool();
//		
//		combiTool.combi(0, 6, 2, 0);

	}

}

class CombinationTool{
	
	int dataList[] = {1,3,5,7,9,11};
	int dataCombiList[] = new int[6];
	
	void processCombi(int index) {
		
	}
	
	void combi(int index, int n, int r, int target) {
		
		if(r == 0) {
			
			for(int i=0;i<dataList.length;i++) {
				System.out.print(dataCombiList[i] + " ");
			}
			
			
			System.out.println();
			
		}else if(target == n) {
			
			return ;
			
		}else {
			
			dataCombiList[index] = dataList[target];
			
			combi(index + 1, n, r - 1, target + 1);
			combi(index, n, r, target + 1);
			
		}
		
	}
}

class ProcessZones{
	
	int data[][] = { {15,20,25,30,24}, {25,25,25,25,25}, {25,25,25,25,25} };
	int commonTowerNum[] = {2,3,2,2,2};
	int commonTower[][] = {{0,1},{0,1,2},{1,2},{2,3},{3,4}};
	int commonTowerData[] = {7,3,2,5,6};
	boolean commonTowerChecker[] = {false,false,false,false,false};
	
	int tempAnswer = 0;
	int taskCounter = 0;
	
	int answerTowerPos[] = new int[6];
	int answer[][] = new int[3][6];
	int caseCount[] = new int[6];
	
	int depth = 2;
	int testCase = 3;
	int pickPos = 0;
	
	void process(int a) {
		
//		while(a < testCase) {
//			
//			backTracking(a, 0, 0, 3, 0);
//			
//			a++;
//		}
		
		combiBackTracking(0, 0, 5, 3, 0);
		
	}
	
	void combiBackTracking(int testCase, int index, int n, int r, int target) {
		
		if(r == 0) {

			tempAnswer = 0;
			
			for(int i=0; i<3; i++) {
				System.out.print(answer[testCase][i] + " ");
			
				tempAnswer += data[testCase][answer[testCase][i]];
			}
			
			for(int j=0; j<commonTowerNum.length;j++) {
				
				if(commonTowerNum[j] == 2) {
					if((commonTower[j][0] == answer[testCase][0] || commonTower[j][0] == answer[testCase][1] || commonTower[j][0] == answer[testCase][2]) 
							&& (commonTower[j][1] == answer[testCase][0] || commonTower[j][1] == answer[testCase][1] || commonTower[j][1] == answer[testCase][2])){
						tempAnswer -= commonTowerData[j];
					}
				}else {
					if((commonTower[j][0] == answer[testCase][0] || commonTower[j][0] == answer[testCase][1] || commonTower[j][0] == answer[testCase][2]) 
							&& (commonTower[j][1] == answer[testCase][0] || commonTower[j][1] == answer[testCase][1] || commonTower[j][1] == answer[testCase][2])
							&& (commonTower[j][2] == answer[testCase][0] || commonTower[j][2] == answer[testCase][1] || commonTower[j][2] == answer[testCase][2])){
						tempAnswer -= (2 * commonTowerData[j]);
					}
				}
			}
			
			System.out.println(" Answer : " + tempAnswer);
			
		}else if(target == n) {
			
			return;
			
		}else {
			
			answer[testCase][index] = target;
			
			combiBackTracking(testCase, index + 1, n, r-1, target+1);
			combiBackTracking(testCase, index, n, r, target+1);
			
		}
	}
}













