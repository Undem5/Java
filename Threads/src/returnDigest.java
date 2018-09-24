import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class returnDigest extends Thread{

	// Dans le cas où un Thread doit retourner une valeur au Thread principal
	// run() et start() sont de types void
	
	private String filename;
	private byte[] digest;
	
	public returnDigest(String filename) {
		this.filename = filename;
	}
	
	public void run() {
		try {
			FileInputStream in = new FileInputStream(filename);
			MessageDigest sha = MessageDigest.getInstance("SHA-256");
			DigestInputStream din = new DigestInputStream(in,sha);
			while( din.read() != -1);
			din.close();
			digest = sha.digest();
		}catch(IOException ex) {
			System.err.println(ex);
		}catch(NoSuchAlgorithmException ex) {
			System.err.println(ex);
		}
	}
	
	public byte[] getDigest() {
		return digest;
	}
	
	
	
	
}
