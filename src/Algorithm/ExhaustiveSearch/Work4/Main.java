package Algorithm.ExhaustiveSearch.Work4;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SimpleEquations simpleEquations = new SimpleEquations();
		
		//simpleEquations.solveProblem();
		
		SocialConstraint socialCon = new SocialConstraint();
		
//		socialCon.solveProblem(0);
		
		QueensChessProblem queensChess = new QueensChessProblem();
		
		//queensChess.backTrack(0);
		
		queensChess.backTracking((0));
	}

}