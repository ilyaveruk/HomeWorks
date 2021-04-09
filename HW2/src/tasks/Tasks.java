package tasks;

public class Tasks {
	private int num;
	private int[] orderOfTasks;
	private int[] depends;
	private int[] wait;
	
	public Tasks(int num)
	//constructor
	{
		this.num = num;
		orderOfTasks = new int[num];
		depends = new int[num];
		wait =new int[num];
		for(int i=0 ; i < num ; i++)
		{
			orderOfTasks[i] = i;
			depends[i] = -1;
			wait[i]= -1;
		}
	}
	
	public boolean dependsOn(int task1, int task2)
	//checks valid input and updates the "depends" array
	{
		if(task1 > num || task2 > num)
			return false;
		depends[task1] = task2;
		return true;
	}
	
	public int[] order()
	//this method run while counter < num that means that not all the order in place
	//and goes over the "depends" and "wait" array to check if it possible to put the task in "orderOfTasks"
	{
		int i,counter=0;
		while(counter < num)
		{
			for(i=0 ; i<num ; i++)
			{
				if(depends[i] == (-1) && wait[i] == (-1))
				{
					orderOfTasks[counter] = i;
					counter++;
					wait[i] = (-2);
					i = -1;
				}
				else if(depends[i] >= 0)
					if(wait[depends[i]] == (-2) && !(wait[i] == (-2)))
					{
						orderOfTasks[counter] = i;
						counter++;
						wait[i] = (-2);
						i = -1;
					}
				else if(wait[i] != (-2))
					wait[i] = i;
			}
		}
		return orderOfTasks;
		
	}
}
