import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
		
		CategoriaDeProducto productoLimpieza = new CategoriaDeProducto() ;
		productoLimpieza.setNombre("Producto de limpieza") ;
		
		CategoriaDeProducto estetico = new CategoriaDeProducto() ;
		estetico.setNombre("Estetico");
		
		CategoriaDeProducto golosina = new CategoriaDeProducto() ;
		golosina.setNombre("Golosina");
		
		CategoriaDeProducto dietetico = new CategoriaDeProducto() ;
		dietetico.setNombre("Dietetico");
		
		Producto vauquita = new Producto() ;
		vauquita.setMarca("Vauquita");
		vauquita.setPrecioCosto(2);
		vauquita.setPrecioLista(10);
		vauquita.addFarmacia(farmacia25);
		vauquita.setCategoriaDeProducto(golosina);
		vauquita.setDescripcion("Dulce de leche bañado de cocolate");
		
		Producto dove = new Producto();
		dove.setMarca("Shampoo Dove");
		dove.setPrecioCosto(15);
		dove.setPrecioLista(80);
		dove.addFarmacia(farmacia25);
		dove.addFarmacia(farmacity);
		dove.setCategoriaDeProducto(estetico);
		dove.setDescripcion("shampoo berreta");
		
		Producto cif = new Producto() ;
		cif.setMarca("Cif");
		cif.addFarmacia(farmacia25);
		cif.setPrecioCosto(5);
		cif.setPrecioLista(25);
		cif.setDescripcion("Cif Crema");
		cif.setCategoriaDeProducto(productoLimpieza);
		
		
		Query prodQuery = entityManager.createQuery("select (b) from Producto b") ;
		List <Producto> list = prodQuery.getResultList();
		System.out.println("Las cosas que me traigo...");
		ArrayList<String> listOutput = new ArrayList<String> () ;
		
		list.forEach(e -> {
			StringBuilder output = new StringBuilder() ;
			output.append(String.format("ID: %02d\t",e.getId()));
			output.append(String.format("Descripction: %-35s\t", e.getDescripcion()));
			output.append(String.format("Marca: %12s\t", e.getMarca()));
			output.append(String.format("Precio costo: %3d\t", e.getPrecioCosto()));
			int idDelProducto = e.getCategoriaDeProducto().getId() ;
			Query categoriaQuery = entityManager.createQuery("from CategoriaDeProducto "
					+ "E where E.id = :id");
			categoriaQuery.setParameter("id", idDelProducto) ;
			CategoriaDeProducto categoriaList = (CategoriaDeProducto) categoriaQuery
													.getSingleResult() ;
			
			output.append(String.format("Nombre de la categoría: %-15s\t",	
					categoriaList.getNombre()));
			listOutput.add(output.toString()) ;
			
		});
		
//		System.out.println("Veo si encuentro el producto de ID: 17");
//		Producto pId16 = entityManager.find(Producto.class, 17) ;
//		pId16.setId(45);
//		
//		EntityManagerHelper.beginTransaction();
//		entityManager.merge(pId16);
//		entityManager.flush();
//		EntityManagerHelper.commit() ;
		
		listOutput.forEach(System.out::println);
		
//		Producto[] productos = new Producto[17] ;
		
//		for ( int i = 1 ; i <= 16 ; i ++ )
//		{
//			productos[i] = entityManager.find(Producto.class, i) ;
//		}
		
		EntityManagerHelper.beginTransaction();
		
		
		 entityManager.persist(vendedor_ale);
		 entityManager.persist(vendedor_elio);
		 entityManager.persist(vendedor_flor);
		 entityManager.persist(vauquita);
		 entityManager.persist(dove);
		 entityManager.persist(cif) ;
		 
		
		entityManager.flush();
		EntityManagerHelper.commit();		
		
		
		
//		for ( int i = 1 ; i <= 16 ; i ++ )
//		{
//			entityManager.remove(productos[i]) ;
//		}
	}
}