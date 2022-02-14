package dam.prog.actividadUF7_1.ej4.pojo;

public class Producto implements Comparable<Producto> {
	private String nombre;
	private int precio;
	
	public Producto(String nombre, int precio) {
		this.nombre = nombre;
		
		this.precio = precio;
	}
	
	@Override
	public int hashCode() {
		return nombre.hashCode() + this.precio;
	}
	
	@Override
	public String toString() {
		return String.format("Producto %s, precio %d", nombre, precio);
	}
	
	@Override
	public boolean equals(Object p) {
//		return p.hashCode() == this.hashCode();
		Producto pp = (Producto) p;
		return nombre.equals(pp.getNombre()) && precio == pp.getPrecio(); 
	}
	
	
	
	public String getNombre() {
		return nombre;
	}
	
	public int getPrecio() {
		return precio;
	}
	
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public int compareTo(Producto p2) {
		if (this.getPrecio() == p2.getPrecio()) {
			return this.getNombre().compareTo(p2.getNombre());
		}
		return this.getPrecio() - p2.getPrecio();
	}
}
