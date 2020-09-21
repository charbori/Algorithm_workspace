package Algorithm.ExhaustiveSearch.Work5;

public class GroceryStore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int sum = 0;
		int multiRes = 0;
		long countPro = 0;
		int answer = 0;
		
		int d = 0;
		
		for(int firP = 1; firP <= 500; firP++) {
			
			for(int secP = firP; firP + secP * 3 <= 2000; secP++) {
				
				for(int triP = secP; firP + secP + triP * 2 <= 2000; triP++) {
					
					sum = firP + secP + triP;
					
					d = 0;
					
					if(sum < 2000) {
						
						multiRes = firP * secP * triP;
						
						if(multiRes != 1000000) {
							
							d = sum * 1000000 / (multiRes - 1000000);
							
							if( d > 1 
								&& ( d + sum < 2001 )
								&& ((sum * 1000000 % (multiRes - 1000000) == 0)
								&& ( triP <= d)) 
								&& (multiRes * d < 2000000000)
									) 
							{
								answer++;
							}	
							
						}
						
					}
					
					countPro++;
				}
					
			}
		}
		
		System.out.println("�� ����� : " + countPro + " �� : " + answer);
	}

}
