package hibernate.training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.training.entity.Product;
import hibernate.training.util.HibernateUtil;

public class P06_GetOneProduct {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		try {
			Session session = factory.openSession();
			Product p = session.get(Product.class, 22);
			session.close();
			
			System.out.println("Name     = " + p.getName());
			System.out.println("Price    = Rs." + p.getUnitPrice());
			System.out.println("Category = " + p.getCategory().getName());
			System.out.println("Brand    = " + p.getBrand().getName());
			
		} finally {
			factory.close();
		}
	}
}
