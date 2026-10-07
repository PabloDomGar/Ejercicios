package tema2;

import java.util.ArrayList;
import java.util.List;

public class Ej2 {

	public static class Empleado {
		
		private String nombre;
		private double salario;
		private List<Empleado> subordinados; // Lista de empleados a su cargo
		
		public Empleado (String nombre, double salario) { 
			this.nombre = nombre;
			this.salario = salario; 
			this.subordinados = new ArrayList<>();
		}
		
		public double getSalario () { return this.salario; }
		public List<Empleado> getSubordinados () { return this.subordinados; }
		public void añadeSubordinado (Empleado sub) {
			this.subordinados.add(sub);
		}
		
		public static double presupuestoEquipo (Empleado jefe) {
			double presupuestoTotal = 0;
			presupuestoTotal += jefe.getSalario();
			for (Empleado e : jefe.getSubordinados()) {
				presupuestoTotal += presupuestoEquipo(e);
			}
			return presupuestoTotal;
		}
		
		public static void main(String[] args) {

			Empleado boss1 = new Empleado ("Pedro Sanxe", 20000);
				Empleado boss12 = new Empleado ("Carlos Body", 10000);
					Empleado boss121 = new Empleado ("Juanjo", 5000);
					Empleado boss122 = new Empleado ("Juana", 5000);
				Empleado boss13 = new Empleado ("Margaret", 20000);
			boss1.añadeSubordinado(boss12);
			boss1.añadeSubordinado(boss13);
			boss12.añadeSubordinado(boss121);
			boss12.añadeSubordinado(boss122);
			System.out.println("El presupuesto de la plantilla es " + presupuestoEquipo(boss1));
			
			
		}
		
		}
	
	


}
