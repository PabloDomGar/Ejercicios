package tema2;

public class Ej9 {

	public static int contarFormasCambio (int objetivo, int[] monedas) {
		
		int formas=0;
		
		// caso base 1
		if(objetivo==0) {
			return ++formas;
		}
		
		// caso base 2
		if(objetivo<0) {
			return formas;
		}
		
		// caso base 3
		if(monedas[0]==0 && monedas[1]==0 && monedas[2]==0) {
			return formas;
		}
		
		// paso recursivo 
		for(int i = 0; i<monedas.length;i++) {
			
			if(monedas[i]<1) continue; //Si no quedan monedas de un tipo, pasa al siguiente tipo
			
			int monedasRestadas = 0;
			if (i==0) {
				monedasRestadas = 1;
			} else if (i==1) {
				monedasRestadas = 2;
			} else {
				monedasRestadas = 5;
			}
			
			for(int j = 0; j<monedas[i];j++) {
				monedas[i]--; 
				formas += contarFormasCambio(objetivo-monedasRestadas, monedas);
				monedas[i]++;
				objetivo++;
				
			}
		}
		
		return formas;
	
	}
	
	
	
	public static void main(String[] args) {
		
		int [] monedas = {2,2,0};
		int objetivo = 2;
		System.out.println("Monedas iniciales: 1€(" + monedas[0] + ") 2€(" + monedas[1] + ") 5€(" + monedas[2]+")");
		
		int formas = contarFormasCambio(objetivo, monedas);
		System.out.println("Para un cambio de " + objetivo + "€ existen " + formas + " formas");
	}

}
