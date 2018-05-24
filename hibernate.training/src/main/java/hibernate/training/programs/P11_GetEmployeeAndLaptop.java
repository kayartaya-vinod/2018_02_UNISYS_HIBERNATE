package hibernate.training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.training.entity.Employee;
import hibernate.training.entity.Laptop;
import hibernate.training.util.HibernateUtil;

public class P11_GetEmployeeAndLaptop {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		try {
			Session session = factory.openSession();
			Employee e1 = session.get(Employee.class, 1);
			Laptop l1 = session.get(Laptop.class, "SL003");
			session.close();
			
			System.out.printf("%s has been given %s (%s) latptop\n",
					e1.getName(), 
					e1.getLaptop().getMake(), 
					e1.getLaptop().getModel());
			
			System.out.printf("%s (%s) laptop is currently owned by %s\n",
					l1.getMake(),
					l1.getModel(),
					l1.getOwner().getName());
		} finally {
			factory.close();
		}
	}
}
