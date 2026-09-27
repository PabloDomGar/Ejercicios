package tema1;
import java.util.Scanner;

public class TiposDatosYControl {
	
	public static boolean esPrimo (int num) {
		if(num==1) return false;
		for (int referencia = num-1 ;referencia>1;referencia--) {
			if (num%referencia == 0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		/*Defina variables que representen el número de días de un año, el número de horas que
		tiene un día, el número de minutos que tiene una hora y el número de segundos que tiene
		un minuto. Emplee las variables que ocupen el mínimo espacio de memoria posible. A
		continuación, calcule el número de segundos que tiene un año y almacene el valor de dicho
		cálculo en otra variable.*/
			
		short diasAño = 365;
		short horasDia = 24;
		short minutosHora = 60;
		short segundosMinuto = 60;
		int segundosAño = diasAño*horasDia*minutosHora*segundosMinuto;
		
		System.out.println("Segundos en un año: " + segundosAño);
		
		/*Muestre por pantalla los mayores números enteros que se pueden representar mediante un
		char, un short y un int.*/
		
		System.out.println("Mayor char: " + Character.MAX_VALUE);
		System.out.println("Mayor short: " + Short.MAX_VALUE);
		System.out.println("Mayor int: " + Integer.MAX_VALUE);
		
		/*Calcule la suma de todos los múltiplos de 5 comprendidos entre 1 y 100. También debe
		calcular cuántos hay y mostrar visualizar cada uno de ellos.*/
		
		int suma = 0;
		int cuenta = 0;
		
		for (int i=1;i<=20;i++) {
			suma += i*5;
			cuenta++;
			System.out.print(" " + cuenta*5);
		}
		System.out.println();
		System.out.println("Hay " + cuenta + " múltiplos de 5 hasta el 100 y suman " + suma);
		
		/*Calcule el mínimo y el máximo de una serie de números enteros positivos introducidos por
		el usuario. Cuando el usuario introduzca un número negativo se considerará que el anterior
		a este es el último número.*/
		
//		Scanner sc = new Scanner(System.in);
//		String lista = sc.nextLine();
//		String [] arrayLista = lista.split(" ");
//		int mayor = 0;
//		int menor = 20;
//		int actual = 0;
//		for (int i = 0; i<arrayLista.length; i++) {
//			actual = Integer.parseInt(arrayLista[i]);
//			if (actual>mayor) {
//				mayor = actual;
//			}
//			if (actual<menor) {
//				menor = actual;
//			}
//			
//		}
//		
//		System.out.println("Mayor de la serie: " + mayor);
//		System.out.println("Menor de la serie: " + menor);
//		sc.close();
		
		/*Muestre por pantalla la lista de los 100 primeros números primos.*/
		for (int i = 2; i<100; i++) {
			for (int j=2;j<11;j++) {
				if ((i>j || i<10) && (i!=j)) {
					if (i%j==0) break;
					if (j==10) System.out.print(" " + i);
				}
			}
		}
		System.out.println();
		
		/*Tome un número entero escrito por el usuario y lo descomponga en factores primos.*/
		
		int num = 224;
		System.out.print("Factores primos de " + num + ": ");
		int dividendo = 2;
		
		while (dividendo!=1) {
			for(int i=2;i<=num;i++) {
				if (esPrimo(i) && num%i==0) {
					System.out.print(i + " ");
					num/=i;
					break;
				}
			}
		
		}
		System.out.println();
		
		
		
		
		
		
	}
}
