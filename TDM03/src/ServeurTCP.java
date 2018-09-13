import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurTCP {

	public static void main(String[] args) throws IOException {
		ServeurTCP serveur = new ServeurTCP();
		serveur.runServer();
	}
	
	public void runServer() throws IOException {
		ServerSocket serv = new ServerSocket(6666,2);
		Socket client = serv.accept();
		System.out.println("Serveur Lancé sur " + client.getInetAddress().getHostAddress() + " " + client.getPort());
		
		PrintWriter out = new PrintWriter(client.getOutputStream(),true);
		BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		String line;
		
		out.println("Teeeest");
		while( (line = in.readLine()) != null) {
			System.out.println(line);
		}
		
		System.out.println("END");
		out.close();
		in.close();
		client.close();
		serv.close();
		
		
	}
}
