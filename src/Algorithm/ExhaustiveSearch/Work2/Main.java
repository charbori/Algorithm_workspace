package Algorithm.ExhaustiveSearch.Work2;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int represent[] = {20, 12, 17, 23, 10, 15, 25, 8, 5};
		int sum = 0;
		int TOTAL = getSum(represent);
		int MAX = 100;
		
		ArrayList <Integer> list = new ArrayList<>();
		
		for(int i = 0; i < represent.length; i++) {
			for(int j = i + 1; j < represent.length; j++) {
				if(TOTAL - (represent[i] + represent[j]) == MAX) {
					for(int k=0;k<represent.length;k++) {
						if(k != i && k != j) {
							int temp = represent[k];
							list.add(represent[k]);
						}
					}
				}
			}
		}
		
		System.out.println(list.get(0) + " " + list.get(1) + " " + list.get(2) + " " +
				list.get(3) + " " + list.get(4) + " " + list.get(5) + " " + 
				list.get(6));
		
		DwarfHeightSum dwarf = new DwarfHeightSum();
		
		dwarf.combination(dwarf.dwarf, dwarf.dwarfList, 0, 9, 7);
		dwarf.getResult();
		
	}
	
	static int getSum(int[] value) {
		int sum = 0;
		
		for(int k=0;k<value.length;k++) {
			sum += value[k];
		}
		
		return sum;
	}

}
