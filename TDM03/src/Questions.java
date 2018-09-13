import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class Questions {

	
	public final static int PORT = 7001;
	protected static int BUFFER_SIZE = 1000;
	
	public static void main(String[] args) throws IOException {
		Questions jeu = new Questions();
		
	}
	
	public Questions() throws IOException {
		
		InetAddress servAddr = InetAddress.getLoopbackAddress();
		DatagramSocket sock = new DatagramSocket();
		byte[] buffer= "JOUER".getBytes();
		byte[] reponse = new byte[BUFFER_SIZE];
		
		DatagramPacket request = new DatagramPacket(buffer,buffer.length,servAddr,PORT);
		DatagramPacket response = new DatagramPacket(reponse,reponse.length,servAddr,PORT);
		
		sock.send(request);
		System.out.println("JOUER envoyé");
		sock.receive(response);
		StringBuilder sb = new StringBuilder(new String(reponse,0,reponse.length));
		
		System.out.println("Message reçu: "+ new String(reponse,0,reponse.length));
		
		reponse = decode(sb);
		request = new DatagramPacket(reponse,reponse.length,servAddr,PORT);
		response = new DatagramPacket(reponse,reponse.length,servAddr,PORT);
		
		sock.send(request);
		System.out.println("Reponse envoyé");
		sock.receive(response);
		
	//	String message = new String(reponse,0,reponse.length);
		String message = new String(reponse,StandardCharsets.UTF_8);
		System.out.println("Message reçu " + message);
		
		sock.close();
		
		
		
		
	}
	
	public byte[] decode(StringBuilder sb) {
		
		String reponse = "R";
		byte[] buffer = new byte[BUFFER_SIZE];
		int position, position2, position3;
		int nombre1;
		int nombre2;
		sb.deleteCharAt(0); //Delete Q
		position = sb.indexOf(":");
	
		if( position != 0) {
			String numberQ = sb.substring(0, position);
			System.out.println("The number of Q is: " + numberQ);
			
			reponse = reponse.concat(numberQ);
			reponse = reponse.concat(":");
			
			String question = sb.substring(position+1);
			position2 = sb.indexOf("+");
			position3 = sb.indexOf("=");
			System.out.println(sb.substring(position+1,position2));
			nombre1 = Integer.parseInt(sb.substring(position+1,position2));
			nombre2 = Integer.parseInt(sb.substring(position2+1, position3));
			System.out.println("nb1 " + nombre1 + " nb2 " + nombre2);
			nombre2 = nombre2 + nombre1;
			question = String.valueOf(nombre2);
			reponse = reponse.concat(question);
			buffer = reponse.getBytes();
			
		}
		else {
			System.out.println("Erreur position");
			System.exit(1);
		}
		return buffer;
	}
}
