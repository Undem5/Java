import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
	
	public final static int PORT=3000;
	
	public static void main(String []argv) throws IOException{
		/*if( argv.length <1) {
			System.err.println("usage: java tdm1 host");
			System.exit(1);
		}*/
		
		//String host = argv[0];
		InetAddress servAddr = InetAddress.getLoopbackAddress();
		DatagramSocket sock = new DatagramSocket();
		
		byte[] buffer = "fefzfnjour".getBytes();
		
		
		DatagramPacket packet = new DatagramPacket(buffer,buffer.length,servAddr,PORT);
		packet.setLength(buffer.length);
		sock.send(packet);
		System.out.println("paquet envoyé");
				
		sock.close();
	}

}
