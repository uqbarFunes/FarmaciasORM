package Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name ="Vendedor")
public class Vendedor {
	
	private String nombre;
	
	@Id
	@GeneratedValue
	private int id;
	private int numeroDeLegajo;
	private Date fechaIngreso;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Farmacia> farmacias;

	public Vendedor(){
		super();
		this.farmacias = new LinkedList<>();
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroDeLegajo() {
		return numeroDeLegajo;
	}

	public void setNumeroDeLegajo(int numeroDeLegajo) {
		this.numeroDeLegajo = numeroDeLegajo;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public List<Farmacia> getFarmacias() {
		return farmacias;
	}
	
	public void addFarmacia(Farmacia farmacia){
		this.farmacias.add(farmacia);
	}
}
