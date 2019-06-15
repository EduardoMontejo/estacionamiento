package co.com.ceiba.estacionamiento.domain.service;

import java.time.LocalDateTime;

import co.com.ceiba.estacionamiento.domain.entity.Ticket;
import co.com.ceiba.estacionamiento.domain.port.ParkingLotRepository;

public class ServiceRegisterVehicleExit {
	
	private final ParkingLotRepository repository;
	
	public ServiceRegisterVehicleExit(ParkingLotRepository repository) {
		this.repository = repository;
	}
	
	public Ticket registerVehicleExit(Integer id) {
		Ticket ticketEntry = this.repository.findById(id);
		ticketEntry.setDepartureDate(LocalDateTime.now());
		ticketEntry.setValue(5000);
		return this.repository.registerVehicleExit(ticketEntry);
	}
	
	public int calculateValueTicket(Ticket ticket) {
		return 1;
	}
}
