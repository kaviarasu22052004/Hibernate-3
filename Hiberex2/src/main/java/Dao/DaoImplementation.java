package Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Connection.HibernateConnection;
import Model.Student;

public class DaoImplementation implements DaoInterface {

    SessionFactory factory;

    public DaoImplementation() {
        factory = HibernateConnection.getSessionFactory();
    }

    @Override
    public void savedata(Student s) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(s);
        tx.commit();
        session.close();
    }

    @Override
    public void removeByRoll(int roll) {
        Session session = factory.openSession();
        Transaction txt = session.beginTransaction();

        Student s = session.find(Student.class, roll);

        if (s == null) {
            System.out.println("Student Not Found");
        } else {
            session.delete(s);
            System.out.println("Student Deleted Successfully");
        }

        txt.commit(); 
        session.close(); 
    }

	@Override
	public void updatebyroll(int roll, String name, double mark) {
        Session session = factory.openSession();
        Transaction txt = session.beginTransaction();

        Student s = session.find(Student.class, roll);
        if (s == null) {
            System.out.println("Student Not Found");
        } else {
        	
            s.setName(name);
            s.setMarks(mark);
            session.update(s);
            System.out.println("Student updated Successfully");
        }

        txt.commit(); 
        session.close(); 
    }

	@Override
	public void searchbyroll(int roll) {
		
		Session session = factory.openSession();
		Student rs = session.get(Student.class, roll);
		if (rs != null) {
            System.out.println(rs.toString());
        } else {
            System.out.println("Not Found");
        }
	}
	
	 public void ShowData() {
			
			
		Session session=factory.openSession();
		Query<Student>  query= session.createQuery("from Student");	
		List<Student> students=	 query.list();
	 
		for(Student s : students )	
		{
			System.out.println(s.toString());
			
		}
		
			
	}

	@Override
	public void searchname(String name) {

		Session session = factory.openSession();
	    Query<Student> query = session.createQuery("from Student");
	    List<Student> students = query.list();

	    boolean found = false;

	    for (Student s : students) {
	        if (s.getName().equals(name)) {  
	            System.out.println(s.toString());
	            found = true;
	        }
	    }

	    if (!found) {
	        System.out.println("No student found");
	    }

	    
		
		
	}
	 
	 
		
}



