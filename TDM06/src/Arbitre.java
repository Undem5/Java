import java.util.ArrayList;

public class Arbitre extends Thread {

	
	public static ArrayList<Boolean> auto = new ArrayList<Boolean>();
	
	
	
	
	public static void main(String[] args) {
		// On suppose donc qu'on à  N philosophes
		// On suppose true indique baguettes dispo sinon false;
		
		System.out.println("Un arbitre sauvage apparait");
		
		
	}
	
	public Arbitre(int N) {
		for( int i=0; i<N+1; i++) {
						
			auto.add(true);
		}
		System.out.println(auto.size());
	}
	
	public boolean autorisation(int numPhilo) {
		boolean res;
		
		if( auto.get(numPhilo) ==  true) {
		
			// Cas extreme num 0 avec num 5 et num 1
			if( numPhilo == 0 && auto.get(numPhilo+1) == true && auto.get(auto.size()-1) == true) {
				res = true;
				auto.set(numPhilo, false);
				System.out.println("L'arbitre autorise les baguettes");
			}
			else if( numPhilo == auto.size()-1 && auto.get(numPhilo-1) == true && auto.get(0) == true) {
				res = true;
				auto.set(numPhilo, false);

				System.out.println("L'arbitre autorise les baguettes");
			}
			else if( auto.get(numPhilo) == true && auto.get(numPhilo-1) == true && auto.get(numPhilo+1) == true) {
				res = true;
				auto.set(numPhilo, false);

				System.out.println("L'arbitre autorise les baguettes");

			}
			else {
				res = false;
				System.out.println("L'arbitre n'autorise pas les baguettes pour" + Thread.currentThread().getName());
			}
			
		}
		else {
			System.out.println("L'arbitre n'autorise pas les baguettes" + Thread.currentThread().getName());
			res = false;
		}
		return res;
	}
	
	public void liberation(int numPhilo) {
		System.out.println(Thread.currentThread().getName() + " libère les baguettes");
		auto.set(numPhilo, true);
		
	}
}
