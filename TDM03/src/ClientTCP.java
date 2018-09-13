import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ClientTCP {

	
	public static final int PORT = 6666;
	
	public static void main(String[] args) throws IOException {
		
		ClientTCP client1 = new ClientTCP();
		client1.runClient();
	}
	
	public void runClient() throws IOException {
		InetAddress serv = InetAddress.getLoopbackAddress();
		Socket client = new Socket(serv, PORT);
		
		PrintWriter out = new PrintWriter(client.getOutputStream(),true);
		BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		
		out.println("Toto");
		String line = in.readLine();
		System.out.println(line	);
		
		System.out.println("End client");
		out.close();
		in.close();
		client.close();
	}
}
