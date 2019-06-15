package co.com.ceiba.estacionamiento.domain.service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.regex.Pattern;

import co.com.ceiba.estacionamiento.domain.entity.ParkingLot;
import co.com.ceiba.estacionamiento.domain.entity.Ticket;
import co.com.ceiba.estacionamiento.domain.entity.Vehicle;
import co.com.ceiba.estacionamiento.domain.exception.ParkingLotException;
import co.com.ceiba.estacionamiento.domain.port.ParkingLotRepository;

public class ServiceRegisterVehicleEntry {
	
	public static final String PARKING_WITHOUT_SPACE = "No hay cupo en el parqueadero";
	public static final String UNAUTHORIZED_ENTRY = "No esta autorizado a ingresar";
	private final ParkingLot parkingLot;
	private final ParkingLotRepository repository;

	public ServiceRegisterVehicleEntry(ParkingLot parkingLot, ParkingLotRepository repository) {
		this.parkingLot = parkingLot;
		this.repository = repository;
	}
	
	public Ticket registerVehicleEntry(Vehicle vehicle) {
		
		if(this.initialLetterPlate(vehicle.getPlate())) {
			throw new ParkingLotException(UNAUTHORIZED_ENTRY);			
		} else if(this.validateMaximumCapacity(vehicle.getTypeVehicle())) {
			throw new ParkingLotException(PARKING_WITHOUT_SPACE);
		} else {
			return this.repository.registerVehicleEntry(new Ticket(LocalDateTime.now(), vehicle));
		}		
	}

	public boolean initialLetterPlate(String plate) {
		//regular expression
		String regex = "^A";
		Pattern r = Pattern.compile(regex);
		
		return r.matches(regex, plate);
	}
	
	public boolean validateMaximumCapacity(String typeVehicle) {
		this.toLoadPakingLot();
		return typeVehicle.equals("moto") ? 
				this.parkingLot.getNumMotorcycles() == ParkingLot.MAXIMUM_NUMBER_OF_MOTORCYCLES :
					this.parkingLot.getNumCars() == ParkingLot.MAXIMUM_NUMBER_OF_CARS;
	}
	
	public void toLoadPakingLot() {
		Collection<Ticket> vehiclesInParkingLot = this.repository.findVehiclesInParkingLot();
				
		vehiclesInParkingLot.forEach(ticket -> {
				if(ticket.getVehicle().getTypeVehicle().equals("moto")) {
					this.parkingLot.setNumMotorcycles(this.parkingLot.getNumMotorcycles() + 1);
				} else {
					this.parkingLot.setNumCars(this.parkingLot.getNumCars() + 1);
				}
			});
	}
}
