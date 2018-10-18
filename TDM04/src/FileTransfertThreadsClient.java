import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class FileTransfertThreadsClient {

	private Socket s;
	
	
	public FileTransfertThreadsClient(String host, int port, String fils) {
		
		try {
			
			s = new Socket(host,port);
			sendFile(fils);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	
	}
	
	public void sendFile(String file) throws IOException {
		
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		FileInputStream fis = new FileInputStream(file);
		
		byte[] buffer = new byte[4096];
		int len;
		while( (len=fis.read(buffer)) != -1) {
			
			dos.write(buffer,0,len);
		}
		
		fis.close();
		dos.close();
		
		
	}
	
	public static void main(String[] args) {
		FileTransfertThreadsClient toto = new FileTransfertThreadsClient("localhost",1998,"output.img");
	}
}
