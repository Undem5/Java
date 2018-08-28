
public class implementRunnable3 {
	private Thread t;
	private int count;
	private String mesg;
	
	
	public static void main(String[] args) {
		new implementRunnable3("Hello from X",10);
		new implementRunnable3("Hello from Y",15);
	}
	
	public implementRunnable3(String m, int n) {
		mesg = m;
		count = n;
		t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while( count-- > 0) {
					System.out.println(mesg);
					try {
						Thread.sleep(100);
					
				}catch(InterruptedException e) {
					return;
					}
				}
			System.out.println("All done");
			}
		
				
		});
		t.setName(mesg + " runner Thread");
		t.start();
	}
}