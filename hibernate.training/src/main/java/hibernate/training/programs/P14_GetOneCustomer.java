package hibernate.training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.training.entity.Customer;
import hibernate.training.util.HibernateUtil;

public class P14_GetOneCustomer {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		try {
			Session session = factory.openSession();
			Customer c1 = session.get(Customer.class, 1);
			session.close();
			
			System.out.println(c1);
		} finally {
			factory.close();
		}
	}
}
