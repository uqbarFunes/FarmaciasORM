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
@Table(name ="Producto")
public class Producto {
	
	@Id
	@GeneratedValue
	private int idProducto;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<CategoriaDeProducto> categoriasDeProducto;
	
	private String descripcion;
	private String marca;
	private int precioCosto;
	private int precioLista;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Farmacia> farmacias;

	public Producto() {
		super();
		this.categoriasDeProducto = new LinkedList<>() ;
		this.farmacias = new LinkedList<>();
	}

	public int getId() {
		return idProducto;
	}

	public void setId(int id) {
		this.idProducto = id;
	}


	public void setCategoriasDeProducto(List<CategoriaDeProducto> myTipos) {
		this.categoriasDeProducto = myTipos;
	}
	
	public List<Farmacia> getFarmacias() {
		return farmacias;
	}
	
	public void addCategoriaDeProducto( CategoriaDeProducto myCategoria )
	{
		this.categoriasDeProducto.add(myCategoria) ;
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
	
	public List<CategoriaDeProducto> getCategoriasDeProducto() {
		return this.categoriasDeProducto;
	}
	
	public void setFarmacias(List<Farmacia> farmacias) {
		this.farmacias = farmacias;
	}
	
}