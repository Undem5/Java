import java.util.ArrayList;

public class PhiloSimple extends Thread {

	
	private static final int N = 5;
	
	public static void main(String[] args) throws InterruptedException {
		

		
		for( int i = 0; i<N;i++) {
			String nomPhilo = String.valueOf(i);
			String nom = nomPhilo.concat("sophe");
			PhiloSimple nomPhilo1 = new PhiloSimple(nom);
			nomPhilo1.start();
			
		}
		
	}
	
	public PhiloSimple(String num) {
		super(num);
	}
	
	public void run() {
		
		while(true) {
			try {
				mange();
				Thread.sleep((int)(Math.random()*10000));
				discute();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public synchronized void mange() throws InterruptedException {

		System.out.println( Thread.currentThread().getName() + " s'est mis à table");
	
	}
	
	public synchronized void discute() throws InterruptedException {
	
		System.out.println(Thread.currentThread().getName() + " s'est mis à discuter");
		
		
	}
}
