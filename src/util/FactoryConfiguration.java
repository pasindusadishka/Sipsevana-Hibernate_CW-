package util;


import entity.Programs;
import entity.Registration;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import java.io.IOException;
import java.util.Properties;


/*public class FactoryConfiguration {
    private  static FactoryConfiguration factoryConfiguration;

    private static SessionFactory sessionFactory;

    private FactoryConfiguration(){
        Configuration configuration = new Configuration();

        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("application.properties"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        configuration.addAnnotatedClass(Programs.class);
        sessionFactory = configuration.setProperties(properties).buildSessionFactory();
    }

    public  static FactoryConfiguration getInstance(){
        if (factoryConfiguration == null){
            factoryConfiguration = new FactoryConfiguration();
        }
        return factoryConfiguration;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }

    *//*public  static FactoryConfiguration getInstance(){
        if (factoryConfiguration == null){
            factoryConfiguration = new FactoryConfiguration();
        }
        return factoryConfiguration;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }*//*

}*/

public class FactoryConfiguration {

    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {

            StandardServiceRegistry standardServiceRegistry =
                    new StandardServiceRegistryBuilder().loadProperties("application.properties").build();

            Metadata metadata = new MetadataSources(standardServiceRegistry)
                    .addAnnotatedClass(Student.class)
                    .addAnnotatedClass(Programs.class)
                    .addAnnotatedClass(Registration.class)
                    .getMetadataBuilder().build();
            return metadata.getSessionFactoryBuilder().build();
    }

    public static SessionFactory getInstance(){
        return sessionFactory;
    }


}

/*public class FactoryConfiguration {
   private static SessionFactory sessionFactory= createSession();

    private static SessionFactory createSession() {
        StandardServiceRegistry stg =
                new StandardServiceRegistryBuilder().loadProperties("application.properties").build();
        Metadata metadata=new MetadataSources(stg)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Programs.class)
                .getMetadataBuilder().build();

        return metadata.getSessionFactoryBuilder().build();
    }

    public static SessionFactory getInstance(){
        return sessionFactory;
    }
}*/
/*
* public class FactoryConfiguration {
    private static SessionFactory sessionFactory= createSession();

    private static SessionFactory createSession() {
        StandardServiceRegistry stg = new StandardServiceRegistryBuilder().loadProperties("hibernate.properties").build();
        Metadata metadata=new MetadataSources(stg)
                .addAnnotatedClass(Student.class).addAnnotatedClass(Parent.class).addAnnotatedClass(Program.class)
                .getMetadataBuilder().build();

        return metadata.getSessionFactoryBuilder().build();
    }

    public static SessionFactory getInstance(){
        return sessionFactory;
    }
}*/