package hibernate.training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.training.entity.Brand;
import hibernate.training.entity.Product;
import hibernate.training.util.HibernateUtil;

public class P09_TestingCascadeOptions {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		try {
			Session session = factory.openSession();
			Brand b1 = session.get(Brand.class, 1); // persistent
			Product p1 = session.get(Product.class, 1);
			
			System.out.println("Total products = " + b1.getProducts().size());
			b1.getProducts().remove(p1);
			System.out.println("Total products = " + b1.getProducts().size());
			
//			Product p1 = new Product(); // transient
//			p1.setName("Apple Royal Gala");
//			p1.setUnitPrice(229.9);
//			p1.setDescription("Apple Royal Gala - medium");
//			p1.setQuantityPerUnit("1 KG, 4 - 5 pcs");
//			
//			b1.addProduct(p1);
			
			 session.merge(b1);
			
			session.beginTransaction().commit();
			session.close();
		} finally {
			factory.close();
		}
	}
}
