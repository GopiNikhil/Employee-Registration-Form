package spring_mvc2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import spring_mvc2.dto.Employee;

@Repository
public class EmployeeDao {
	EntityManager em = Persistence.createEntityManagerFactory("nikki").createEntityManager();
	EntityTransaction et = em.getTransaction();

	public Employee saveEmployee(Employee employee) throws Exception {
		et.begin();
		em.persist(employee);
		et.commit();
		return employee;
	}

	public Employee fetchbyEmail(String email) throws Exception {

		Query query = em.createQuery("select a from Employee a where a.email=?1");
		query.setParameter(1, email);
		return (Employee) query.getSingleResult();

	}

	public List<Employee> fetchAll() {
		Query query = em.createQuery("select a from Employee a ");
		return query.getResultList();
	}
	
	public Employee deleteEmployee(int id) {
		Employee employee=em.find(Employee.class, id);
		if(employee!=null) {
		et.begin();
		em.remove(employee);
		et.commit();
		return employee;
		}
		else
			return null;	
	}
	
	public Employee updateEmployee(Employee employee) {
		Employee emp= em.find(Employee.class, employee.getId());
		if(employee!=null) {
			et.begin();
			em.merge(employee);
			et.commit();
		}
		return employee;
		
	}
	
	public Employee fetchEmployeeByID(int id) {
		Employee employee=em.find(Employee.class, id);
		if(employee!=null) {
		
		return employee;
		}
		else
			return null;	
	}
	
	
	 }
