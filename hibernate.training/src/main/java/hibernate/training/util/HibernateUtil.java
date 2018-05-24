package hibernate.training.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import hibernate.training.entity.Brand;
import hibernate.training.entity.Customer;
import hibernate.training.entity.Employee;
import hibernate.training.entity.Laptop;
import hibernate.training.entity.LineItem;
import hibernate.training.entity.Order;
import hibernate.training.entity.Person;
import hibernate.training.entity.Product;
import hibernate.training.entity.Professor;
import hibernate.training.entity.Skill;
import hibernate.training.entity.Student;

public class HibernateUtil {
	private static SessionFactory factory = null;

	public static SessionFactory getSessionFactory() {
		if (factory != null)
			return factory;

		Properties props = new Properties();
		props.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
		props.setProperty("hibernate.connection.url", "jdbc:h2:tcp://localhost/~/unisys_hibernate_training");
		props.setProperty("hibernate.connection.username", "sa");
		props.setProperty("hibernate.connection.password", "");
		
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		props.setProperty("hibernate.show_sql", "false");
		props.setProperty("hibernate.format_sql", "true");
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		
		// configuration to build a session factory
		Configuration cfg = new Configuration();
		// cfg.configure(); // reads all the information from hibernate.cfg.xml
		
		// register all entity classes with the session factory
		cfg.addAnnotatedClass(Brand.class);
		cfg.addAnnotatedClass(Product.class);
		cfg.addAnnotatedClass(Employee.class);
		cfg.addAnnotatedClass(Laptop.class);
		cfg.addAnnotatedClass(Skill.class);
		cfg.addAnnotatedClass(LineItem.class);
		cfg.addAnnotatedClass(Order.class);
		cfg.addAnnotatedClass(Customer.class);
		
		cfg.addAnnotatedClass(Person.class);
		cfg.addAnnotatedClass(Student.class);
		cfg.addAnnotatedClass(Professor.class);
		
		cfg.addFile("src/main/java/hibernate/training/entity/category.hbm.xml");
		
		StandardServiceRegistry registry =
				new StandardServiceRegistryBuilder().applySettings(props).build();
		
		factory = cfg.buildSessionFactory(registry);
		return factory;
	}
	
	
}





