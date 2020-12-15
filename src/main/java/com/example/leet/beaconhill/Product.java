package com.example.leet.beaconhill;

public class Product {
  private int id;
  private String name;
  private int updated_at;
  private int price;
  private String manufacturer;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getUpdated_at() {
    return updated_at;
  }

  public void setUpdate_at(int updated_at) {
    this.updated_at = updated_at;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }
}
