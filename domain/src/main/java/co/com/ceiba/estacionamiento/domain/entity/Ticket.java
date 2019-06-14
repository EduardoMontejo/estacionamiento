package co.com.ceiba.estacionamiento.domain.entity;

import java.time.LocalDateTime;

public class Ticket {
	
	private int id;
	private LocalDateTime admissionDate;
	private LocalDateTime departureDate;
	private Vehicle vehicle;
	private int value;
			
	public Ticket() {
		
	}
	
	public Ticket(LocalDateTime admissionDate) {
		super();
		this.admissionDate = admissionDate;
	}
	
	public Ticket(LocalDateTime admissionDate, Vehicle vehicle) {
		super();
		this.admissionDate = admissionDate;
		this.vehicle = vehicle;
	}

	public Ticket(int id, LocalDateTime admissionDate, LocalDateTime departureDate, Vehicle vehicle, int value) {
		super();
		this.id = id;
		this.admissionDate = admissionDate;
		this.departureDate = departureDate;
		this.vehicle = vehicle;
		this.value = value;
	}
	
	public Ticket(int id, LocalDateTime admissionDate, Vehicle vehicle) {
		super();
		this.id = id;
		this.admissionDate = admissionDate;
		this.vehicle = vehicle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(LocalDateTime admissionDate) {
		this.admissionDate = admissionDate;
	}

	public LocalDateTime getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate;
	}
		
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
