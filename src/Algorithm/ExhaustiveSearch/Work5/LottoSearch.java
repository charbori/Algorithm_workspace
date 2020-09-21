package Algorithm.ExhaustiveSearch.Work5;

/**
 * @see <a href="https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=382">https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=382</a>
 * @author jaehyeok
 *
 */
public class LottoSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int lottoList[] = {1,2,3,4,5,6,7};
		int lottoList2[] = {1,2,3,5,8,13,21,34};
		
		int arrSize1 = lottoList.length;
		int arrSize2 = lottoList2.length;
		int count = 0;
		
		for(int i = 0; i < arrSize1 - 5;i++) {
			
			for(int k = i + 1; k < arrSize1 - 4 ;k++) {
				
				for(int m = k + 1; m < arrSize1 - 3;m++) {
					
					for(int z = m + 1; z < arrSize1 - 2; z++){
						
						for(int l = z + 1; l < arrSize1 - 1; l++) {
							
							for(int n = l + 1; n < arrSize1; n++) {
								
								System.out.println("lotto : " + lottoList[i] + " "  + lottoList[k] + " "  + lottoList[m] + " " 
										 + lottoList[z] + " "  + lottoList[l] + " "  + lottoList[n]);
								
							}
						}
					}
				}
			}
		}
		
		for(int i = 0; i < arrSize2 - 5;i++) {
			
			for(int k = i + 1; k < arrSize2 - 4 ;k++) {
				
				for(int m = k + 1; m < arrSize2 - 3;m++) {
					
					for(int z = m + 1; z < arrSize2 - 2; z++){
						
						for(int l = z + 1; l < arrSize2 - 1; l++) {
							
							for(int n = l + 1; n < arrSize2; n++) {
								count++;
								System.out.println("lotto : " + lottoList2[i] + " "  + lottoList2[k] + " "  + lottoList2[m] + " " 
										 + lottoList2[z] + " "  + lottoList2[l] + " "  + lottoList2[n] + " count : " + count);
								
							}
						}
					}
				}
			}
		}
	}

}
