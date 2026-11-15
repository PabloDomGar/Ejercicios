package tema3;

import java.util.Random;

public class Intento1Ej1 {
	
	static class Numero {
		
		private int valor;
		
		public Numero (int valor) {
			this.valor = valor;
		}

		public int getValor() {
			return valor;
		}

		public synchronized void setValor(int valor) {
			this.valor = valor;
		}
	
	}

	static class Escritora extends Thread {
		
		private int ident;
		private Numero num;
		Random rd = new Random();
		
		public Escritora (int ident, Numero num) {
			this.ident = ident;
			this.num = num;
		}
		
		public synchronized void escribe () {
			int valorAleatorioCreado = rd.nextInt(0, 10000);
			num.setValor(valorAleatorioCreado);
			System.out.println("Hebra ESCRITORA" + ident + " ha escrito el número " + num.getValor());
		}
		
		@Override
		public void run() {
			
			for (int i = 0; i<10; i++) {
				escribe();
				try {
					sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	static class Lectora extends Thread {
		
		private int ident;
		private Numero num;

		
		public Lectora (int ident, Numero num) {
			this.ident = ident;
			this.num = num;
		}
		
		public void lee () {
			System.out.println("Hebra LECTORA" + ident + " ha leído el número " + num.getValor());
		}
		
		@Override
		public void run() {
			
			for (int i = 0; i<10; i++) {
				lee();
				try {
					sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	static class Pruebas {
		
		public static void main(String args[]) {
			
			int hebras = 10;
			
			
			Numero num = new Numero(0);
			
			for (int i = 0; i<hebras; i++) {
				Escritora e = new Escritora(i,num);
				e.start();
				Lectora l = new Lectora(i,num);
				l.start();
			}
			
			
			
			
			
			
			
			
		}
		
	}

	
}
