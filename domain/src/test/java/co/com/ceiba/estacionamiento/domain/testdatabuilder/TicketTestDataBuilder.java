package co.com.ceiba.estacionamiento.domain.testdatabuilder;

import java.time.LocalDateTime;

import co.com.ceiba.estacionamiento.domain.entity.Ticket;
import co.com.ceiba.estacionamiento.domain.entity.Vehicle;

public class TicketTestDataBuilder {
	private LocalDateTime admissionDate;
	private Vehicle vehicle;
	
	public TicketTestDataBuilder() {
		this.admissionDate = LocalDateTime.now();
		this.vehicle = null;
	}
	
	public TicketTestDataBuilder withAdmissionDate(LocalDateTime admissionDate) {
		this.admissionDate = admissionDate;
		return this;
	}
	
	public TicketTestDataBuilder withVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
		return this;
	}
	
	public Ticket build() {
		return new Ticket(admissionDate, vehicle);
	}
}
