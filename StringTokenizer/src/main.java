import java.util.StringTokenizer;

public class main {

	public final static int MAXFIELD = 5;
	public final static String DELIM ="|";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Process one String to an array of strings
		String[] results = new String[MAXFIELD];
		String line = "A|B|Hello | TEEEST";
		StringTokenizer st = new StringTokenizer(line,DELIM,true);
		int i=0;
		
		while( st.hasMoreTokens() && i<MAXFIELD) {
			
			String s = st.nextToken();
			results[i] = s;
			System.out.println(s);
			i = i++;
		}
		
		System.out.println("Process finished...");
		
		
	}
	

}
