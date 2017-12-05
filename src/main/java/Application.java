import data.HibernateUtil;
import entity.AccountType;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.Properties;

/**
 * Created by USER on 2017-12-05.
 */
public class Application {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        User user = new User();
        user.setBirthDate(null);
        user.setCreatedBy("kevin");
        user.setCreatedDate(new Date());
        user.setEmailAddress("kim@yahoo.com");
        user.setFirstName("kevin");
        user.setLastName("Bowersox");
        user.setLastUpdatedBy("kevin");
        user.setLastUpdatedDate(new Date());

        session.save(user);
        session.getTransaction().commit();

        session.beginTransaction();
        User dbUser = (User)session.get(User.class, user.getUserId());
        dbUser.setFirstName("Joe");
        session.update(dbUser);

        session.getTransaction().commit();
        session.close();
    }
}
