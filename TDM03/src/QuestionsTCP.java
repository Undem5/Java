import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class QuestionsTCP {

	
	public static void main(String[] args) throws IOException {
		QuestionsTCP question = new QuestionsTCP();
		question.runJeu();
	}
	
	public void runJeu() throws IOException {
		
		InetAddress servAddr = InetAddress.getByName("192.168.130.150");
		Socket client = new Socket(servAddr, 7500);
		System.out.println("Client lance");
		PrintWriter out = new PrintWriter(client.getOutputStream(),true);
		//BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		InputStream in = client.getInputStream();
		
		String line;
		byte[] cbuf = new byte[1024];
		
		System.out.println("test");
		in.read(cbuf); 
	
		line = new String(cbuf,0,cbuf.length);
		
		System.out.println("La question est :" + line);
		String reponse = decode(line);
		System.out.println("La réponse est: " + reponse);
		out.println(reponse);
		in.read(cbuf);
		System.out.println("Reponse du severu " + new String(cbuf,0,cbuf.length));
		out.close();
		in.close();
		client.close();
	}
	
	public String decode(String line) {
		
		StringBuilder message = new StringBuilder(line);
		StringBuilder message2;
		int position1, position2;
		int nombre1, nombre2;
		
		position1 = message.indexOf("=");
		StringBuilder operation = new StringBuilder(message.substring(0,position1));
		position2 = operation.indexOf("+");
		nombre1 = Integer.parseInt(operation.substring(0,position2));
		nombre2 = Integer.parseInt(operation.substring(position2+1, position1));
		
		String res = String.valueOf(nombre1 + nombre2);
		res.concat(";");
		message2 = new StringBuilder( message.substring(position1+2));
		
		if( (message2.indexOf("=")) != -1) {
			System.out.println("Seconde Question");
		}
		return res;
	}
	
}
