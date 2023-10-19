package GodwinE;

import GodwinE.DAO.StudentDAO;
import GodwinE.entities.Status;
import GodwinE.entities.Student;
import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Locale;
import java.util.UUID;
import java.util.function.Supplier;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("student_trial");
    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        Faker faker = new Faker(Locale.ITALY);
        Supplier<Student> studentSupplier = () -> new Student(faker.name().firstName(), faker.name().lastName(), Status.ACTIVE);

        try {

            StudentDAO sd = new StudentDAO(em);
            System.out.println("working");


            for (int i = 0; i < 50; i++) {
               // sd.save(studentSupplier.get());
            }

            Student stud2 = sd.findById(UUID.fromString("02983e9f-6d23-4683-b862-a5589e61894d"));
            System.out.println(stud2);

            sd.findByIdAndDelete(UUID.fromString("02983e9f-6d23-4683-b862-a5589e61894d"));



        }catch (Exception ex)
        {
            System.err.println(ex.getMessage());
        }finally {
            em.close();
            emf.close();
        }
    }
}
