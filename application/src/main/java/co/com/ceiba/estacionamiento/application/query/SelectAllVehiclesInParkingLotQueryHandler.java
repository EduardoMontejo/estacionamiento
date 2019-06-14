package co.com.ceiba.estacionamiento.application.query;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ceiba.estacionamiento.domain.entity.Ticket;
import co.com.ceiba.estacionamiento.domain.port.ParkingLotRepository;

@Component
public class SelectAllVehiclesInParkingLotQueryHandler {
	
	@Autowired
	private ParkingLotRepository repository;

	//dentro de application se usan entidades o commands? ejm: vehicleCommand
	public Collection<Ticket> handle() {
		return repository.findVehiclesInParkingLot();
	}
}
