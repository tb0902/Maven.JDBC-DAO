package models;

public class Car {
  private Integer id;
  private String make;
  private String model;
  private Integer year;
  private String color;
  private String vin;

  public Car() {
  }

  public Car(Integer id, String make, String model, Integer year, String color, String vin) {
    this.id = id;
    this.make = make;
    this.model = model;
    this.year = year;
    this.color = color;
    this.vin = vin;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getVin() {
    return vin;
  }

  public void setVin(String vin) {
    this.vin = vin;
  }
}
