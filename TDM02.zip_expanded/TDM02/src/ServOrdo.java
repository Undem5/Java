import java.awt.Color;
import java.awt.List;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

import javax.swing.JFrame;

public class ServOrdo {

	public final static int PORT = 3000	;
	protected final static int BUFFER_SIZE = 1000;
	private boolean done = false;
	private static byte[] buffer;
	
	public static void main(String[] args) throws IOException, InterruptedException{
		
		ServOrdo serveur = new ServOrdo();
		serveur.run();
		
	}
	
	public void run() throws IOException, InterruptedException {
		InetAddress serverAddr = InetAddress.getLoopbackAddress();
		DatagramSocket sock = new DatagramSocket(PORT,serverAddr);
		ArrayList<Integer> ports = new ArrayList<Integer>();
		int i=0;
		
		while(!done) {
			System.out.println("Entrée");
			buffer = new byte[BUFFER_SIZE];
			DatagramPacket request = new DatagramPacket(buffer,buffer.length);
			sock.receive(request);
			
			String recu = new String(buffer,0,buffer.length);
			System.out.println("Message reçu " + recu);
			ports.add(request.getPort());
			System.out.println("Size of ports " + ports.size());
			if( recu.contains("dernier")) {
				done = true;
				System.out.println("Dernier client reçu");
			}
		}
		
		while( !ports.isEmpty()) {
			buffer = "red".getBytes();
			int port =  ports.get(0);
			System.out.println("port " + port);
			DatagramPacket response = new DatagramPacket(buffer,buffer.length,serverAddr,port);
			sock.send(response);
			System.out.println("RED envoyé");
			Thread.sleep(1000);
			
			buffer = "green".getBytes();
			response = new DatagramPacket(buffer,buffer.length,serverAddr,port);
			sock.send(response);
			System.out.println("GREN envoyé");
			ports.remove(0);
			i = i+1;
					
			
			
		}
		
		
	}
	
	public static void changeColor(JFrame frame) throws InterruptedException {
		frame.getContentPane().setBackground(Color.RED);
		Thread.sleep(1000);
		frame.getContentPane().setBackground(Color.green);
	}
	
	public byte[] toGreen() {
		return "green".getBytes();
	}
	
	public byte[] toRed() {
		return "red".getBytes();
	}
	
	
}
