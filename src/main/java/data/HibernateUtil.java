package data;

import entity.AccountType;
import entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

/**
 * Created by USER on 2017-12-05.
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();

            configuration.addAnnotatedClass(User.class);

            return configuration
					.buildSessionFactory(new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build());


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
