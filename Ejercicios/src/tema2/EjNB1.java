package tema2;

public class EjNB1 {

	static class Producto {
		private String nombre;
		private double precio;
		private boolean enStock;

		public Producto(String nombre, double precio, boolean enStock) {
			this.nombre = nombre;
			this.precio = precio;
			this.enStock = enStock;
		}

		public String getNombre() {
			return this.nombre;
		}

		public double getPrecio() {
			return this.precio;
		}

		public boolean isEnStock() {
			return this.enStock;
		}

	}

	static class Categoria {
		private String nombre;
		private Producto[] productos;
		private Categoria[] subcategorias;

		public Categoria(String nombre, Producto[] productos, Categoria[] subcategorias) {
			this.nombre = nombre;

			if (productos != null) {
				this.productos = productos;
			} else {
				this.productos = new Producto[0];
			}

			if (subcategorias != null) {
				this.subcategorias = subcategorias;
			} else {
				this.subcategorias = new Categoria[0];
			}
		}

		public String getNombre() {
			return this.nombre;
		}

		public Producto[] getProductos() {
			return this.productos;
		}

		public Categoria[] getSubcategorias() {
			return this.subcategorias;
		}

	}

	static class EjercicioRecursividadIntermedio {
	
	public static double obtenerPrecioMaximoEnStock(Categoria inicio, int profundidadMaxima) {
	    return obtenerPrecioMaximoAux(inicio, 0, profundidadMaxima);
	}

	private static double obtenerPrecioMaximoAux(Categoria actual, int profundidadActual, int profundidadMaxima) {
	   if (profundidadMaxima<0 || actual == null) return -1; 
		
		Categoria [] subcategorias = actual.getSubcategorias();
		Producto [] productos = actual.getProductos();
		double precioMax = 0;

		
	    if(profundidadActual <= profundidadMaxima) { // Si coinciden, significa que si se volviese a iterar de la forma habitual, profundidadActual será estrictamente mayor que profundidadMáxima. Por tanto, exploro las subcategorias pero no llamo de nuevo al método
	    	
	    	for (int i = 0; i<productos.length; i++) { // Encuentra el máximo de la categoría actual 
				double precioActual = productos[i].getPrecio();
				if(precioMax<precioActual && productos[i].isEnStock()) precioMax = precioActual;
			}
	    	
	    } else {
	    	return 0;
	    }
	    
	    for (int i = 0; i<subcategorias.length; i++) { //Encuentra el maximo de la subcategoria siguiente. Si supera al precio máximo de la categoria acutal, lo iguala a dicha variable
	    	double precioMaxSiguiente = obtenerPrecioMaximoAux(subcategorias[i],profundidadActual+1,profundidadMaxima);
	    	if(precioMax < precioMaxSiguiente) precioMax = precioMaxSiguiente;
	    }
	    
	    return precioMax;
	    
		
	}

	public static void main(String[] args) {

	   Producto p1 = new Producto("Tarjeta Grafica RTX", 850.0, true); 
	   Producto p2 = new Producto("Silla Gaming", 300.0, false); 
	   Producto p3 = new Producto("Pantalla OLED 4K", 1500.0, true); 
	   Producto[] productosGaming = new Producto[]{p1, p2, p3};  
	   Producto p4 = new Producto("Raton USB", 30.0, true); 
	   Producto p5 = new Producto("Portatil Pro", 1200.0, true); 
	   Producto[] productosOrdenadores = new Producto[]{p4, p5};  
	   Producto p6 = new Producto("Cafetera", 80.0, true); 
	   Producto[] productosHogar = new Producto[]{p6}; 
	   Producto p7 = new Producto("Cable HDMI", 15.0, true); 
	   Producto p8 = new Producto("Funda Movil", 25.0, false); 
	   Producto[] productosElectronica = new Producto[]{p7, p8}; 
	   

	   Categoria catGaming = new Categoria("Gaming", productosGaming, null); 
	   Categoria[] subOrdenadores = new Categoria[]{catGaming}; 
	   Categoria catOrdenadores = new Categoria("Ordenadores", productosOrdenadores, subOrdenadores); 
	   Categoria catHogar = new Categoria("Hogar", productosHogar, null); 
	   Categoria[] subElectronica = new Categoria[]{catOrdenadores, catHogar}; 
	   Categoria catElectronica = new Categoria("Electronica", productosElectronica, subElectronica);
	   
	   System.out.println("El precio max es " + obtenerPrecioMaximoEnStock(catHogar,0));
	   
	   System.out.println("Profundidad maxima 0 (Esperado 15.0): " + obtenerPrecioMaximoEnStock(catElectronica, 4));
		
	}

	}

	}
