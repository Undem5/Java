import javax.xml.bind.DatatypeConverter;

// StringBuffer methods sont synchronisées donc plus rapide que StringBuilder et propose même chose que StringBuilder

public class returnDigestInterface {

	
	//Programme main pour returnDigest pour récupérer la sortie du thread
	//Retourne NullPointerException car le main récupère la donnée avant que le thread l'initialise
	// dr.getDigest renvoi null donc son accès renvoi nullPpointerException
	
/*	public static void main(String[] args) {
		for(String file: args) {
			
			returnDigest dr = new returnDigest(file);
			dr.start();
			
			//Constructs a string builder initialized to the contents of the specified string.
			StringBuilder result = new StringBuilder(file);
			result.append(":");
			byte[] digest = dr.getDigest();
			result.append(DatatypeConverter.printHexBinary(digest));
			System.out.println(result);
			
		}
	}
*/
	//Solution où résultat aléatoire dépend archi
	
/*	public static void main(String[] args) {
		
		returnDigest[] digests = new returnDigest[args.length];
		
		for(int i=0; i < args.length; i++) {
			digests[i] = new returnDigest(args[i]);
			digests[i].start();
			
		}
		
		for( int i=0; i < args.length; i++) {
			
			StringBuffer result = new StringBuffer(args[i]);
			result.append(": ");
			byte[] digest = digests[i].getDigest();
			result.append(DatatypeConverter.printHexBinary(digest));
			System.out.println(result);
		}
	}
	*/
	
	// Polling: on utilise un flag pour déterminer quand on a récupérer les données mais toujours pourri si ordi trop puissant
	// et superloong
	
/*	public static void main(String[] args) {
		
		returnDigest[] digests = new returnDigest[args.length];
		
		for( int i=0; i < args.length; i++) {
			digests[i] = new returnDigest(args[i]);
			digests[i].start();
		}
		
		for( int i=0; i<args.length; i++) {
			while(true) {
				byte[] digest = digests[i].getDigest();
				if( digest != null) {
					StringBuffer result = new StringBuffer(args[i]);
					result.append(": ");
					result.append(DatatypeConverter.printHexBinary(digest));
					System.out.println(result);
					break;
				}
			}
		}
	}
*/
	
	
}
