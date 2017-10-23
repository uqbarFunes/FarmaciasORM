package Entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name ="Farmacia")
public class Farmacia {

	@Id
	@GeneratedValue
	private int idFarmacia;
	
	private String nombre;
	private String localidad;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "farmacias")
	private List<Vendedor> vendedores;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "farmacias")
	private List<Producto> productos;
	
	public Farmacia() {
		super();
		this.vendedores = new LinkedList<>();
	}

	public int getId() {
		return idFarmacia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public List<Vendedor> getVendedores() {
		return vendedores;
	}
	
	public void addVendedor(Vendedor vendedor){
		this.vendedores.add(vendedor);
	}
}
