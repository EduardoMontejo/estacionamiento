package co.com.ceiba.estacionamiento.application.command;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import co.com.ceiba.estacionamiento.domain.entity.Ticket;
import co.com.ceiba.estacionamiento.domain.entity.Vehicle;
import co.com.ceiba.estacionamiento.domain.service.ServiceRegisterVehicleEntry;

@Component
@ComponentScan("co.com.ceiba.estacionamiento")
public class RegisterVehicleEntryHandler {
	private final ServiceRegisterVehicleEntry serviceRegisterVehicleEntry;
	
	public RegisterVehicleEntryHandler(ServiceRegisterVehicleEntry serviceRegisterVehicleEntry) {
		this.serviceRegisterVehicleEntry = serviceRegisterVehicleEntry;
	}

	public Ticket handle(VehicleCommand vehicleCommand) {
		return this.serviceRegisterVehicleEntry.registerVehicleEntry(new Vehicle(
				vehicleCommand.getPlateCommand(), vehicleCommand.getEngineDisplacementCommand(), 
				vehicleCommand.getTypeVehicleCommand()));
	}
}
