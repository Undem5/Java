import java.awt.Color;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JFrame;

public class Esclave3 {

	public final static int PORT = 3003;
	protected final static int BUFFER_SIZE = 1000;
	private JFrame frame;
	
	public static void main(String[] args) throws IOException, InterruptedException{
		
		Esclave3 esclave = new Esclave3();
		esclave.run();
		
	}
	
	public void run() throws IOException, InterruptedException {
		InetAddress serverAddr = InetAddress.getLoopbackAddress();
		DatagramSocket sock = new DatagramSocket(PORT,serverAddr);
		
		while(true) {
			
			byte[] buffer = new byte[BUFFER_SIZE];
			DatagramPacket request = new DatagramPacket(buffer,buffer.length);
			sock.receive(request);
			
			String recu = new String(buffer,0,buffer.length);
			System.out.println("Message reçu " + recu);
			changeColor(this.frame);
		}
	}
	
	public static void changeColor(JFrame frame) throws InterruptedException {
		frame.getContentPane().setBackground(Color.RED);
		Thread.sleep(1000);
		frame.getContentPane().setBackground(Color.green);
	}
	
	public Esclave3() {
		frame = new JFrame("chenillard");
		frame.setSize(300, 300);
		frame.getContentPane().setBackground(Color.green);
		frame.setVisible(true);
	}
}
