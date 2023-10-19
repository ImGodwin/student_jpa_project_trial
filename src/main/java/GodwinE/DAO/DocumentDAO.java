package GodwinE.DAO;

import GodwinE.entities.Student;
import GodwinE.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.UUID;

public class DocumentDAO {

    private final EntityManager em;

    public UserDAO(EntityManager em)
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

    public User findById(UUID id) {
        return em.find(User.class, id);
    }

    public void findByIdAndDelete(UUID id)
    {
        User found = em.find(User.class, id);
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
