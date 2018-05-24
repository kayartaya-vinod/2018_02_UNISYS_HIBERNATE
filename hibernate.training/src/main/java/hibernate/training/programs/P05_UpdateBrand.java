package hibernate.training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.training.entity.Brand;
import hibernate.training.util.HibernateUtil;

public class P05_UpdateBrand {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		try {
			Session session = factory.openSession();
			Brand b1 = session.get(Brand.class, 4);
			session.close();
			
			b1.setName("Nike");
			
			session = factory.openSession();
			session.beginTransaction();
			session.merge(b1); // session.update(b1) or session.saveOrUpdate(b1);
			session.getTransaction().commit();
			session.close();
			
		} finally {
			factory.close();
		}
	}
}
