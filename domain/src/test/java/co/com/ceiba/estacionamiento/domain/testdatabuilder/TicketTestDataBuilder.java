package co.com.ceiba.estacionamiento.domain.testdatabuilder;

import java.time.LocalDateTime;

import co.com.ceiba.estacionamiento.domain.entity.Ticket;
import co.com.ceiba.estacionamiento.domain.entity.Vehicle;

public class TicketTestDataBuilder {
	private int id;
	private LocalDateTime admissionDate;
	private LocalDateTime departureDate;
	private Vehicle vehicle;
	private int value;
	
	public TicketTestDataBuilder() {
		this.id = 1;
		this.admissionDate = LocalDateTime.now();
		this.departureDate = LocalDateTime.now();
		this.vehicle = null;
		this.value = 0;
	}
	
	public TicketTestDataBuilder withId(int id) {
		this.id = id;
		return this;
	}
	
	public TicketTestDataBuilder withAdmissionDate(LocalDateTime admissionDate) {
		this.admissionDate = admissionDate;
		return this;
	}
	
	public TicketTestDataBuilder withDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate;
		return this;
	} 
	
	public TicketTestDataBuilder withVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
		return this;
	}
	
	public TicketTestDataBuilder withValue(int value) {
		this.value = value;
		return this;
	}	
	
	public Ticket build() {
		return new Ticket(id, admissionDate, departureDate, vehicle, value);
	}
}
