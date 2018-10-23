import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FileTransfertThreadsServer extends Thread{

	
	private ServerSocket s;
	
	public FileTransfertThreadsServer(int port) {
		try {
			s = new ServerSocket(port);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void run() {
		
		while(true) {
			try {
				Socket client = s.accept();
				saveFile(client);
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	private void saveFile(Socket client) throws IOException {
		DataInputStream dis = new DataInputStream(client.getInputStream());
		
		File test = new File("test.txt");
		FileOutputStream fos = new FileOutputStream(test);
		
		byte[] buffer = new byte[4096];
		
		int filesize = (int) test.length();
		int read =0;
		int totalRead=0;
		int remaining = filesize;
		
		while( (read = dis.read(buffer)) != -1) {
			totalRead += read;
			remaining -= read;
			fos.write(buffer, 0, read);
		}
		
		fos.close();
		dis.close();
		
	}
	public static void main(String[] args) {
		FileTransfertThreadsServer fts = new FileTransfertThreadsServer(1998);
		fts.start();
	}
}
