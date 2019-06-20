package co.com.ceiba.estacionamiento.domain.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.stereotype.Component;

import co.com.ceiba.estacionamiento.domain.entity.Ticket;
import co.com.ceiba.estacionamiento.domain.entity.Vehicle;
import co.com.ceiba.estacionamiento.domain.exception.ParkingLotException;
import co.com.ceiba.estacionamiento.domain.port.ParkingLotRepository;

@Component
public class ServiceRegisterVehicleEntry {
	
	public static final String PARKING_WITHOUT_SPACE = "No hay cupo en el parqueadero";
	public static final String UNAUTHORIZED_ENTRY = "No puede ingresar porque no está en un dia hábil";
	public static final int MAXIMUM_NUMBER_OF_CARS = 20;
	public static final int MAXIMUM_NUMBER_OF_MOTORCYCLES = 10;
	
	private final ParkingLotRepository repository;
	
	public ServiceRegisterVehicleEntry(ParkingLotRepository repository) {
		this.repository = repository;
	}
	
	public Ticket registerVehicleEntry(Vehicle vehicle) {
		int dayOfTheWeek = LocalDate.now().getDayOfWeek().getValue();
		
		if(!(dayOfTheWeek == 1 || dayOfTheWeek == 7) && 
				('a' == vehicle.getPlate().toLowerCase().charAt(0))) {
			throw new ParkingLotException(UNAUTHORIZED_ENTRY);			
		} else if("moto".equalsIgnoreCase(vehicle.getTypeVehicle()) ? 
					this.countVehicles("moto") == MAXIMUM_NUMBER_OF_MOTORCYCLES :
						this.countVehicles("carro") == MAXIMUM_NUMBER_OF_CARS) {
			throw new ParkingLotException(PARKING_WITHOUT_SPACE);
		} else {
			return this.repository.registerVehicleEntry(new Ticket(LocalDateTime.now(), vehicle));
		}		
	}
	
	public int countVehicles(String typeVehicle) {
		Collection<Ticket> vehiclesInParkingLot = this.repository.findVehiclesInParkingLot();
		int count = 0;
		
		for(Ticket ticket: vehiclesInParkingLot) {
			if(typeVehicle.equalsIgnoreCase(ticket.getVehicle().getTypeVehicle())) {
				count++;
				}
		}
		return count;
	}
}
