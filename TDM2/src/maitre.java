import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class maitre {

	public final static int PORT=3000;
	protected static int i=0;
	
	public static void main(String []argv) throws IOException, InterruptedException{
		
		while(true && i<4) {
			InetAddress servAddr = InetAddress.getLoopbackAddress();
			DatagramSocket sock = new DatagramSocket();
			
			byte[] buffer = "frame".getBytes();
			
			
			DatagramPacket packet = new DatagramPacket(buffer,buffer.length,servAddr,PORT+i);
			packet.setLength(buffer.length);
			sock.send(packet);
			System.out.println("paquet envoyé");
			Thread.sleep(1000);
			i = i+1;
		}
		
				
	}
}
