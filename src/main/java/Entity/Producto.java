package Entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="Producto")
public class Producto {
	
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private TipoProducto tipo;
	
	private String descripcion;
	private String marca;
	private int precioCosto;
	private int precioLista;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Farmacia> farmacias;

	public Producto() {
		super();
		this.farmacias = new LinkedList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public void setTipo(TipoProducto tipo) {
		this.tipo = tipo;
	}
	
	public List<Farmacia> getFarmacias() {
		return farmacias;
	}
	
	public void addFarmacia(Farmacia farmacia){
		this.farmacias.add(farmacia);
	}
	
}
