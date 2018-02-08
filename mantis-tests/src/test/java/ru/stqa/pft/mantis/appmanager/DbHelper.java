package ru.stqa.pft.mantis.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stqa.pft.mantis.model.UserData;
import java.util.List;


public class DbHelper {
  private final SessionFactory sessionFactory;
  private final ApplicationManager app;

  public DbHelper(ApplicationManager app) {
    this.app = app;
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();

    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
  }

  public UserData findAnyUser(int except) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<UserData> result = session.createQuery("from UserData where id !=" +Integer.toString(except)).list();
    UserData user = result.iterator().next();
    session.getTransaction().commit();
    session.close();
    return user;
  }

}