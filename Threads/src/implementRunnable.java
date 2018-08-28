import java.io.IOException;

public class implementRunnable  extends Thread{
	
	private String mesg;
	private int count;
	
	public void run() {
		while( count-- >0) {
			System.out.println(mesg);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("All done");
	}
	
	public implementRunnable(int n, final String mesg) {
		this.mesg = mesg;
		count = n;
		setName(mesg + " runner Thread");
	}
	
	public static void main(String[] args) {
		new implementRunnable(10,"Hello from X").start();
		new implementRunnable(15,"Hello from Y").start();
	}
	
}
