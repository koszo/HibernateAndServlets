//package com.sda.model;
//
//import java.util.List;
//
//import javax.persistence.Query;
//
//import org.hibernate.Criteria;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.criterion.Restrictions;
//
//
//public class App {
//
//	private static SessionFactory sessionFactory;
//
//	public static void main(String[] args) {
//		sessionFactory = new Configuration().configure().buildSessionFactory();
//		
////		getAllEmployeess();
//
////		getEmployeeByFirstName("Neena");
//
////		System.out.println(getEmployeeById(103));
//
////		getAllJobs();
//		
////		Employee emp = new Employee(25, "Ramona", "Cristea", "ramo@ceva", "0573", 
////			LocalDate.of(2019, 01, 01), "IT_PROG", 15000);
////		saveEmployee(emp);
//		System.out.println(getEmployeeById(110));
//		
////		getEmployeeByJobTitle("Programmer");
//		
//		sessionFactory.close();
//	}
//	
//	public static void getAllEmployeess() {
//		Session session = sessionFactory.openSession();
//		Transaction tx  = session.beginTransaction();
//		
//		Query query = session.createQuery("from Employee");
//		List<Employee> employees = query.getResultList();
//		
//		
//		tx.commit();
//		session.close();
//		
//		return employees;
//	}
//	
//	public static void getEmployeeByFirstName(String firstName) {
//		Session session = sessionFactory.openSession();
//		Transaction tx = session.beginTransaction();
//		
//		Query query = session.createQuery("from Employee e where e.firstName =: firstName");
//		query.setParameter("firstName", firstName);
//		
//		List<Employee> employees = query.getResultList();
//		
//		System.out.println("------------Employees by first name -----------------");
//		
//		for(Employee employee : employees) {
//			System.out.println(employee);
//		}
//		
//		tx.commit();
//		session.close();
//	}
//	
//	public static Employee getEmployeeById(int id) {
//		Session session = sessionFactory.openSession();
//		Transaction tx = session.beginTransaction();
//		
//		Employee employee = session.find(Employee.class, id);
//		
//		tx.commit();
//		session.close();
//		
//		return employee;
//		
//	}
//	
//	public static void getAllJobs() {
//		Session session = sessionFactory.openSession();
//		Transaction tx = session.beginTransaction();
//		
//		Query query = session.createQuery("from Job");
//		List<Job> jobs = query.getResultList();
//		
//		for(Job job : jobs) {
//			System.out.println(job);
//	}
//	}
//	
//	public static void saveEmployee(Employee employee) {
//		Session session = sessionFactory.openSession();
//		Transaction tx = session.beginTransaction();
//		
//		session.save(employee);
//		
//		tx.commit();
//		session.close();
//		
//	}
//	
//	public static List<Employee> getEmployeeByJobTitle(String jobTitle) {
//		Session session = sessionFactory.openSession();
//		Transaction tx = session.beginTransaction();
//		
//		Query query = session.createQuery("from Employee as e where e.job.jobTitle =: jobTitle");
//		query.setParameter("jobTitle", jobTitle);
//		List<Employee> employees = query.getResultList();
//		
//		for(Employee employee:employees) {
//			System.out.println(employee);
//		}
//		
//		tx.commit();
//		session.close();
//		return employees;
//	}
//	
//	public static void getEmployeeByJobTitleUsingCriteria(String jobTitle) {
//		Session session = sessionFactory.openSession();
//		Transaction tx = session.beginTransaction();
//		
//		Criteria criteria = session.createCriteria(Employee.class, "e");
//		criteria.createAlias("e.job", "j"); // face inner join
//		criteria.add(Restrictions.eq("j.jobTitle", jobTitle));
//		
//		List<Employee> employees = criteria.list();
//		
//		for(Employee employee : employees) {
//			System.out.println(employee);
//		}
//		
//		tx.commit();
//		session.close();
//	}
//}