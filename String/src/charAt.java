
public class charAt {

	public static void main(String[] args) {
		
		String line = "Hello World";
		
		for(int i=0; i<line.length();i++) {
			System.out.println("Char at " + i +" is " + line.charAt(i));
		}
		
		for(char ch : line.toCharArray()) {
			System.out.println( ch);
		}
	}
}
