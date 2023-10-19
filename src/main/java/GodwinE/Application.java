package GodwinE;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4d12");
    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();

        try {


        }catch (Exception ex)
        {
            System.err.println(ex.getMessage());
        }finally {
            em.close();
            emf.close();
        }
    }
}
