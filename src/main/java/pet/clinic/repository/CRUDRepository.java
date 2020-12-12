package pet.clinic.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pet.clinic.utils.HibernateUtils;

import java.util.List;

public class CRUDRepository<T> implements Repository<T> {

    private final Class<T> entityClass;

    public CRUDRepository(Class<T> entityClass) {

        this.entityClass = entityClass;
    }

    public List<T> getAll() {

        Session session = HibernateUtils.getSessionFactory().openSession();

        String selectAllEntityHQL = "from " + entityClass.getSimpleName();

        Query<T> query = session.createQuery(selectAllEntityHQL, entityClass);

        List<T> resultList = query.getResultList();

        session.close();

        return resultList;
    }

    public T getById(Integer id) {

        Session session = HibernateUtils.getSessionFactory().openSession();

        T entity = session.find(entityClass, id);

        session.close();

        return entity;
    }

    public T save(T entity) {

        Session session = HibernateUtils.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();

        session.close();

        return entity;
    }

    public void delete(T entity) {

        Session session = HibernateUtils.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        session.delete(entity);

        transaction.commit();

        session.close();
    }

    public void update(T entity) {

        Session session = HibernateUtils.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();

        session.close();
    }

    public void deleteAll() {

        Session session = HibernateUtils.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        String hql = String.format("delete from %s",entityClass.getSimpleName());

        Query query = session.createQuery(hql);

        query.executeUpdate();

        transaction.commit();

        session.close();
    }
}
