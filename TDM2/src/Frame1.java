import java.awt.Color;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import javax.swing.JFrame;

public class Frame1 {

	
	JFrame frame;
	public final static int PORT=3000;
	protected final static int PACKET_SIZE=100;
	InetAddress servAddr;
	DatagramSocket sock;
	
	
	public Frame1() throws InterruptedException, IOException {
		frame = new JFrame();
		frame.setSize(300, 300);
		frame.getContentPane().setBackground(Color.GREEN);
		frame.setVisible(true);
		InetAddress servAddr = InetAddress.getLoopbackAddress();
		DatagramSocket sock = new DatagramSocket(PORT,servAddr);
		System.out.println("Serveur Lancé");
		while(true) {
			byte[] buffer = new byte[PACKET_SIZE];

			DatagramPacket request = new DatagramPacket(buffer,buffer.length);
			
			
			sock.receive(request);
			System.out.println("Paquet reçu de " + servAddr.getHostName() + " port: " + sock.getLocalPort() + 
					" de contenu " + new String(buffer,0,request.getLength()));
			frame.getContentPane().setBackground(Color.RED);
			Thread.sleep(1000);
			frame.getContentPane().setBackground(Color.GREEN);
			
			

		}
	
	}
	
	public static void main(String[] args) throws InterruptedException,IOException {
		Frame1 frame1 = new Frame1();
	}

}
