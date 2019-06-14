package co.com.ceiba.estacionamiento.application.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ceiba.estacionamiento.domain.entity.Ticket;
import co.com.ceiba.estacionamiento.domain.port.ParkingLotRepository;

@Component
public class SelectTicketByIdQueryHandler {
	
	@Autowired
	private ParkingLotRepository repository;
	
	public Ticket handle(int id) {
		return this.repository.findById(id);
	}
}
