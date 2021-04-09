package game;



public class Board {
	protected int n, m;
	protected Player[][] board;

	public Board(int n, int m) {
		this.n = n;
		this.m = m;
		board=new Player [n][m];
		
	}

	//checks if the board[i][j] is empty if it does it sets player "p" and return true
	//if it doesn't return false
	protected boolean set(int i, int j, Player p) {

		if (board[i][j] == null) {
			board[i][j] = p;
			return true;
		} 
		else
			return false;
	}

	public boolean isEmpty(int i, int j) {
		if (board[i][j] == null)
			return true;
		else
			return false;
	}

	public Player get(int i, int j) {

		if (board[i][j] == null)
			return null;
		else
			return board[i][j];
	}

	public boolean isFull() {

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (board[i][j] == null)
					return false;
		return true;
	}
	
	public String toString() {
		
		String str="";
		for (int i = 0; i < n; i++) {
			str += "\n";
			for (int j = 0; j < m; j++) 
				if(board[i][j]!= null) 
					str+=board[i][j].getMark();
				else
					str+= ".";
		}	
		return str;		
	}		
			
	
	private int rayLength(int x, int y, char s1, char s2, char mark) {
		
		char Mark1;
		if(this.get(x, y) == null)
			return 0;
		Mark1 = this.get(x, y).getMark();
		if(s1 == 'd' && s2 == 'r')
		{
			if((x == n-1 || y == m-1) && (Mark1 == mark))
					return 1;
			else if(Mark1 == mark)
				return 1+this.rayLength(x+1, y+1, s1, s2, mark);
			else return 0;
			
		}
		else if(s1 == 'd' && s2 == 'l')
		{
			if((x == n-1 || y == 0) && (Mark1 == mark))
				return 1;
			else if(Mark1 == mark)
				return 1+this.rayLength(x+1, y-1, s1, s2, mark);
			else return 0;
			
		}
		else if(s1 == 'u' && s2 == 'r')
		{
			if((x == 0 || y == m-1) && (Mark1 == mark))
				return 1;
			else if(Mark1 == mark)
				return 1+this.rayLength(x-1, y+1, s1, s2, mark);
			else return 0;
			
		}
		else if(s1 == 'u' && s2 == 'l')
		{
			if((x == 0 || y == 0) && (Mark1 == mark))
				return 1;
			else if(Mark1 == mark)
				return 1+this.rayLength(x-1, y-1, s1, s2, mark);
			else return 0;
			
		}
		else if(s1 == 'u')
		{
			if((x == 0) && (Mark1 == mark))
				return 1;
			else if(Mark1 == mark)
				return 1+this.rayLength(x-1, y, s1, s2, mark);
			else return 0;
			
		}
		else if(s1 == 'd')
		{
			if((x == n-1) && (Mark1 == mark))
				return 1;
			else if(Mark1 == mark)
				return 1+this.rayLength(x+1, y, s1, s2, mark);
			else return 0;
			
		}
		else if(s2 == 'r')
		{
			if((y == m-1) && (Mark1 == mark))
				return 1;
			else if(Mark1 == mark)
				return 1+this.rayLength(x, y+1, s1, s2, mark);
			else return 0;
		}
		else if(s2 == 'l')
		{
			if((y == 0) && (Mark1 == mark))
				return 1;
			else if(Mark1 == mark)
				return 1+this.rayLength(x, y-1, s1, s2, mark);
			else return 0;
		}
		return 0;
	}
	
	protected int maxLineContaining(int i, int j) {
		
		char s1='x',s2='y',Mark1;
		int k,l,max=0,temp;
		if(this.get(i, j) == null)
			return 0;
		Mark1 = this.get(i, j).getMark();
		for(k=0 ; k<3 ; k++)
		{
			for(l=0 ; l<3 ; l++)
			{
				if(k == 0)//down
					s1='d';
				if(k == 1)//up
					s1='u';
				if(l == 0)//left
					s2='l';
				if(l == 1)//right
					s2='r';
				temp = this.rayLength(i, j, s1, s2, Mark1);
				if(temp > max)
				{
					max = temp;
				}
				s1='x'; s2='y';
			}
		}
		return max;
		
	}
	
	

	
//	public static void main(String[] args) {
//		Player p1 = new Player("Bibi", 'B');
//		Player p2 = new Player("Gantz", 'G');
//		Board b = new Board(3,4);
//		b.set(0, 0, p1);
//		b.set(0, 1, p1);
//		b.set(0, 2, p2);
//		b.set(0, 3, p2);
//		b.set(1, 0, p1);
//		b.set(1, 1, p2);
//		b.set(1, 2, p1);
//		b.set(1, 3, p2);
//		b.set(2, 0, p1);
//		b.set(2, 1, p1);
//		b.set(2, 2, p2);
//		b.set(2, 3, p1);
//		
//		System.out.println(b);
//		System.out.println(b.isFull());
//		System.out.println();
//		System.out.println(b.get(1, 3));
//		
//
//	}

}
