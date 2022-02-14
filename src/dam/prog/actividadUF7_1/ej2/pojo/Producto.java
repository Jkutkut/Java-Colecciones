package dam.prog.actividadUF7_1.ej2.pojo;

public class Producto implements Comparable<Producto> {
	private String nombre;
	private int cantidad;
	
	public Producto(String nombre, int cantidad) {
		this.nombre = nombre;
		
		this.cantidad = cantidad;
	}
	
	@Override
	public int hashCode() {
		return nombre.hashCode() + this.cantidad;
	}
	
	@Override
	public String toString() {
		return String.format("Producto %s, cantidad %d", nombre, cantidad);
	}
	
	@Override
	public boolean equals(Object p) {
//		return p.hashCode() == this.hashCode();
		Producto pp = (Producto) p;
		return nombre.equals(pp.getNombre()) && cantidad == pp.getCantidad(); 
	}
	
	
	
	public String getNombre() {
		return nombre;
	}
	
	public int getCantidad() {
		return cantidad;
	}

	@Override
	public int compareTo(Producto p2) {
		if (this.getCantidad() == p2.getCantidad()) {
			return this.getNombre().compareTo(p2.getNombre());
		}
		return this.getCantidad() - p2.getCantidad();
	}
}
