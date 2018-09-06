import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Maitre {
	
	public final static int PORT = 3000;
	
	public static void main(String[] args) throws IOException, InterruptedException  {
		
		Maitre client1 = new Maitre();
		client1.runClient();
			
	}
	
	
	public void runClient() throws IOException, InterruptedException {
		
		InetAddress servAddr = InetAddress.getLoopbackAddress();
		DatagramSocket sock = new DatagramSocket();
		int i = 1;
		while( i < 5) {
			byte[] message = "hello".getBytes();
			DatagramPacket paquet = new DatagramPacket(message,message.length, servAddr, PORT+i);
			paquet.setLength(message.length);
			sock.send(paquet);
			System.out.println("Paquet envoyé");
			
			i = i+1;
			Thread.sleep(1000);
		}
		
		sock.close();
	}
}
