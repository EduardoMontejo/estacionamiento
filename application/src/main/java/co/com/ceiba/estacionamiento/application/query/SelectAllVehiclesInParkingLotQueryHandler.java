package co.com.ceiba.estacionamiento.application.query;

import java.util.Collection;

import org.springframework.stereotype.Component;

import co.com.ceiba.estacionamiento.domain.entity.Ticket;
import co.com.ceiba.estacionamiento.domain.port.ParkingLotRepository;

@Component
public class SelectAllVehiclesInParkingLotQueryHandler {
	
//	private final ServiceSelectAllVehiclesInParkingLot serviceSelectAllVehiclesInParkingLot;
//	
//	public SelectAllVehiclesInParkingLotQueryHandler(ServiceSelectAllVehiclesInParkingLot serviceSelectAllVehiclesInParkingLot) {
//		this.serviceSelectAllVehiclesInParkingLot = serviceSelectAllVehiclesInParkingLot;
//	}
//
//	public Collection<Ticket> handle() {
//		return serviceSelectAllVehiclesInParkingLot.findVehiclesInParkingLot();
//	}
	
//	LOGICA EN EL SERVICIO DEL DOMINIO
	
	private final ParkingLotRepository repository;

	public SelectAllVehiclesInParkingLotQueryHandler(ParkingLotRepository repository) {
		this.repository = repository;
	}
	
	public Collection<Ticket> handle() {
		return this.findVehiclesInParkingLot();
	}
	
	public Collection<Ticket> findVehiclesInParkingLot() {
		return this.repository.findVehiclesInParkingLot();
	}
}
