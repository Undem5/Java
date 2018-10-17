import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class FileTransfertThreadsClient {

	private Socket s;
	
	
	public FileTransfertThreadsClient(String host, int port, String fils) {
		
		try {
			
			s = new Socket(host,port);
		
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	
	}
	
	public void sendFile(String file) throws IOException {
		
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		FileInputStream fis = new FileInputStream(file);
		
		byte[] buffer = new byte[4096];
		
		while( fis.read(buffer) > 0) {
			
			dos.write(buffer);
		}
		
		fis.close();
		dos.close();
		
		
	}
	
	public static void mian(String[] args) {
		FileTransfertThreadsClient toto = new FileTransfertThreadsClient("localhost",1998,"fichier.txt");
	}
}
