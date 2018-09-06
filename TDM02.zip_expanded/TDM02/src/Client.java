import java.awt.Color;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JFrame;

public class Client {
	
	public static int PORT = 3000;
	private JFrame frame;
	private static String text;
	private static byte[] message;
	
	public static void main(String[] argv) throws IOException, InterruptedException  {
		
		
		 if (argv.length > 0) {
			 text = argv[0];
			 if(!text.equals("dernier")) {
				 System.out.println("Usage java Client dernier");
				 System.exit(-1);
			 }
		 }else {
			 text = "";
		 }
		Client client1 = new Client();
		
		client1.runClient(text);
			
	}
	
	
	public void runClient(String text) throws IOException, InterruptedException {
		
		InetAddress servAddr = InetAddress.getLoopbackAddress();
		DatagramSocket sock = new DatagramSocket();
		
		
		if( !text.equals("")) {
			message = "dernier".getBytes();
		}
		else {
			message = "hello".getBytes();
		}
		//PORT = (int)(Math.random()*(3000-1024)) + 1024;
		DatagramPacket paquet = new DatagramPacket(message,message.length, servAddr, PORT);
		paquet.setLength(message.length);
		sock.send(paquet);
		System.out.println("Paquet envoyé " + sock.getLocalPort());
		Thread.sleep(1000);
		sock.receive(paquet);
		String ordre = new String(message,0,message.length);
		
		if( ordre.contains("red")) {
			frame.getContentPane().setBackground(Color.RED);
			System.out.println("Ordre Red reçu");
			Thread.sleep(1000);
			sock.receive(paquet);
			ordre = new String(message,0,message.length);
			
			if( ordre.contains("green")) {
				frame.getContentPane().setBackground(Color.GREEN);
				System.out.println("Ordre Green reçu");
			}
		}
		else {
			frame.getContentPane().setBackground(Color.GREEN);
			System.out.println("Ordre Green reçu");

		}
		
		
	}
	
	public Client() {
		frame = new JFrame("chenillard");
		frame.setSize(300, 300);
		frame.getContentPane().setBackground(Color.green);
		frame.setVisible(true);
	}
}
