package co.com.ceiba.estacionamiento.application.command;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.stereotype.Component;

import co.com.ceiba.estacionamiento.domain.entity.ParkingLot;
import co.com.ceiba.estacionamiento.domain.entity.Ticket;
import co.com.ceiba.estacionamiento.domain.entity.Vehicle;
import co.com.ceiba.estacionamiento.domain.exception.ParkingLotException;
import co.com.ceiba.estacionamiento.domain.port.ParkingLotRepository;


@Component
public class RegisterVehicleEntryHandler {
	
	public static final String PARKING_WITHOUT_SPACE = "No hay cupo en el parqueadero";
	public static final String UNAUTHORIZED_ENTRY = "No puede ingresar porque no está en un dia hábil";
	
	private ParkingLot parkingLot;
	private final ParkingLotRepository repository;
	
	public RegisterVehicleEntryHandler(ParkingLotRepository repository) {
		this.parkingLot = new ParkingLot();
		this.repository = repository;
	}
	
	public Ticket handle(VehicleCommand vehicleCommand) {
		return this.registerVehicleEntry(new Vehicle(
				vehicleCommand.getPlateCommand(), vehicleCommand.getEngineDisplacementCommand(), 
				vehicleCommand.getTypeVehicleCommand()));
	}
	
	public Ticket registerVehicleEntry(Vehicle vehicle) {
		if(!validateDayOfTheWeek() && this.initialLetterPlate(vehicle.getPlate())) {
			throw new ParkingLotException(UNAUTHORIZED_ENTRY);			
		} else if(this.validateMaximumCapacity(vehicle.getTypeVehicle())) {
			throw new ParkingLotException(PARKING_WITHOUT_SPACE);
		} else {
			return this.repository.registerVehicleEntry(new Ticket(LocalDateTime.now(), vehicle));
		}		
	}
	
	public boolean initialLetterPlate(String plate) {
		return 'a' == plate.toLowerCase().charAt(0);
	}
	
	public boolean validateDayOfTheWeek() {
		int dayOfTheWeek = LocalDate.now().getDayOfWeek().getValue();
		return dayOfTheWeek == 1 || dayOfTheWeek == 7;
	}
	
	public boolean validateMaximumCapacity(String typeVehicle) {
		this.toLoadPakingLot();
		return "moto".equalsIgnoreCase(typeVehicle) ? 
				this.parkingLot.getNumMotorcycles() == ParkingLot.MAXIMUM_NUMBER_OF_MOTORCYCLES :
					this.parkingLot.getNumCars() == ParkingLot.MAXIMUM_NUMBER_OF_CARS;
	}
	
	public void toLoadPakingLot() {
		Collection<Ticket> vehiclesInParkingLot = this.repository.findVehiclesInParkingLot();
		
		vehiclesInParkingLot.forEach(ticket -> {
				if("moto".equals(ticket.getVehicle().getTypeVehicle())) {
					this.parkingLot.setNumMotorcycles(this.parkingLot.getNumMotorcycles() + 1);
				} else {
					this.parkingLot.setNumCars(this.parkingLot.getNumCars() + 1);
				}
			});
	}
}
