package game;



public class Board {
	protected int n, m;
	protected Player[][] board;

	public Board(int n, int m) {
		this.n = n;
		this.m = m;
		board=new Player [n][m];
		
	}

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
			
	@SuppressWarnings("unused")
	private int rayLength(int x, int y, int dx, int dy) {
		
		return 0;
	}
	
	protected int maxLineContaining(int i, int j) {
		
		return 0;
		
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
