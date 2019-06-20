package co.com.ceiba.estacionamiento.application.query;

import java.util.Collection;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import co.com.ceiba.estacionamiento.domain.entity.Ticket;
import co.com.ceiba.estacionamiento.domain.service.ServiceSelectAllVehiclesInParkingLot;

@Component
@ComponentScan("co.com.ceiba.estacionamiento")
public class SelectAllVehiclesInParkingLotQueryHandler {
	private final ServiceSelectAllVehiclesInParkingLot serviceSelectAllVehiclesInParkingLot;
	
	public SelectAllVehiclesInParkingLotQueryHandler(ServiceSelectAllVehiclesInParkingLot serviceSelectAllVehiclesInParkingLot) {
		this.serviceSelectAllVehiclesInParkingLot = serviceSelectAllVehiclesInParkingLot;
	}

	public Collection<Ticket> handle() {
		return serviceSelectAllVehiclesInParkingLot.findVehiclesInParkingLot();
	}
}
