import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UPDServ {

	
	public final static int PORT = 3000;
	protected final static int PACKET_SIZE =100;
	
	public static void main(String [] args) throws IOException {
		
		InetAddress servAddr = InetAddress.getLoopbackAddress();
		DatagramSocket sock = new DatagramSocket(PORT,servAddr);
		System.out.println("Serveur Lancé");
		while(true) {
			byte[] buffer = new byte[PACKET_SIZE];

			DatagramPacket request = new DatagramPacket(buffer,buffer.length);
			
			
			sock.receive(request);
			System.out.println("Paquet reçu de " + servAddr.getHostName() + " port: " + sock.getLocalPort() + 
					" de contenu " + new String(buffer,0,request.getLength()));

		}
		
	}
}
