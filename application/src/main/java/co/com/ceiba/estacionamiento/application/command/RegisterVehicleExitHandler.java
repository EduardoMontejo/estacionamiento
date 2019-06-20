package co.com.ceiba.estacionamiento.application.command;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import co.com.ceiba.estacionamiento.domain.entity.Ticket;
import co.com.ceiba.estacionamiento.domain.service.ServiceRegisterVehicleExit;

@Component
@ComponentScan("co.com.ceiba.estacionamiento")
public class RegisterVehicleExitHandler {
	private final ServiceRegisterVehicleExit serviceRegisterExit;
	
	public RegisterVehicleExitHandler(ServiceRegisterVehicleExit serviceRegisterExit) {
		this.serviceRegisterExit = serviceRegisterExit;
	}

	public Ticket handle(Integer id) {
		return this.serviceRegisterExit.registerVehicleExit(id);
	}
}
