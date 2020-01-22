package hibernate.demo;

import hibernate.Instructor;
import hibernate.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            Instructor tempInstruction = new Instructor("Lukas", "Pastorek", "luky@puky.com");

            InstructorDetail tempInstructorDetail = new InstructorDetail("StompIt", "skiing");

            tempInstruction.setInstructorDetail(tempInstructorDetail);

            session.beginTransaction();

            System.out.println("saving instructor: " + tempInstruction);
            session.save(tempInstruction);

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }

    }
}