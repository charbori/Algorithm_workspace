package Algorithm.ExhaustiveSearch.Work2;

/**
 * ���� Ž�� �˰��� ������ �غ���
 * ��Ʈ��ŷ�� Brute Force �˰����� �̿��Ͽ�
 * @author jaehyeok
 *
 */
public class DwarfHeightSum {
	
	int dwarf[] = {20, 7, 23, 19, 10, 15, 25, 8, 13};
	boolean dwarfList[] = new boolean[9];
	
	void combination(int[] arr, boolean[] visited, int start, int end, int remain) {
		
		if(remain == 0) {
			//���� �Ϸ�!
			return;
		} else {
			for(int i=start; i<end; i++) {
				visited[i] = true;
				combination(arr, visited, i + 1, end, remain - 1);
				visited[i] = false;
			}
		}
		
	}
	
	void getResult() {
		String result = "";
		int i = 0;
		
		for(int dwarfHeight : dwarf) {
			if(dwarfList[i] == true)
				result += (" " + String.valueOf(dwarfHeight));
			i++;
		}
		
		System.out.println(result);
	}
	
}
