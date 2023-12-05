import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtil {
    private static SessionFactory sessionFactory = null;

    private SessionUtil() {
    }

    public static SessionFactory getSessionFactory() {
        if(sessionFactory != null)
                return sessionFactory;
        else {
            sessionFactory = new Configuration()
                    .configure()
                    .addAnnotatedClass(Users.class)
                    .buildSessionFactory();
            return sessionFactory;
        }
    }
}
