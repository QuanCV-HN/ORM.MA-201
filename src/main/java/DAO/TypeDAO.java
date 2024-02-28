package DAO;

import fa.training.entities.Type;

import java.util.List;

public interface TypeDAO {
    Type create(Type type);

    List<Type> readALl();

    Type readById(Integer id);

    void update(Type type);

    void delete(Integer id);
}
