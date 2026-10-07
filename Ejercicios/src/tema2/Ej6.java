package tema2;

public class Ej6 {
	
	public static boolean esPalindromo (String texto) {
		
		if(texto.length()==0|texto.length()==1) {
			return true;
		}
		
		if(texto.charAt(0)==texto.charAt(texto.length()-1)) {
			String subTexto = texto.substring(1,texto.length()-1);
			if(esPalindromo(subTexto)) {
				return true;
			}
		}
		
		return false;
		
	}
	public static void main(String[] args) {
		
		System.out.println(esPalindromo("guauuuesufsef"));

	}

}
