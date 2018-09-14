import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class FileTransfertSocket {

	/* Serveur qui renvoit le fichier demandé */
	
	
	public static void main(String[] args) throws IOException {
		FileTransfertSocket server = new FileTransfertSocket();
		server.transfertSocket();
		
	}
	
	public void transfertSocket() throws IOException {
		
		ServerSocket server = new ServerSocket(6666);
		byte[] buf;
		Socket client = server.accept();
		
		System.out.println("Serveur lancé");
		System.out.println("Client connecté sur port " + client.getPort());
	
		InputStream in = client.getInputStream();
		byte[] nomFichier = new byte[10000];
		in.read(nomFichier);
		String file = new String(nomFichier,0,nomFichier.length);
		
		System.out.println("Le fichier demandé est "+ file);
		file = file.trim();
		File fichier = new File(file);
		
		buf = new byte[1000000000];
		FileInputStream in1 = new FileInputStream(fichier);
		java.io.OutputStream out = client.getOutputStream();
		int len = in1.read(buf);
		

		while( len >= 0) {
			out.write(buf, 0, len);
			System.out.println("biiiiiiiiiiiiiiiiiiiiiite");
			len = in1.read(buf);
			
		}
		
		
		System.out.println("Contenu envoyé");
		
		in1.close();
		out.close();
		in.close();
		client.close();
		server.close();
		
		
	}
}
