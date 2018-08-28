

public class implementRunnable2 implements Runnable{

	// If the class extends already another class
	private String mesg;
	private int count;
	private Thread t;
	
	
	public static void mai(String[] args) {
		new implementRunnable2("Hello from X",10);
		new implementRunnable2("Hello from Y",15);
	}
	
	public implementRunnable2(String m, int n) {
		mesg = m;
		count = n;
		t = new Thread(t);
		t.setName(m + " runner Thread");
		t.start();
	}
	
	public void run() {
		while( count-->0) {
			System.out.println(mesg);
			try {
				Thread.sleep(100);
			}catch(InterruptedException e) {
				return;
			}
		}
		System.out.println("All done");
	}
	
	
}
