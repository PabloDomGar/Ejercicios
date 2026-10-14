package tema2;

public class Ej8 {
	
	public static class NodoLista { int dato; NodoLista siguiente; 
		public NodoLista (int dato, NodoLista siguiente) {
			this.dato = dato;
			this.siguiente = siguiente;
		}
		public void setSiguiente(NodoLista siguiente) {
			this.siguiente = siguiente;
		}
	}
	
	
	public static NodoLista invertirRecursivo (NodoLista actual) {
	
		// Caso base: lista vacía o único elemento
	
		if (actual == null || actual.siguiente == null) {
		return actual;
		}
		
		// Paso recursivo:
		
		NodoLista next = invertirRecursivo(actual.siguiente);
		
		actual.siguiente.siguiente = actual;
	    actual.siguiente = null;

		return next;
		

	}

	public static void main(String[] args) {
		
		NodoLista n1 = new NodoLista(1,null);
		NodoLista n2 = new NodoLista(2,null);
		NodoLista n3 = new NodoLista(3,null);
		NodoLista n4 = new NodoLista(4,null);
		n1.setSiguiente(n2);
		n2.setSiguiente(n3);
		n3.setSiguiente(n4);

		
		NodoLista invert = invertirRecursivo(n1);
		
		boolean sigue = true;
		while(sigue) {
			System.out.println(invert.dato);
			sigue = false;
		}

		


	}

}

