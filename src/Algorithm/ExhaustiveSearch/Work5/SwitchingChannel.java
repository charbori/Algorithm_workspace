package Algorithm.ExhaustiveSearch.Work5;

public class SwitchingChannel {

	static int dataList[][] = {{30,45,45,15},{10,15,13,18,25,33}};
	static int dataStream[][] = {{60,90,15},{30,15,45,60}};
	static int dataImportance[][] = {{1,2,3},{1,2,2,1}};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int dataLength = 0;
		int dataStreamLength = 0;
		
		int answerCase[][] = new int[2][6];
		int answerDuration[][] = new int[2][2];
		
		int answerError[] = new int[2];
		int answerDataL[][] = new int[2][6];
		
		int testCase = 0;
		int target = 100000;
		
		ChannelProblem cp = new ChannelProblem();
		
		while(testCase < 2) {
			
			dataLength = dataList[testCase].length;
			dataStreamLength = dataStream[testCase].length;
			
			cp.process(testCase, 0, dataLength, dataStreamLength, target);
			cp.sysout();
			
			testCase++;
		}
		
	}

}

class ChannelProblem{

	int dataList[][] = {{30,45,45,15},{10,15,13,18,25,33}};
	int dataStream[][] = {{60,90,15},{30,15,45,60}};
	int dataImportance[][] = {{1,2,3},{1,2,2,1}};
	
	int dataLength = 0;
	int dataStreamLength = 0;
	
	int answerCase[][] = new int[2][6];
	int answerDuration[][] = new int[2][2];
	
	int answerError[] = new int[2];
	int answerDataL[][] = new int[2][6];
	
	int testCase = 0;
	int target = 100000;
	
	
	void process(int testCase, int index, int dataLength, int dataStreamLength, int target) {
		
		if(index == dataLength) {
			
			System.out.println("Order:" + answerCase[0][0] + " "  + answerCase[0][1] + " " 
					 + answerCase[0][2] + " "  + answerCase[0][3] + " " );

			int errorDataList = 0;

			for(int l=0; l < dataStreamLength;l++) {

				int errorL = dataStream[testCase][l];
				
				for(int k=0; k<dataLength;k++) {
				
					if(errorL - dataList[testCase][k] > 0) {
						errorL = errorL - dataList[testCase][k];
					}else {
						errorL = dataImportance[testCase][l] * (dataList[testCase][k] + errorL);
						
						break;
					}
				}
				
				errorDataList += errorL;
				
			}
			
			if(answerError[testCase] > errorDataList) {
				answerError[testCase] = errorDataList;
				answerDataL[testCase] = answerCase[testCase];
			}
			
		}
		
		for(int startIndex = index; startIndex < dataLength; startIndex++) {
			
			answerCase[testCase][startIndex] = dataList[testCase][startIndex];
						
			swap(testCase, index, startIndex);
			
			process(testCase, startIndex + 1, dataLength, dataStreamLength, target + 1);
			
			swap(testCase, index, startIndex);
			
		}
		
	}
	
	void swap(int testCase, int a, int b ) {
		
		int temp = dataList[testCase][a];
		dataList[testCase][a] = dataList[testCase][b];
		dataList[testCase][b] = temp;
				
	}
	
	void sysout() {

		System.out.println("error:" + answerError[0]);
		System.out.println("Order:" + answerDataL[0][0] + " "  + answerDataL[0][1] + " " 
				 + answerDataL[0][2] + " "  + answerDataL[0][3] + " " );

		System.out.println("error:" + answerError[1]);
		System.out.println("Order:" + answerDataL[0][0]  + " " + answerDataL[0][1] + " " 
				 + answerDataL[0][2] + " "  + answerDataL[0][3] + " " 
				 + answerDataL[0][4] + " "  + answerDataL[0][5] + " " );
	}
}
