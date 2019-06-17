package co.com.ceiba.estacionamiento.application.command;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Component;

import co.com.ceiba.estacionamiento.domain.entity.ParkingLot;
import co.com.ceiba.estacionamiento.domain.entity.Ticket;
import co.com.ceiba.estacionamiento.domain.exception.ParkingLotException;
import co.com.ceiba.estacionamiento.domain.port.ParkingLotRepository;

@Component
public class RegisterVehicleExitHandler {

//	private final ServiceRegisterVehicleExit serviceRegisterExit;
//	
//	public RegisterVehicleExitHandler(ServiceRegisterVehicleExit serviceRegisterExit) {
//		this.serviceRegisterExit = serviceRegisterExit;
//	}
//
//	public Ticket handle(Integer id) {
//		return this.serviceRegisterExit.registerVehicleExit(id);
//	}
	
//	LOGICA EN EL SERVICIO DEL DOMINIO
	
	public static final String TICKET_DOES_NOT_EXIST = "El ticket no existe";
	private final ParkingLotRepository repository;
	
	public RegisterVehicleExitHandler(ParkingLotRepository repository) {
		this.repository = repository;
	}
	
	public Ticket handle(Integer id) {
		return this.registerVehicleExit(id);
	}
	
	public Ticket registerVehicleExit(Integer id) {
		Ticket ticketEntry = this.repository.findById(id);
		
		if(ticketEntry.getAdmissionDate() == null) {
			throw new ParkingLotException(TICKET_DOES_NOT_EXIST);
		} else {
			ticketEntry.setDepartureDate(LocalDateTime.now());
			ticketEntry.setValue(calculateValueTicket(ticketEntry));
			
			return this.repository.registerVehicleExit(ticketEntry);
		}
	}
	
	public int calculateValueTicket(Ticket ticket) {
		boolean isMotorcycle = ticket.getVehicle().getTypeVehicle().toLowerCase().equals("moto");
		int priceDay = isMotorcycle ? ParkingLot.PRICE_DAY_MOTORCYCLE : ParkingLot.PRICE_DAY_CAR;
		int priceHour = isMotorcycle ? ParkingLot.PRICE_HOUR_MOTORCYCLE : ParkingLot.PRICE_HOUR_CAR;
		
        int differenceHours = (int)ChronoUnit.HOURS.between(ticket.getAdmissionDate(), ticket.getDepartureDate());
       
        int numOfDays = differenceHours / 24;
        int value = 0;
        
    	if(numOfDays > 0) {
    		value = priceDay * numOfDays;
    		differenceHours -= 24 * numOfDays;
    	}  	
    	
    	if(differenceHours > 8 && differenceHours < 24) {
    		value += priceDay;
    	} else {
    		value += differenceHours * priceHour;
        }	
    	
        return isMotorcycle && ticket.getVehicle().getEngineDisplacement() > 500 ? value + 2000 : value;
	}	
}
