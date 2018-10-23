import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileTransfert {

	
	public static void main(String[] args) throws IOException {
		File file = new File("/home/userir/toto");
		FileTransfert fichier = new FileTransfert();
		fichier.transfert(file);
		
	}
	
	
	public void transfert(File file) throws IOException {
		
		byte[] buf = new byte[(int) file.length()];
		File file2 = new File("/home/userir/toto2");
	
		
		//BufferedReader in = new BufferedReader( new FileReader(file));
		
		FileInputStream in = new FileInputStream(file);
		
		
		FileOutputStream out = new FileOutputStream(file2);
	
		in.read(buf);
		System.out.println("Lecture réussie ");
		out.write(buf);
		System.out.println("Ecriture réussie");
		in.close();
		out.close();
		
	
	}
}
