
public class PhiloComplexe extends Thread {

	
	
	private static final int N = 5;
	public static Arbitre ronaldo;
	public boolean dispo = true;
	
	
	public static void main(String[] args) throws InterruptedException {
		

		ronaldo = new Arbitre(N);
		
		for( int i = 0; i<N; i++) {
			String nomPhilo = String.valueOf(i);
			PhiloComplexe nom1 = new PhiloComplexe(nomPhilo);
			nom1.start();
			
		}
		
	}
	
	public PhiloComplexe(String num) {
		super(num);
	}
	
	
	public void run() {
		
		while(true) {
			try {
				if( dispo == true) {
					discute();
				}
				
				Thread.sleep((int)(Math.random()*10000));
				
				if( ronaldo.autorisation(Integer.valueOf(Thread.currentThread().getName()))) {
					mange();
					Thread.sleep((int)(Math.random()*10000));
					ronaldo.liberation(Integer.valueOf(Thread.currentThread().getName()));
				}
				else {
					Thread.sleep(1000);
					dispo = false;
				}
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void mange() throws InterruptedException {

		System.out.println( Thread.currentThread().getName() + " s'est mis à table");
	
	}
	
	public void discute() throws InterruptedException {
	
		System.out.println(Thread.currentThread().getName() + " s'est mis à discuter");
		
		
	}
}
