package app.raiko.model.admin.dao;

import app.raiko.model.admin.domain.Admin;
import app.raiko.model.datasource.DataSource;
import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class AdminJpaDao implements AdminDao {
    private final DataSource<SessionFactory> dataSource;
    @Override
    public Optional<Admin> get(Integer id) {

        try(
                var sessionFactory = dataSource.connect();
                var session = sessionFactory.openSession()
        ){
            var query = session.createQuery("select admin from Admin admin where admin.id = :id",Admin.class);
            query.setParameter("id",id);
            return query.getResultStream().findFirst();
        }
    }

    @Override
    public List<Admin> getAll(Admin admin) {
        try(
            var sessionFactory = dataSource.connect();
            var session = sessionFactory.openSession()
        ){
            var query = session.createQuery("select admin from Admin admin",Admin.class);
            return query.getResultList();
        }
    }

    @Override
    public boolean update(Integer id, Admin admin) {
        return false;
    }

    @Override
    public Optional<Admin> login(String userName, String password) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        try(
                var sessionFactory = dataSource.connect();
                var session = sessionFactory.openSession()
        ){
            var query = session.createQuery("delete from Admin admin where admin.id = :id",Boolean.class);
            query.setParameter("id",id);
            return query.executeUpdate() > 0;
        }
    }

    @Override
    public boolean create(Admin admin) {
        return false;
    }

    @Override
    public boolean findSuperAdmin() {
        try(
                var sessionFactory = dataSource.connect();
                var session = sessionFactory.openSession()
        ){
            var query = session.createQuery("select admin from Admin admin where admin.superAdmin = true",Boolean.class);
            return (query.getResultStream().count() == 1);
        }
    }

    @Override
    public boolean createSuperAdmin(Admin admin) {
        return false;
    }

    @Override
    public void updatePassword(Integer id, String password) {

    }

    @Override
    public boolean usernameExits(String username) {
        try(
                var sessionFactory = dataSource.connect();
                var session = sessionFactory.openSession()
        ){
            var query = """
                    select 
                    case when count(admin) > 0 then true
                    else false
                    end
                    from Admin admin
                    where admin.username = :username
                    """;
            var createdQuery = session.createQuery(query,Boolean.class);
            createdQuery.setParameter("username",username);
            return createdQuery.getSingleResult();
        }
    }

    @Override
    public Admin getAdminByUsername(String username) {
        try(
                var sessionFactory = dataSource.connect();
                var session = sessionFactory.openSession()
        ){
            var query = session.createQuery("select admin from Admin admin where admin.username = :username",Admin.class);
            return query.getResultStream().findFirst().get();
        }
    }

    @Override
    public Admin getCreator(Admin admin, Integer creator) {
        return null;
    }
}
