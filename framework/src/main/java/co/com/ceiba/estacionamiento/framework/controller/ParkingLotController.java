package co.com.ceiba.estacionamiento.framework.controller;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.estacionamiento.application.command.RegisterVehicleEntryHandler;
import co.com.ceiba.estacionamiento.application.command.RegisterVehicleExitHandler;
import co.com.ceiba.estacionamiento.application.command.VehicleCommand;
import co.com.ceiba.estacionamiento.application.query.SelectAllVehiclesInParkingLotQueryHandler;
import co.com.ceiba.estacionamiento.domain.entity.Ticket;

@RestController
@RequestMapping("/estacionamiento")
@CrossOrigin("*")
public class ParkingLotController {

	private final RegisterVehicleEntryHandler registerVehicleEntryHandler;
	private final SelectAllVehiclesInParkingLotQueryHandler selectAllVehiclesInParkingLotQueryHandler;
	private final RegisterVehicleExitHandler registerVehicleExitHandler;
		
	public ParkingLotController(RegisterVehicleEntryHandler registerVehicleEntryHandler,
			SelectAllVehiclesInParkingLotQueryHandler selectAllVehiclesInParkingLotQueryHandler,
			RegisterVehicleExitHandler registerVehicleExitHandler) {
		this.registerVehicleEntryHandler = registerVehicleEntryHandler;
		this.selectAllVehiclesInParkingLotQueryHandler = selectAllVehiclesInParkingLotQueryHandler;
		this.registerVehicleExitHandler = registerVehicleExitHandler;
	}
	
	@PostMapping("/tickets")
	public ResponseEntity<Ticket> registerVehicleEntry(@RequestBody VehicleCommand vehicleCommand) {
		return new ResponseEntity<>(this.registerVehicleEntryHandler.handle(vehicleCommand), HttpStatus.CREATED);
	}
	
	@GetMapping("/tickets")
	public Collection<Ticket> selectAllVehiclesInParkingLot(){
		return this.selectAllVehiclesInParkingLotQueryHandler.handle();
	}
	
	@PatchMapping("/tickets/{id}")
	public ResponseEntity<Ticket> registerVehicleEntry(@PathVariable Integer id) {
		return new ResponseEntity<>(this.registerVehicleExitHandler.handle(id), HttpStatus.CREATED);
	}
}
