package hibernate.training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.training.entity.Brand;
import hibernate.training.util.HibernateUtil;

public class P03_AddNewBrand {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		try {
			Session session = factory.openSession();
			
			Transaction tx = session.beginTransaction();
			
			try {
				// add/modify/delete
				Brand b1 = new Brand();
				b1.setName("Reebok");
				
				System.out.println("Before saving, b1 is " + b1);
				
				// session.save(b1); // 
				session.persist(b1);
				System.out.println("session.persist(b1) called");
				
				tx.commit();
				System.out.println("tx.commit() called");
				System.out.println("After saving, b1 is " + b1);
			} catch (Exception e) {
				tx.rollback();
			}
			
			session.close();
		} finally {
			factory.close();
		}
	}
}
