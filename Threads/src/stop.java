
public class stop extends Thread {
	
	protected volatile boolean done = false;
	
	public void run() {
		while(!done) {
			System.out.println("Thread running");
			try {
				sleep(732);
			}catch(InterruptedException e) {
				return;
			}
		}
		System.out.println("Thread stopped");
	}
	
	public void shutdown() {
		done = true;
	}
	
	public static void main(String[] args) throws InterruptedException{
		stop t1 = new stop();
		t1.start();
		Thread.sleep(1000);
		t1.shutdown();
	}

}
