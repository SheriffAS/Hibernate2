package hibernate.demo;

import hibernate.Instructor;
import hibernate.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            int theId=1;

            Instructor tempInstruction = (Instructor) session.get(Instructor.class, theId);
            System.out.println("found instructor: " + tempInstruction);
            if (tempInstruction != null) {
                System.out.println("deleting: " + tempInstruction);
                session.delete(tempInstruction);
            }

            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }

    }

}