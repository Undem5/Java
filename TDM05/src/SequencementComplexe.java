
public class SequencementComplexe extends Thread{

	public int debut;
	public int fin;
	
	
	public static void main(String[] args) throws InterruptedException {
		
		SequencementSimple t1 = new SequencementSimple("1",5000,10000);
		SequencementSimple t2 = new SequencementSimple("2",1,5000);
		SequencementSimple t3 = new SequencementSimple("3",6000,100000);
		SequencementSimple t4 = new SequencementSimple("4",5,10);
		SequencementSimple t5 = new SequencementSimple("5",800000,10000000);
		SequencementSimple t6 = new SequencementSimple("6",156561556,584544445);
		SequencementSimple t7 = new SequencementSimple("6",464,491948);
		
		t1.start();
		
		while( !t7.isInterrupted()) {
			
			if( t1.isInterrupted()) {
				System.out.println(t1.getName() + " is ded");
				t2.start();
				t3.start();
				t4.start();
			
			}
			
			if( t2.isInterrupted() && t3.isInterrupted()) {
				System.out.println(t2.getName() + " et " + t3.getName() + " is ded ");
				t5.start();
			}
			
			if( t4.isInterrupted()) {
				System.out.println(t4.getName() + " is ded");
				t6.start();
				
			}
			if( t6.isInterrupted() && t5.isInterrupted()) {
				System.out.println(t4.getName() + " et " + t5.getName() + " is ded ");
				t7.start();

			}
			
			
		}
		if( t7.isInterrupted()) {
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
			Thread.currentThread().interrupt();
			
		}
		
		
	}

}
