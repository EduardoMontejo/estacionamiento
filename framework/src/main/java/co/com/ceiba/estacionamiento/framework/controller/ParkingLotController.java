package co.com.ceiba.estacionamiento.framework.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.estacionamiento.application.command.RegisterVehicleEntryHandler;
import co.com.ceiba.estacionamiento.application.command.VehicleCommand;
import co.com.ceiba.estacionamiento.domain.entity.Ticket;

@RestController
@RequestMapping("/estacionamiento")
public class ParkingLotController {
	
	private final RegisterVehicleEntryHandler registerVehicleEntryHandler;

	public ParkingLotController(RegisterVehicleEntryHandler registerVehicleEntryHandler) {
		this.registerVehicleEntryHandler = registerVehicleEntryHandler;
	}
	
	@PostMapping("/tickets")
	public ResponseEntity<?> registerVehicleEntry(@RequestBody VehicleCommand vehicleCommand) {
		Ticket newTicket = this.registerVehicleEntryHandler.handle(vehicleCommand);
		return new ResponseEntity<Ticket>(newTicket, HttpStatus.CREATED);
	}
}
