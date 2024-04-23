package daos;

import models.Car;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DAO<T> {
  T get(Integer id) throws SQLException;
  List<T> getAll() throws SQLException;
  Integer save(T t) throws SQLException;
  Integer insert(T t) throws SQLException;
  Integer update (T t) throws SQLException;
  Integer delete (T t) throws SQLException;

}
