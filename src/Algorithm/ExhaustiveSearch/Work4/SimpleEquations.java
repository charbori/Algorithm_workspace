package Algorithm.ExhaustiveSearch.Work4;

/**
 * UVa 11565 ������ ������ ����
 * See <a href="https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=2612">https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=2612</a>
 * @author jaehyeok
 *
 */
public class SimpleEquations {
	
	int x, y, z;
	int A, B, C;
	
	boolean sol = false;
	
	void solveProblem() {
		
		A = 100;
		B = 27404;
		C = 3954;
		
		for(x = -100; x <= 100; x++) {
			for(y = -100; y <= 100; y++) {
				for(z = -100; z <= 100; z++) {
					if(y != x && z != x && z != y && x + y + z == A && x*y*z == B && x*x + y*y + z*z == C) {
						if(!sol) 
							System.out.println("x : " + x + " y : " + y + " z : " + z);
						sol = true;
					}
				}
			}
		}
	}
}
