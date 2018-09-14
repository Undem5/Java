package lejcaaas;

import java.util.ArrayList;

/*
 * public String characGenerator(String array): type, variable, affect, word en paramètre.
 * 
 * varLineBeautify(String variable, String type) : Renvoit la ligne correspond aux variables.
 * 
 * String varBeautify(int nb): nb de ligne qui dois apparaitre dans la partie variable et renvoit tout le texte.
 * 
 * int indiceGenerator(String array): genere un nombre aléatoire suivant le type de données.
 * 
 * String commentGenerator() renvoit un commentaire ou saut de ligne.
 */


public class Generator {

	private final String affec = ":=";
	private final String eol = " ;";
	private final String tab = "\t";
	private String program = "program\n";
	private String start = "begin \n";
	private String interm = "\tnew_line ;\n";
	private String end = "end.";
	private ArrayList<String> varUsed = new ArrayList<String>();
	private ArrayList<String> typeVar = new ArrayList<String>();
	
	public static void main(String[] args) {
		Generator lejcas = new Generator();
		lejcas.Generate();
		
	}
	
	public void Generate() {
		String progfinal = program;
		
		progfinal = progfinal.concat(varBeautify(indiceGenerator("variable")));
		progfinal = progfinal.concat(bodyGenerator());
		System.out.println(progfinal);
		
	}
	
	public ArrayList<String> wordGenerator(){
		ArrayList<String> mot_cle = new ArrayList<String>();
		mot_cle.add("write");
		mot_cle.add("read");
		mot_cle.add("while");
		mot_cle.add("if");
		//mot_cle.add("else");
		return mot_cle;
	}
	
	public ArrayList<String> typeGenerator(){
		ArrayList<String> mot_cle = new ArrayList<String>();
		mot_cle.add("integer");
		mot_cle.add("boolean");
		mot_cle.add("1 .. 20");
		// array en attente
		
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
				max = 3;
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
		String var = characGenerator(variable);
		String ty = characGenerator(type);
		varUsed.add(var);
		typeVar.add(ty);
		String line = tab.concat(var).concat(" : ").concat(ty).concat(eol).concat("\n");
			
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
	
	public String bodyVarBeautify(String variable, String type) {
		// Affection d'une variable dans le body
		String text;
		if( type.equals("True") || type.equals("False")) {
			text=  tab.concat(variable).concat(" := ").concat(type).concat(eol).concat("\n");
		}
		else {
			text = tab.concat(variable).concat(" := ").concat(String.valueOf((Math.random()*150))).concat(eol).concat("\n");
		}
/*		System.out.println("---------------");
		System.out.println(text);
		System.out.println("---------------");
*/
		return text;
		
	}
	
	public String commentGenerator() {
		String text;
		int i = (int)(Math.random()*2);
	
		if( i >= 1) {
			text = "\t\t".concat("\n-- Hello I am a comment\n");
		}
		else {
			text = "\n";
		}
		
		return text;
		
	}
	
	public String bodyGenerator() {
		String rep = commentGenerator();
		rep = rep.concat(motSemantique(characGenerator("word")));
		
		return rep;
	}
	
	public String motSemantique(String mot) {
		
		String text = null;
		int i;
		int i1, i2;
		String var1=null, var2=null;
		mot = mot.trim();
		
	
		if( mot == "write") {
			text = tab.concat(mot).concat("(\"Hello I am an input\")");
			text = text.concat(eol).concat("\n");
		}
		else if( mot == "read" ) {
			i = typeVar.indexOf("integer");
			if( i == -1) {
				i = typeVar.indexOf("boolean");
				if( i == -1) {
					i=0;
				}
			}
			String var = varUsed.get(i);
			text = tab.concat(mot).concat(("(" + var + ")")).concat("\n");
		}
		
		else if( mot == "while") {
			i = typeVar.indexOf("boolean");
			text = "(";
			// Generation de la condition
			if( i == -1) {
				i = 1;
				for(int j=0; j<typeVar.size(); j++) {
					if ( typeVar.get(j).equals("integer") && i<2) {
						i = 2;
						text = text.concat(varUsed.get(j));
						if( i == 2) {
							var2 = varUsed.get(j);
							break; //Permet de réaliser une fois le var <= var2
						}
						System.out.println("var1 " + var1 + " j :" + j +" typeVar.size()");
						var1 = varUsed.get(j);
						text = text.concat(" <= ");
					}
				}
			}
			else { // cas boolean (var)
				var1 = varUsed.get(i);
				text = tab.concat(mot).concat("(").concat(var1).concat(")").concat("\n");
				
			}
			//Génération du body
			System.out.println("var2 est: " + var2);
			if( var2 == null) {
				// boolean
				text = text.concat(bodyVarBeautify(var1,"False"));
			}
			else {
				
				text = text.concat(bodyVarBeautify(var1,null));
			}
			text = text.concat(tab).concat("end ;").concat("\n");
			
		}
		else if( mot == "if") {
			i = typeVar.indexOf("boolean");
			text = "(";
			// Generation de la condition
			if( i == -1) {
				i = 1;
				for(int j=0; j<typeVar.size(); j++) {
					if ( typeVar.get(j).equals("integer") && i<2) {
						i = 2;
						text = text.concat(varUsed.get(j));
						if( i == 2) {
							var2 = varUsed.get(j);
							break; //Permet de réaliser une fois le var <= var2
						}
						var1 = varUsed.get(j);
						text = text.concat(" <= ");
					}
				}
			}
			else { // cas boolean (var)
				var1 = varUsed.get(i);
				text = text.concat(var1).concat(")").concat("\n");
				
			}
			//Génération du body
			System.out.println("var2 est: " + var2);
			if( var2 == null) {
				// boolean
				text = text.concat(bodyVarBeautify(var1,"False"));
			}
			else {
				text = text.concat(bodyVarBeautify(var1,null));
			}
			text = text.concat(tab).concat("end ;").concat("\n");
			
		}
		text = text.concat(end);
		return text;
	}
}
