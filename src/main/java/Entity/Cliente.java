package Entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name ="Cliente")
public class Cliente {

	@Id
	@GeneratedValue
	private int idCliente;
	
	private String nombre;
	
	@ElementCollection
	@CollectionTable(name="telefono", joinColumns=@JoinColumn(name="idCliente"))
	@Column(name="telefono")
	private List<Integer> telefonos;
	
	@ElementCollection
	@CollectionTable(name="domicilio", joinColumns=@JoinColumn(name="idCliente"))
	@Column(name="domicilio")
	private List<String> domicilios;

	public Cliente() {
		super();
		this.domicilios = new LinkedList<>();
		this.telefonos = new LinkedList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Integer> getTelefonos() {
		return telefonos;
	}

	public void addTelefono(int telefono) {
		this.telefonos.add(telefono);
	}
	
	public void addDomicilio(String domicilio){
		this.domicilios.add(domicilio);
	}
	
	
}
