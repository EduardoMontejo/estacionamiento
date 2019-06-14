package co.com.ceiba.estacionamiento.application.command;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import co.com.ceiba.estacionamiento.domain.entity.Ticket;
import co.com.ceiba.estacionamiento.domain.entity.Vehicle;
import co.com.ceiba.estacionamiento.domain.port.ParkingLotRepository;

@Component
public class RegisterVehicleEntryHandler {
	
	private final ParkingLotRepository repository;
	
	public RegisterVehicleEntryHandler(ParkingLotRepository repository) {
		this.repository = repository;
	}

	public Ticket handle(VehicleCommand vehicleCommand) {
		Vehicle newVehicle = new Vehicle(vehicleCommand.getPlate(), vehicleCommand.getEngineDisplacement(), vehicleCommand.getTypeVehicle());
		return this.repository.registerVehicleEntry(new Ticket(LocalDateTime.now(), newVehicle));
	}
}
