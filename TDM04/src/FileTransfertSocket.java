import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;

public class FileTransfertSocket {

	/* Serveur qui renvoit le fichier demandé */
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		FileTransfertSocket server = new FileTransfertSocket();
		server.transfertSocket();
	}
	
	public void transfertSocket() throws IOException, InterruptedException {
		
		ServerSocket server = new ServerSocket(6666);
		Socket client = server.accept();
		
		System.out.println("Serveur lancé");
		System.out.println("Client connecté sur port " + client.getPort());
	
		InputStream in = client.getInputStream();
		OutputStream out = client.getOutputStream();

		
		//byte[] nomFichier = new byte[10000];
	//	in.read(nomFichier);
	//	String file = new String(nomFichier,0,nomFichier.length);
		
		//System.out.println("Le fichier demandé est "+ file);
	//	file = file.trim();
		File fichier = new File("tutu");
		
		byte[] buf = Files.readAllBytes(fichier.toPath());

		int len = buf.length;
		int i = 0;
	
		
		while( len >= 0) {
			System.out.println(client.isConnected());
			Thread.sleep(700);
			out.write(buf,i, i + 1000);
			out.flush();
			i = i + 1001;
			len = len - 50;
			System.out.println("------------------------");
			System.out.println((repeat("*", (int)i/1000)));
		}
	
		
		System.out.println("Contenu envoyé");
		
		out.close();
		in.close();
		client.close();
		server.close();
		out.close();

		
	}
	
	public static String repeat(String str, int times) {
		
		return new String( new char[times]).replace("\0", str);	
	}
}
