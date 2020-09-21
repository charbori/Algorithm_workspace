package Tutorial_Collections.Compares;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorAndComparable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String answer = "";
		String arr[] = {"1","3","15","99","999"};
		
		Comparator<String> com = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {

				return o2.compareTo(o1);
			}
			
		};
		
		Arrays.sort(arr, com);
		
		for(String arrNum: arr) {
			answer += arrNum;
		}
		
		System.out.println(answer);
		
	}
}
