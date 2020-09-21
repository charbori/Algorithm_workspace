package Algorithm.AlgorithmShift;

public class BackTracking {
	
	int noneTarget = 0;
	int end = 3;
	int dataList[] = {1,2,3,4,5,6,7,8,9,10};
	int dataLth = dataList.length;
	
	String depthGraph[] = {"","",""};
	
	int count = 0;
	
	void process(int idx, int end) {
		
		backTracking(idx, this.noneTarget, end);
		System.out.println(depthGraph[0] + "\n" + depthGraph[1] + "\n" + depthGraph[2]);
	}
	
	void backTracking(int idx, int target, int end) {
		
		if(this.end == end) {
			return ;
		}else {
			if(end == 0) {
				for(int i = 0; i < dataLth - idx; i++) {
					depthGraph[end] += "  ";
				}	
			}else {
				for(int i = 0; i < dataLth - idx; i++) {
					depthGraph[end] += " ";
				}
			}
			
		}
		
		for(int j = idx; j < dataLth; j++) {
			
			this.count += 1;

			System.out.println("���� ī��Ʈ : " + this.count + " ����/��ġ : " + end + "/" + j);
			
			
			depthGraph[end] += ( "[" + String.valueOf(j) + "]");
			
			backTracking(j, this.noneTarget, end + 1);
			
			//System.out.println("��Ʈ��ŷ ���� ī��Ʈ : " + this.count + " ����/��ġ : " + end + "/" + j);
			//this.count += 1;
			
		}
		
	}
}
