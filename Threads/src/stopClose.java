import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class stopClose extends Thread {

	//When reading from a network connection, Thread is asleep so need to close sock to end it
	
	protected Socket io;
	
	public void run() {
		try {
			io = new Socket("java.sun.com",80);
			BufferedReader is = new BufferedReader(new InputStreamReader(io.getInputStream()));
			System.out.println("StopClose reading");
			String line = is.readLine(); //deadlock
			System.out.printf("Stopclose finished after reading %s",line);
		}catch(IOException e) {
			System.out.println("StopClose terminating " +e);
		}
	}
	
	public void shutdown() throws IOException {
		if( io != null) {
			synchronized(io) {
				io.close();
			}
		}
		System.out.println("io shutdown completed");
	}
	
	public static void main(String[] args) throws InterruptedException,IOException {
		stopClose t = new stopClose();
		t.start();
		Thread.sleep(1000*5);
		t.shutdown();
		
	}
}

