package daos;

import Main.Database;
import com.mysql.cj.x.protobuf.MysqlxPrepare;
import com.mysql.cj.xdevapi.DatabaseObject;
import com.sun.jdi.request.ClassPrepareRequest;
import models.Car;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAOClass implements CarDAO{
  // CRUD - Retrieve
  @Override
  public Car get(Integer id) throws SQLException {
    Connection con = Database.getConnection();
      Car car = null;

      String sql = "SELECT id, make, model, year, color, vin FROM car WHERE id = ?";

    PreparedStatement ps = con.prepareStatement(sql);

    ps.setInt(1, id);

    ResultSet rs = ps.executeQuery();

    if (rs.next()) {
      int oid = rs.getInt("id");
      String make = rs.getString("make");
      String model = rs.getString("model");
      int year = rs.getInt("year");
      String color = rs.getString("color");
      String vin = rs.getString("vin");

      car = new Car(oid, make, model, year, color, vin);
    }
    return car;
  }

  @Override
  public List<Car> getAll() throws SQLException {
    List<Car> cars = new ArrayList<>();
    Connection con = Database.getConnection();

    String sql = "SELECT * FROM car";

    PreparedStatement ps = con.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();

    while(rs.next()) {
      for (int i = 0; i < rs.getFetchSize(); i++) {
        // this is when I would add each car at i but I'm not sure how to do it yet
      }
    }
    return cars;
  }

  @Override
  public Integer save(Car car) throws SQLException { // save == insert basically but i'm leaving this here for future reference
    return null;
  }

  @Override
  public Integer insert(Car car) throws SQLException {
    Connection con = Database.getConnection();

    String sql = "INSERT INTO car (id, make, model, year, color, vin) VALUES (?, ?, ?, ?, ?, ?)";

    PreparedStatement ps = con.prepareStatement(sql);

    ps.setInt(1, car.getId());
    ps.setString(2, car.getMake());
    ps.setString(3, car.getModel());
    ps.setInt(4, car.getYear());
    ps.setString(5, car.getColor());
    ps.setString(6, car.getVin());

    Integer result = ps.executeUpdate();

    Database.closePreparedStatement(ps);
    Database.closeConnection(con);

    return result;
  }

  @Override
  public Integer update(Car car) throws SQLException {
    Connection con = Database.getConnection();

    String sql = "UPDATE car set make = ?, model = ?, year = ?, color = ?, vin = ? where id = ?";

    PreparedStatement ps = con.prepareStatement(sql);

    ps.setString(1, car.getMake());
    ps.setString(2, car.getModel());
    ps.setInt(3, car.getYear());
    ps.setString(4, car.getColor());
    ps.setString(5, car.getVin());
    ps.setInt(6, car.getId()); // this has to be last because we're searching by the id

    Integer result = ps.executeUpdate();

    Database.closePreparedStatement(ps);
    Database.closeConnection(con);

    return result;
  }

  @Override
  public Integer delete(Car car) throws SQLException {
    Connection con = Database.getConnection();

    String sql = "DELETE FROM car WHERE id = ?";

    PreparedStatement ps = con.prepareStatement(sql);
    ps.setInt(1, car.getId());

    Integer result = ps.executeUpdate();

    Database.closePreparedStatement(ps);
    Database.closeConnection(con);

    return result;
  }
}
