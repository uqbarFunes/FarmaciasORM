package hibernateConcept;
import org.junit.Assert;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityTransaction;

import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import Entity.Farmacia;
import Entity.Vendedor;
import db.EntityManagerHelper;

public class ContextTest extends AbstractPersistenceTest implements WithGlobalEntityManager {

	@Test
	public void contextUp() {
		EntityManagerHelper.getEntityManager();
	}

	@Test
	public void contextUpWithTransaction() throws Exception {
		EntityManagerHelper.withTransaction(() -> {});
	}
	
	@Test
	public void testGuardarFarmacia() throws Exception{
		Farmacia farmacia = new Farmacia();
		farmacia.setNombre("Farma24");
		entityManager().persist(farmacia);
	}
	
	@Test
	public void testGuardarVendedor() throws Exception{
		Vendedor vendedor = new Vendedor();
		vendedor.setNombre("Facundo");
		vendedor.setNumeroDeLegajo(1529887);
		vendedor.setFechaIngreso(Calendar.getInstance().getTime());
		
		Farmacia farmacia25 = new Farmacia();
		farmacia25.setNombre("Farma25");
		farmacia25.addVendedor(vendedor);
		
		vendedor.addFarmacia(farmacia25);
		
		entityManager().persist(vendedor);
	}
	
	@Test
	public void testRecuperarFarmacias(){
		Farmacia farmacia25 = new Farmacia();
		farmacia25.setNombre("Farma25");
		entityManager().persist(farmacia25);
		
		List<Farmacia> farmacias = entityManager().createQuery("from Farmacia", Farmacia.class).getResultList();
		
		Assert.assertEquals(true, farmacias.stream().anyMatch(f-> f.getNombre().equals("Farma25")));
		Assert.assertEquals(false, farmacias.stream().anyMatch(f-> f.getNombre().equals("Farma28")));
	}
}
