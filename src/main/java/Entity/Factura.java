package Entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Table(name="Factura")
public class Factura {
	@Id
	@GeneratedValue
	int id ;
	
	private Date fechaEmision ;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Producto> productos;

	public int getIdFactura() {
		return id;
	}

	public void setIdFactura(int idFactura) {
		this.id = idFactura;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}	
}
