package hibernate.training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.training.entity.Category;
import hibernate.training.entity.Product;
import hibernate.training.util.HibernateUtil;

public class P08_GetCategoryAndProducts {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		try {
			Session session = factory.openSession();
			Category c = session.get(Category.class, 1);
			c.getProducts().isEmpty(); // call to any method of the set triggers the fetch
			session.close();
			
			System.out.println("Category name: " + c.getName());
			for(Product p: c.getProducts()) { 
				System.out.println(p.getName() + " --> Rs." + p.getUnitPrice());
			}
			
		} finally {
			factory.close();
		}
	}
}
