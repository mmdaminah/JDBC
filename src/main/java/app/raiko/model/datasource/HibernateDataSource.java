package app.raiko.model.datasource;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Objects;

public class HibernateDataSource implements DataSource<SessionFactory> {
    public static SessionFactory sessionFactory;

    @Override
    public SessionFactory connect() {
        if( Objects.nonNull(sessionFactory))
            return sessionFactory;
        final var registry = new StandardServiceRegistryBuilder().configure().build();
        try{
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            return sessionFactory;
        }
        catch (Exception e){
            StandardServiceRegistryBuilder.destroy( registry );
            throw new RuntimeException("Failed to connect to the database!");
        }
    }
}
