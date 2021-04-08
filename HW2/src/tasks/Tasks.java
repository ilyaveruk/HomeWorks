package tasks;

public class Tasks {
	private int num;

	public Tasks(int num) {
		this.num = num;
	}

	public boolean dependsOn(int task1, int task2) {

		if (task1 > num || task2 > num)
			return false;
		else 
			return true;
		

	}
	
	public int[] order() {
		
		
	}
}
