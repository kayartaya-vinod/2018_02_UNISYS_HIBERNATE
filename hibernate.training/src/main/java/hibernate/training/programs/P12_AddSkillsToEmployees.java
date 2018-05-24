package hibernate.training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.training.entity.Employee;
import hibernate.training.entity.Skill;
import hibernate.training.util.HibernateUtil;

public class P12_AddSkillsToEmployees {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		try {
			Session session = factory.openSession();
			Employee e1 = session.get(Employee.class, 1);
			Employee e2 = session.get(Employee.class, 2);
			
			Skill s1 = new Skill(10, "Java");
			Skill s2 = new Skill(20, "Spring");
			Skill s3 = new Skill(30, "Hibernate");
			Skill s4 = new Skill(40, "Python");
			
			session.persist(s1);
			session.persist(s2);
			session.persist(s3);
			session.persist(s4);
			
			s1.addEmployee(e1);
			s1.addEmployee(e2);
			
			s2.addEmployee(e1);
			
			session.beginTransaction().commit();
			session.close();
		} finally {
			factory.close();
		}
	}
}
