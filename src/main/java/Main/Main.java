package Main;

import daos.CarDAOClass;
import models.Car;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
  public static void main(String[] args) throws SQLException {
//
//    Connection con = Database.getConnection();
//
//    if (con != null){
//      System.out.println("database connection successful!");

  CarDAOClass carDAOClass = new CarDAOClass();

  Car car = carDAOClass.get(1);

    System.out.println(car.toString());
  }
}
