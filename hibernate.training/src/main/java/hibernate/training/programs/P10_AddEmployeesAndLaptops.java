package hibernate.training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.training.entity.Employee;
import hibernate.training.entity.Laptop;
import hibernate.training.util.HibernateUtil;

public class P10_AddEmployeesAndLaptops {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		try {
			Session session = factory.openSession();

			Employee e1 = new Employee("Ramesh", 45000.0);
			Employee e2 = new Employee("Suresh", 47000.0);
			Employee e3 = new Employee("Harish", 46000.0);

			Laptop l1 = new Laptop("SL001", "Apple", "Mackbook Pro");
			Laptop l2 = new Laptop("SL002", "Lenovo", "Z560");
			Laptop l3 = new Laptop("SL003", "Acer", "Travelmate");
			
			e1.setLaptop(l1); l1.setOwner(e1);
			e2.setLaptop(l3); l3.setOwner(e2);
			
			session.persist(e1);
			session.persist(e2);
			session.persist(e3);
			
			session.persist(l1);
			session.persist(l2);
			session.persist(l3);

			session.beginTransaction().commit();
			session.close();
		} finally {
			factory.close();
		}
	}
}
