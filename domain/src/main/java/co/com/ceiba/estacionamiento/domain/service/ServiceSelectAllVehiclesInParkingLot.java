package co.com.ceiba.estacionamiento.domain.service;

import java.util.Collection;

import co.com.ceiba.estacionamiento.domain.entity.Ticket;
import co.com.ceiba.estacionamiento.domain.port.ParkingLotRepository;

public class ServiceSelectAllVehiclesInParkingLot {

		private final ParkingLotRepository repository;

		public ServiceSelectAllVehiclesInParkingLot(ParkingLotRepository repository) {
			this.repository = repository;
		}
		
		public Collection<Ticket> findVehiclesInParkingLot() {
			return this.repository.findVehiclesInParkingLot();
		}
		
}
