package Algorithm.ExhaustiveSearch.Work5;

public class CitizenAttention {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int cityBlock[][][] = new int[4][5][5];
		
		cityBlock[0][2][2] = 1;

		cityBlock[1][0][0] = 1;
		cityBlock[1][4][4] = 1;
		cityBlock[1][0][4] = 1;
		cityBlock[1][4][0] = 1;

		cityBlock[2][0][0] = 1;
		cityBlock[2][1][1] = 1;
		cityBlock[2][2][2] = 1;
		cityBlock[2][3][3] = 1;
		cityBlock[2][4][4] = 1;

		cityBlock[3][4][2] = 2;
		cityBlock[3][3][3] = 1;
		cityBlock[3][2][4] = 3;
		cityBlock[3][2][1] = 1;
		cityBlock[3][1][3] = 4;
		cityBlock[3][1][2] = 2;
		cityBlock[3][1][0] = 1;
		
		int answerSum = 0;
		int tempSum = 0; 
		int answerIndex[][] = new int[4][5];
		
		int colSecondIndex, rowSecondIndex, colThirdIndex, rowThirdIndex, colFourthIndex, rowFourthIndex, colFifthIndex, rowFifthIndex;
		int colCityBlock, rowCityBlock;
		int testIndex = 0;
		
		while(testIndex < 4) {
			
			for(int firstIndex = 0; firstIndex < 21; firstIndex++) {
				
				int colFirstIndex = firstIndex / 5;
				int rowFirstIndex = firstIndex % 5;
				
				for(int secondIndex = firstIndex; secondIndex < 22; secondIndex++) {
					
					if(firstIndex != secondIndex) {
						
						colSecondIndex = secondIndex / 5;
						rowSecondIndex = secondIndex % 5;
						
						for(int thirdIndex = secondIndex; thirdIndex < 23; thirdIndex++) {
							
							if(secondIndex != thirdIndex && thirdIndex != firstIndex) {
								
								colThirdIndex = thirdIndex / 5;
								rowThirdIndex = thirdIndex % 5;
										
								for(int fourthIndex = thirdIndex; fourthIndex < 24; fourthIndex++) {
									
									if(firstIndex != fourthIndex && secondIndex != fourthIndex && thirdIndex != fourthIndex) {
										
										colFourthIndex = fourthIndex / 5;
										rowFourthIndex = fourthIndex % 5;
														
										for(int fifthIndex = fourthIndex; fifthIndex < 25; fifthIndex++) {
											
											colFifthIndex = fifthIndex / 5;
											rowFifthIndex = fifthIndex % 5;
											
											if(firstIndex != fifthIndex && secondIndex != fifthIndex && thirdIndex != fifthIndex && fifthIndex != fourthIndex) {

												tempSum = 0;
												
												for(int cityBlockIndex = 0; cityBlockIndex < 25; cityBlockIndex++) {
													
													colCityBlock = cityBlockIndex / 5;
													rowCityBlock = cityBlockIndex % 5;
													
													tempSum += cityBlock[testIndex][colFirstIndex][rowFirstIndex]
															* (Math.abs(colFirstIndex - colCityBlock) + Math.abs(rowFirstIndex - rowCityBlock));
													tempSum += cityBlock[testIndex][colSecondIndex][rowSecondIndex]
															* (Math.abs(colSecondIndex - colCityBlock) + Math.abs(rowSecondIndex - rowCityBlock));
													tempSum += cityBlock[testIndex][colThirdIndex][rowThirdIndex]
															* (Math.abs(colThirdIndex - colCityBlock) + Math.abs(rowThirdIndex - rowCityBlock));
													tempSum += cityBlock[testIndex][colFourthIndex][rowFourthIndex]
															* (Math.abs(colFourthIndex - colCityBlock) + Math.abs(rowFourthIndex - rowCityBlock));
													tempSum += cityBlock[testIndex][colFifthIndex][rowFifthIndex]
															* (Math.abs(colFifthIndex - colCityBlock) + Math.abs(rowFifthIndex - rowCityBlock));
													
												}
												
												if(tempSum > answerSum) {
													
													answerSum = tempSum;
													
													answerIndex[testIndex][0] = firstIndex;
													answerIndex[testIndex][1] = secondIndex;
													answerIndex[testIndex][2] = thirdIndex;
													answerIndex[testIndex][3] = fourthIndex;
													answerIndex[testIndex][4] = fifthIndex;
												}

												
											}
											
										}
										
									}
									
								}
								
							}
							
						}
						
					}
					
				}
				
				
				
			}
			
			answerSum = 0;
			
			System.out.println("testCase : " + answerIndex[testIndex][0] + " "  + answerIndex[testIndex][1] + " " 
					 + answerIndex[testIndex][2] + " "  + answerIndex[testIndex][3] + " "  + answerIndex[testIndex][4] + " " );
			
			testIndex++;
		}
		
	}

}
