
public class Calculatrice extends Thread{
	
	private Somme somme;
	
	public Calculatrice(Somme somme) {
		
		this.somme = somme;
	}
	
	public void run() {
		
		int res = 0;
		for( int i=0; i<100; i ++) {
			res = somme.Somme(res,i);
		}
		System.out.println("La somme de 1 et 99 est :" + res);
	}
	
	public static void main(String[] args) {
		Somme somme = new Somme();
		Calculatrice c1 = new Calculatrice(somme);
		Calculatrice c2 = new Calculatrice(somme);

		c1.start();
		c2.start();
		
		
	}
	
	static class Somme{
		
		int c;
		public int Somme(int a, int b) {
			c = a+b;
			
			//Le System println ralentit le flow d'éxecution du programme.
			System.out.println("c="+c);
			
			return c;	
		}
		
	}

}


