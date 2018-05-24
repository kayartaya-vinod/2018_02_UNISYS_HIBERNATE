package hibernate.training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.training.entity.Brand;
import hibernate.training.util.HibernateUtil;

public class P01_GetOneBrand {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		try {
			Session session = factory.openSession();
			Brand b1 = session.get(Brand.class, 1);
			session.close();
			
			System.out.println(b1);

		} finally {
			factory.close();
		}
	}
}
