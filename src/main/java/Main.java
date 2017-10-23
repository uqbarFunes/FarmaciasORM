import java.util.Calendar;

import javax.persistence.EntityManager;

import Entity.*;
import db.EntityManagerHelper;
public class Main {

	public static void main(String[] args) {
		EntityManager entityManager= EntityManagerHelper.getEntityManager();

		Vendedor vendedor_ale = new Vendedor();
		vendedor_ale.setNombre("Alejandro");
		vendedor_ale.setNumeroDeLegajo(1529889);
		vendedor_ale.setFechaIngreso(Calendar.getInstance().getTime());
		
		Vendedor vendedor_elio = new Vendedor();
		vendedor_elio.setNombre("Elio");
		vendedor_elio.setNumeroDeLegajo(9238);
		vendedor_elio.setFechaIngreso(Calendar.getInstance().getTime());
		
		Vendedor vendedor_flor = new Vendedor();
		vendedor_flor.setNombre("Flor");
		vendedor_flor.setNumeroDeLegajo(29387492);
		vendedor_flor.setFechaIngreso(Calendar.getInstance().getTime());
		
		Farmacia farmacia25 = new Farmacia();
		farmacia25.setNombre("Farma25");
		farmacia25.addVendedor(vendedor_ale);
		
		Farmacia farmacity = new Farmacia() ;
		farmacity.setNombre("Farmacity");
		farmacity.addVendedor(vendedor_flor);
		farmacity.addVendedor(vendedor_elio);
		
		vendedor_ale.addFarmacia(farmacia25);
		vendedor_flor.addFarmacia(farmacity);
		vendedor_elio.addFarmacia(farmacity);
		
		EntityManagerHelper.beginTransaction();
		entityManager.persist(vendedor_ale);
		entityManager.flush();
		EntityManagerHelper.commit();
		
		EntityManagerHelper.beginTransaction();
		entityManager.persist(vendedor_elio);
		entityManager.flush();
		EntityManagerHelper.commit();
		
		EntityManagerHelper.beginTransaction();
		entityManager.persist(vendedor_flor);
		entityManager.flush();
		EntityManagerHelper.commit();
		
		CategoriaDeProducto productoLimpieza = new CategoriaDeProducto() ;
		productoLimpieza.setNombre("Producto de limpieza") ;
		
		CategoriaDeProducto comestible = new CategoriaDeProducto() ;
		comestible.setNombre("Producto comestible");
		
		CategoriaDeProducto golosina = new CategoriaDeProducto() ;
		golosina.setNombre("Golosina");
		
		CategoriaDeProducto dietetico = new CategoriaDeProducto() ;
		dietetico.setNombre("Dietetico");
		
		Producto vauquita = new Producto() ;
		vauquita.setMarca("Vauquita");
		vauquita.setPrecioCosto(2);
		vauquita.setPrecioLista(10);
		vauquita.addFarmacia(farmacia25);
		vauquita.addCategoriaDeProducto(golosina);
		vauquita.addCategoriaDeProducto(comestible);
		
		Producto cif = new Producto() ;
		cif.setMarca("Cif");
		
		
	}

}
