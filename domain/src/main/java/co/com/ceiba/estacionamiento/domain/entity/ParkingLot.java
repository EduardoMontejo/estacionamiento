package co.com.ceiba.estacionamiento.domain.entity;

public class ParkingLot {
	
	private String nit;
	private String name;
	
	public ParkingLot() {
		
	}

	public ParkingLot(String nit, String name) {
		this.name = name;
	}
		
	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
}
