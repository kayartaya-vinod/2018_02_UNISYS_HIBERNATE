package hibernate.training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.training.entity.Brand;
import hibernate.training.util.HibernateUtil;

public class P04_UpdateBrand {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		try {
			Session session = factory.openSession();
			session.beginTransaction();
			
			Brand b1 = session.get(Brand.class, 4);
			System.out.println(b1);
			
			b1.setName("Nike");
			
			System.out.println("Pass-1");
			session.getTransaction().commit(); // sends SQL UDPATE queries for all 'dirty' entities
			System.out.println("Pass-2");
			session.close();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}
}
