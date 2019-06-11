package co.com.ceiba.estacionamiento.domain.entity;

public class Vehicle {
	
	private String plate;
	private String brand;
	private String model;
	private String year;
		
	public Vehicle() {

	}

	public Vehicle(String plate, String brand, String model, String year) {
		this.plate = plate;
		this.brand = brand;
		this.model = model;
		this.year = year;
	}
	
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	
}
