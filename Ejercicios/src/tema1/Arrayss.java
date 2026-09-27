package tema1;
import java.util.Random;
import java.util.Arrays;

public class Arrayss {

	public static float[] creaMatrizUni(int filas) {
		Random rd = new Random();
		float [] matriz = new float [filas];
		for (int i = 0; i<filas;i++) {
			matriz [i] = rd.nextFloat(0, 10);
		}
		return matriz;
}
	
	public static float[][] creaMatrizBid(int filas, int columnas) {
			Random rd = new Random();
			float [][] matriz = new float [filas][columnas];
			for (int i = 0; i<filas;i++) {
				for (int j = 0; j<columnas;j++) {
					matriz [i][j] = rd.nextFloat(0, 10);
				}
			}
			return matriz;
	}
	
	public static float[] buscaMayoresFila(float [][] matriz) {
		float[] mayores = new float[matriz.length];
		for (int i = 0; i<matriz.length;i++) {
			float mayor = 0;
			for (int j = 0; j<matriz[i].length;j++) {
				if (matriz[i][j]>mayor) {
					mayor = matriz[i][j];
				}
			}
			mayores[i] = mayor;
		}
		return mayores;
}
	
	public static float[] invierteMatriz1(float [] matriz) {
		float[] invert = new float[matriz.length];
		for (int i = matriz.length; i>0;i--) {
			invert[matriz.length-i] = matriz[i-1];
		}
		return invert;
}
	
	public static void main(String[] args) {

		/*Reciba una matriz (array bidimensional de floats, siguiendo el orden de primero fila y
		luego columna), y devuelva un array que contenga el valor máximo de cada fila.*/
		
		float matriz1 [][] = creaMatrizBid(5,10);
		float mayoresMatriz1 [] = buscaMayoresFila(matriz1);
		
		System.out.println("Matriz Original:");
		
		for (int i = 0; i<matriz1.length;i++) {
			for (int j = 0; j<matriz1[i].length;j++) {
				System.out.print(matriz1[i][j] + "   ");
				}
			System.out.println();			
			}
		
		System.out.println("Mayor de cada fila:");
		
		for (int i = 0; i<mayoresMatriz1.length;i++) {
			System.out.print(mayoresMatriz1[i] + "   ");
			}
		System.out.println();
		
		/*Invierta el orden de los elementos de un array de floats.*/
		
		System.out.println("Matriz Original");
		float matriz2 [] = creaMatrizUni(5);
		for (int i = 0; i<matriz2.length;i++) {
			System.out.print(matriz2[i] + "   ");
			}
		System.out.println();

		System.out.println("Matriz Invertida");
		float [] matrizInvert2  = invierteMatriz1(matriz2);
		for (int i = 0; i<matrizInvert2.length;i++) {
			System.out.print(matrizInvert2[i] + "   ");
			}
		
		/*Concatene dos arrays de chars*/
		
		char [] char1 = new char[] {'c','t','e'};
		char [] char2 = new char[] {'f','i','a'};
		char [] concat = Arrays.copyOf(char1, char1.length + char2.length);
		System.arraycopy(char2, 0, concat, char1.length, char2.length);
		
		
		System.out.println();
		System.out.println();
		
		System.out.println();
		String aVer = "Holi\nQue tal";
		System.out.println(aVer);
		String [] aVerSep = aVer.split("\n");
		
	
	}
		
		
	}


