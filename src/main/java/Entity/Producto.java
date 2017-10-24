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
	//Muchos productos pueden pertenecer a una determinada categoría
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private CategoriaDeProducto categoriaDeProducto;
	
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


	public List<Farmacia> getFarmacias() {
		return farmacias;
	}
	
	public void setCategoriaDeProducto( CategoriaDeProducto myCategoria )
	{
		this.categoriaDeProducto=myCategoria ;
	}
	
	public void addFarmacia(Farmacia farmacia){
		this.farmacias.add(farmacia);
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String myDescripcion) {
		this.descripcion = myDescripcion;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String myMarca) {
		this.marca = myMarca;
	}
	
	public int getPrecioCosto() {
		return precioCosto;
	}
	
	public void setPrecioCosto(int myPrecioCosto) {
		this.precioCosto = myPrecioCosto;
	}
	
	public int getPrecioLista() {
		return precioLista;
	}
	
	public void setPrecioLista(int myPrecioLista) {
		this.precioLista = myPrecioLista;
	}
	
	public CategoriaDeProducto getCategoriaDeProducto() {
		return this.categoriaDeProducto;
	}
	
	public void setFarmacias(List<Farmacia> farmacias) {
		this.farmacias = farmacias;
	}
	
}