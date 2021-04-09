package tasks;

public class NamedTasks extends Tasks{
	private String[] names;
	private int namesLength;
	
	public NamedTasks(String[] names)
	//constructor
	{
		super(names.length);
		this.names = names;
		namesLength = names.length;
	}
	
	
	public boolean dependsOn(String task1, String task2)
	//converts the tasks from strings to integers and uses Tasks dependsOn method
	{
		int i = this.checkIfIn(task1);
		int j = this.checkIfIn(task2);
		if(i == -1  || j == -1)
			return false;
		super.dependsOn(i, j);
		return true;
	}
	
	
	public String[] nameOrder()
	//uses Tasks nameOrder and convert it to strings
	{
		int[] orderOfTasks = new int[namesLength];
		String[] namesInOrder = new String[namesLength];
		orderOfTasks = super.order();
		for(int i=0 ; i<namesLength ; i++)
		{
			namesInOrder[i] = names[orderOfTasks[i]];
		}
		return namesInOrder;
		
	}
	
	private int checkIfIn(String task)
	//check if the task is in names array
	{
		for(int i=0; i<names.length ; i++)
			if(names[i].equals(task) == true)
				return i;
		return -1;
	}

}
