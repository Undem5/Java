import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ClientTransfert {

	protected final int BUFFER_SIZE = 10000;
	
	public static void main(String[] args) throws IOException {
		String nomFichier = "/home/userir/toto";
		ClientTransfert client = new ClientTransfert();
		client.tadah(nomFichier);
		
		
	}
	
	public void tadah(String nomFichier) throws IOException {
		InetAddress servAddr = InetAddress.getLoopbackAddress();
		Socket client = new Socket(servAddr,6666);
		File file = new File("/home/userir/tutu");
		
		byte[] buf = new byte[BUFFER_SIZE];
		byte[] fichier = nomFichier.getBytes();
		
		OutputStream out = client.getOutputStream();
		out.write(fichier);
		System.out.println("Demande de fichier envoyé");
		InputStream in = client.getInputStream();
		in.read(buf);
		System.out.println("Reception faite");
	
		System.out.println(new String(buf,0,buf.length));
		
		FileOutputStream fout = new FileOutputStream(file);
		fout.write(buf);
		System.out.println("Ecriture dans le fichier réussis");
	
		fout.close();
		in.close();
		out.close();
		client.close();
	}
}
