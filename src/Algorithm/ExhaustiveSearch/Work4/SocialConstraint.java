package Algorithm.ExhaustiveSearch.Work4;

/**
 * UVa 11742 ��ȸ�� ���� ����
 * @see <a href="https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=2842">https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show1_problem&problem=28421</a>
 * @author jaehyeok
 *
 */
public class SocialConstraint {
	
	int a,b,c;
	int p[] = {1,2,3,4,5,6};
	int n = 6;
	int m = 1;
	int restrict[] = {0, 0,-1};
	
	int count = 0;
	
	void solveProblem(int idx) {

		for(int startIdx = idx ;startIdx < n;startIdx++) {
			
			for(int i=0;i<n;i++) {
				
				if(p[i] == 1) {
					restrict[0] = i;
				}
				
				if(p[i] == 3) {
					restrict[1] = i;
				}
				
			}
			
			if(restrict[1] - restrict[0] == 1) {
				count++;

				System.out.println("���� : " + p[0] + " " + p[1] + " " + p[2] + " " + p[3] + " " + p[4] + " " + p[5] + " " );
				System.out.println("������ ������ �� : " + count);
				
				restrict[0] = 0;
				restrict[1] = 0;
				
			}
			
			swapData(idx, startIdx);

			System.out.println("���� : " + p[0] + " " + p[1] + " " + p[2] + " " + p[3] + " " + p[4] + " " + p[5] + " " );
						
			solveProblem(idx + 1);				

			swapData(idx, startIdx);
			
		}
		
	}
	
	void swapData(int a, int b) {
		int temp1 = p[a];
		int temp2 = p[b];
		
		p[a] = temp2;
		p[b] = temp1;
	}
}
