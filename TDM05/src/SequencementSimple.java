
public class SequencementSimple extends Thread{
	
	public int debut;
	public int fin;
	
	
	public static void main(String[] args) throws InterruptedException {
		
		SequencementSimple t1 = new SequencementSimple("1",50,100);
		SequencementSimple t2 = new SequencementSimple("2",1,500);
		SequencementSimple t3 = new SequencementSimple("3",60,1000);
		SequencementSimple t4 = new SequencementSimple("4",5,10);
		SequencementSimple t5 = new SequencementSimple("5",80,1000);
		SequencementSimple t6 = new SequencementSimple("6",16,585);
		int i = 0;
		t1.start();
		t1.join();
		while( !t6.getState().toString().equals("TERMINATED")) {
			
			if( !t1.isAlive() && i == 0) {
				System.out.println(t1.getName() + " is ded");
				t2.start();
				t3.start();
				t4.start();
				
				t2.join();
				t3.join();
				t4.join();
			
			}
			
			if( !t2.isAlive() && !t3.isAlive() && i == 0) {
				System.out.println(t2.getName() + " et " + t3.getName() + " is ded ");
				t5.start();
				 
				t5.join();
			}
			
			if( !t4.isAlive() && !t5.isAlive() && i == 0) {
				t6.start();
				
				t6.join();
				i = 1;
				System.out.println("test + "+  t6.getState() + t6.isAlive());

			}
			
			
		}
		
		if( !t6.isAlive()) {
			System.out.println(t6.getName() + " is ded");

		}
		
	}
	
	
	public SequencementSimple(String name, int dbt, int f) {
		super(name);
		debut = dbt;
		fin = f;
	}
	
	
	public void run() {
		
		System.out.println("Coucou je suis la tâche numéro : " + Thread.currentThread().getName());
		int i = (int)(Math.random()*(fin-debut) + debut);
	
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			System.out.println("La tâche " + Thread.currentThread().getName() + " vient de se réveiller");
			
			
		}
		
		
	}

}
