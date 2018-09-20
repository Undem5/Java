
public class SequencementComplexe extends Thread{

	public int debut;
	public int fin;
	
	
	public static void main(String[] args) throws InterruptedException {
		
		SequencementSimple t1 = new SequencementSimple("1",5,100);
		SequencementSimple t2 = new SequencementSimple("2",1,50);
		SequencementSimple t3 = new SequencementSimple("3",60,100);
		SequencementSimple t4 = new SequencementSimple("4",5,10);
		SequencementSimple t5 = new SequencementSimple("5",800,1000);
		SequencementSimple t6 = new SequencementSimple("6",1565,5845);
		SequencementSimple t7 = new SequencementSimple("7",46,448);
		
		t1.start();
		
		while( !t7.getState().toString().equals("TERMINATED")) {
			
			if( !t1.isAlive()) {
				System.out.println(t1.getName() + " is ded");
				t2.start();
				t3.start();
				t4.start();
				
				t2.join();
				t3.join();
				t4.join();
				
			
			}
			
			if( !t2.isAlive() && !t3.isAlive()) {
				System.out.println(t2.getName() + " et " + t3.getName() + " is ded ");
				t5.start();
				
				t5.join();
			}
			
			if( !t4.isAlive()) {
				System.out.println(t4.getName() + " is ded");
				t6.start();
				
				t6.join();
				
			}
			if( !t6.isAlive() && !t5.isAlive()) {
				System.out.println(t6.getName() + " et " + t5.getName() + " is ded ");
				t7.start();
				
				t7.join();

			}
			
			
		}
		if( !t7.isAlive()) {
			System.out.println(t7.getName() + " is ded");

		}		
		
	}
	
	
	public SequencementComplexe(String name, int dbt, int f) {
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
