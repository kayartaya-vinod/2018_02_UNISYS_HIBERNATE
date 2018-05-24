package hibernate.training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.training.entity.Category;
import hibernate.training.util.HibernateUtil;

public class P02_GetOneCategory {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		try {
			Session session = factory.openSession();

			Category c1 = session.load(Category.class, 1);
			
			
			System.out.println("c1 is an instanceof " + c1.getClass());
			
			session.close();
			System.out.println("Id   = " + c1.getId());
			System.out.println("Name = " + c1.getName());
			
		} finally {
			factory.close();
		}
		
	}
}
