package Algorithm.GCD_LCM;

public class LCM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {1,3,5,2,4,131,132,133,141,150};
		
		int arrLth = arr.length;
		
		Soldier soldier = new Soldier("m4a1", "choi","40","175","second","kill all enemy");
		
		Soldier soldier2 = soldier;
		
		soldier2.height = "change";
		
		String name;
		name = soldier.name;
		
		if(soldier.name == name) {
			System.out.println("����");
		}else {
			System.out.println("�ٸ�");
		}
		
		System.out.println(soldier.height + " " + soldier.name + " " + name);
		
		soldier.name = "what thie";
		
		System.out.println(soldier.height + " " + soldier.name + " " + name);
	}

}

class Soldier{
	String weapon;
	String name;
	String weight;
	String height;
	String title;
	String mission;
	
	public Soldier(String weapon, String name, String weight, String height, String title, String mission) {
		this.weapon = weapon;
		this.name = name;
		this.weight = weight;
		this.height = height;
		this.title = title;
		this.mission = mission;
	}
	
	
}