package tema2;

import java.util.ArrayList;
import java.util.List;

public class Ej1 {
	
	// Representa un archivo con un tamaño específico
	public static class Archivo {
	
		private String nombre;
		private double pesoMB; // Tamaño en Megabytes
	
		public Archivo (String nombre, double peso) { 
			this.nombre = nombre;
			this.pesoMB=peso;
		}
	
		public double getPesoMB () { return this.pesoMB; }
		
		
	}
	
	// Representa una carpeta que puede contener archivos y otras subcarpetas
	public static class Carpeta {
		private String nombre;
		private List<Archivo> archivos; // Archivos directos en esta carpeta
		private List<Carpeta> subcarpetas; // Carpetas dentro de esta carpeta
		
		public Carpeta (String nombre) { 
			this.nombre = nombre;
			archivos = new ArrayList<Archivo>();
			subcarpetas = new ArrayList<Carpeta>();

		}
		
		public List<Archivo> getArchivos () { return this.archivos; }
		public List<Carpeta> getSubcarpetas () { return this.subcarpetas; }
		
		public void creaArchivo (String nombre, double peso) {
			Archivo a = new Archivo (nombre, peso);
			archivos.add(a);
		}
		
		public Carpeta creaCarpeta (String nombre) {
			Carpeta c = new Carpeta (nombre);
			return c;
		}
		
		public void añadeCarpeta (Carpeta c) {
			subcarpetas.add(c);
			
		}
		
		
		
		public static double calcularPesoTotal(Carpeta inicio) {
			double pesoTotal = 0;
			//caso base
			List <Archivo> archivos = inicio.getArchivos();
			List <Carpeta> carpeta = inicio.getSubcarpetas();
			if(archivos.isEmpty() && carpeta.isEmpty()) {
				return 0;
			}
			for (Archivo a : archivos) {
				pesoTotal += a.getPesoMB();
			}
			
			//caso recursivo
			for (Carpeta c : carpeta) {
				pesoTotal += calcularPesoTotal(c);
			}
			return pesoTotal;
		
		
	}
	
	public static void main (String [] args) {
		
		Carpeta Uni = new Carpeta("Uni");
			
			Uni.creaArchivo("Notas",1);
			
			Carpeta matricula = Uni.creaCarpeta("Matricula");
			Uni.añadeCarpeta(matricula);
			
				matricula.creaArchivo("recibo", 2);
				
				Carpeta asignaturas = new Carpeta("asignaturas");
				matricula.añadeCarpeta(asignaturas);
					
					asignaturas.creaArchivo("ALED", 12);
				
			Uni.creaCarpeta("Erasmus");
				
			
		System.out.println(calcularPesoTotal(Uni));
			
		
		
		
		
	}
	
	
	}
}

