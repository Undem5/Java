
public class Pimultithread extends Thread {

	private double resultat = 0;
	private int dbt;
	private int fin;
	
	// On synchronize seulement en dernier recours sinon RAM (exemple binome 1 feuille 1 stylo)
	// Pour faire un double : 1.2d, pour écrire un long 10000l et un float 1.3f
	
	public static void main(String[] args) throws InterruptedException {
		
		/*Pi calc1 = new Pi(0, 100000);
		Pi calc2 = new Pi(100001,200000);
		Pi calc3 = new Pi(200001,300000);
		Pi calc4 = new Pi(300001,400000);
		Pi calc5 = new Pi(400001,500000);
		
		calc1.start();
		calc2.start();
		calc3.start();
		calc4.start();
		calc5.start();
		
		calc1.join();
		calc2.join();
		calc3.join();
		calc4.join();
		calc5.join();
		*/
		
		double resultatFinal = 0;
		int i = 0;
		int j = 1;
		Pimultithread pi1 = new Pimultithread(0,500000);
		
		while(j<= 32) { // 32 threads de 15625
			
				Pimultithread calc = new Pimultithread(i,i+15625);
		//		System.out.println("Calcule de " + i + " a "+ (i+15625));
				calc.start();
				calc.join();
				resultatFinal = resultatFinal + calc.resultat;
				i = i+ 15626;
				j = j+1;
		}
				
				
		System.out.println("Le res est :" + resultatFinal*4 ); // Me calcul renvoit pi/4
		
	}
	
	public Pimultithread(int debut, int f) {
		dbt = debut;
		fin = f;
		
	}
	
	public void run() {
		calcul(dbt, fin);
	}
	
	public void calcul(int dbt,int fin) {
		
			for( int i=dbt; i<fin; i++) {
				resultat = resultat + Math.pow(-1, i)/(2*i+1);
			}
		
	}
}
