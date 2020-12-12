package pet.clinic.repository;

import java.util.List;

public interface Repository<T> {

    List<T> getAll();

    T getById(Integer id);

    T save(T entity);

    void delete(T entity);

    void deleteAll();
}
