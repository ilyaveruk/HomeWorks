package images;

public class MainForDebug {
	public static void main(String[] args) {
		RGB s= new RGB (0.4,0.6,1);
		RGB r= new RGB (0.7,0.8,0.6);
		RGB rs=null;
		System.out.println(rs.superpose(r, s).toString());
	}
}
