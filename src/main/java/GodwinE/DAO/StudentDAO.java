package GodwinE.DAO;

import GodwinE.entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.UUID;

public class StudentDAO {

    private final EntityManager em;

    public StudentDAO(EntityManager em)
    {
        this.em = em;
    }

    public void save(Student student){
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(student);

        transaction.commit();
        System.out.println("Student saved");
    }

    public Student findById(UUID id) {
        return em.find(Student.class, id);
    }

    public void findByIdAndDelete(UUID id)
    {
        Student found = em.find(Student.class, id);
        if(found != null)
        {
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(found);

            transaction.commit();
            System.out.println("The student has been deleted");
        }else {
            System.out.println("the student with " + id + " was not found");
        }
    }
}
