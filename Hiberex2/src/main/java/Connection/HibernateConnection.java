package Connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import Model.Student;

public class HibernateConnection {

    private static SessionFactory sessionFactory;

    private HibernateConnection() {
        sessionFactory = new Configuration()
            .configure("hibernet.xml")
            .addAnnotatedClass(Student.class)
            .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            new HibernateConnection();
        }
        return sessionFactory;
    }
}
