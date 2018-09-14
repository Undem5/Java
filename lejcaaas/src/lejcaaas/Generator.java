package lejcaaas;

import java.util.ArrayList;

/*
 * public String characGenerator(String array): type, variable, affect, word en paramètre
 * varLineBeautify(String variable, String type) : Renvoit la ligne correspond aux variables
 * String varBeautify(int nb): nb de ligne qui dois apparaitre dans la partie variable et renvoit tout le texte.
 * int indiceGenerator(String array): genere un nombre aléatoire suivant le type de données.
 */


public class Generator {

	private final String affec = ":=";
	private final String eol = " ;";
	private final String tab = "\t";
	private String program = "program\n";
	private String start = "begin \n";
	private String interm = "\tnew_line ;\n";
	private String end = "end.";
	
	public static void main(String[] args) {
		Generator lejcas = new Generator();
		lejcas.Generate();
		
	}
	
	public void Generate() {
		String progfinal = program;
		//progfinal = progfinal.concat(varLineBeautify("variable","type"));
		//progfinal = progfinal.concat(varLineBeautify("variable","type"));
		
		progfinal = progfinal.concat(varBeautify(indiceGenerator("variable")));
		System.out.println(progfinal);
		
	}
	
	public ArrayList<String> wordGenerator(){
		ArrayList<String> mot_cle = new ArrayList<String>();
		mot_cle.add("write");
		mot_cle.add("read");
		mot_cle.add("while");
		mot_cle.add("end ;");
		mot_cle.add("array [1 .. 20] of");
		mot_cle.add("while");
		mot_cle.add("if");
		mot_cle.add("else");
		return mot_cle;
	}
	
	public ArrayList<String> typeGenerator(){
		ArrayList<String> mot_cle = new ArrayList<String>();
		mot_cle.add("integer");
		mot_cle.add("boolean");
		mot_cle.add("1 .. 20");

		
		return mot_cle;
	}
	
	public ArrayList<String> affectGenerator(){
		ArrayList<String> mot_cle = new ArrayList<String>();
		mot_cle.add("+");
		mot_cle.add("-");
		mot_cle.add("*");
		mot_cle.add("/");
		
		
		return mot_cle;
	}
	
	public ArrayList<String> variableGenerator(){
		ArrayList<String> mot_cle = new ArrayList<String>();
		mot_cle.add("a");
		mot_cle.add("b");
		mot_cle.add("c");
		mot_cle.add("e");
		mot_cle.add("f");
		mot_cle.add("g");
		mot_cle.add("h");
		mot_cle.add("i");
		mot_cle.add("j");
		return mot_cle;
	}
	
	public int indiceGenerator(String array) {
		// A ne pas utiliser
		int ret;
		int max = 0;
		int min = 0;
		
		switch(array) {
			case "type":
				max = 3;  // WTF
				break;
			case "affect":
				max = 3;
				break;
			case "word":
				max = 7;
				break;
			case "variable":
				max = 9;
				break;
			default:
				System.out.println("array doit être type, affect ou word. Ici: " + array);
				System.exit(-1);
			
				
		}
		
		return ((int)(Math.random()*(max-min)) + min);
	}
	
	public String characGenerator(String array) {
		
		ArrayList<String> result = new ArrayList<String>();
		int indice = 0;
		
		switch(array){
			case "type":
				result = typeGenerator();
				break;
			case "variable":
				result = variableGenerator();
				break;
			case "word":
				result = wordGenerator();
				break;
			case "affect":
				result = affectGenerator();
				break;
			default:
				System.out.println("type, variable, word, affect seulement");
				break;
		}
		indice = indiceGenerator(array);
		
		return result.get(indice);
	}
	
	public String varLineBeautify(String variable, String type) {
		String line = tab.concat(characGenerator(variable)).concat(" : ").concat(characGenerator(type)).concat(eol).concat("\n");
			
		return line;
	}
	
	public String varBeautify(int nb) {
		String texte = "";
		if (nb < 9 ) {
			for(int i = 0; i< nb; i++) {
				texte = texte.concat(varLineBeautify("variable","type"));
			}
		}
		else {
			System.err.println("Nombre trop grand varBeautify");
			System.exit(-1);
		}
		texte = texte.concat("\n").concat(start);
		return texte;
	}
}
