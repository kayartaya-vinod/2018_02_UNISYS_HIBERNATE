package hibernate.training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.training.entity.Professor;
import hibernate.training.entity.Student;
import hibernate.training.util.HibernateUtil;

public class P15_InheritanceStrategies {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		try {
			Session session = factory.openSession();
			session.beginTransaction();
			
			Student s1 = new Student();
			s1.setId(101);
			s1.setName("Ramesh");
			s1.setSubject("MATHS");
			s1.setMarks(98.9);
			s1.setCity("Bangalore");
			
			Professor p1 = new Professor();
			p1.setId(102);
			p1.setName("Suresh");
			p1.setCity("Chennai");
			p1.setEmail("suresh@email.com");
			p1.setSalary(98000.0);
			
			session.persist(s1);
			session.persist(p1);
					
			
			session.getTransaction().commit();
			session.close();
		} finally {
			factory.close();
		}
	}
}
