package Algorithm.AlgorithmShift;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BackTracking bt = new BackTracking();
		
		bt.process(0, 0);
		
		BackTrackingShift bts = new BackTrackingShift();
		
		bts.process(0);
		
		BackTrackingPick btp = new BackTrackingPick();
		
		btp.process();
		
		BackTrackingCombi btc = new BackTrackingCombi();
		
		btc.process();
	}

}
