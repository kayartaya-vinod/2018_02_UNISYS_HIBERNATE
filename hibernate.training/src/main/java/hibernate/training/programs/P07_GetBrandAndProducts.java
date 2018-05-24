package hibernate.training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.training.entity.Brand;
import hibernate.training.entity.Product;
import hibernate.training.util.HibernateUtil;

// auto import CONTROL + SHIFT + O

public class P07_GetBrandAndProducts {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		try {
			Session session = factory.openSession();
			Brand b = session.get(Brand.class, 2);
			System.out.println("Brand name = " + b.getName());
			System.out.println("Products of this brand are: ");
			for(Product p: b.getProducts()) {
				System.out.println(p.getName() + " --> Rs." + p.getUnitPrice());
			}
			
			session.close();
		} finally {
			factory.close();
		}
	}
}
