import java.util.Calendar;

import javax.persistence.EntityManager;

import Entity.*;
import db.EntityManagerHelper;
public class Main {

	public static void main(String[] args) {
		EntityManager entityManager= EntityManagerHelper.getEntityManager();

		Vendedor vendedor = new Vendedor();
		vendedor.setNombre("Alejandro");
		vendedor.setNumeroDeLegajo(1529889);
		vendedor.setFechaIngreso(Calendar.getInstance().getTime());
		
		Farmacia farmacia25 = new Farmacia();
		farmacia25.setNombre("Farma26");
		farmacia25.addVendedor(vendedor);
		
		vendedor.addFarmacia(farmacia25);

		EntityManagerHelper.beginTransaction();
		entityManager.persist(vendedor);
		entityManager.flush();
		EntityManagerHelper.commit();
		
	}

}
