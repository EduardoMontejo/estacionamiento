package co.com.ceiba.estacionamiento.domain.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Component;

import co.com.ceiba.estacionamiento.domain.entity.Ticket;
import co.com.ceiba.estacionamiento.domain.port.ParkingLotRepository;

@Component
public class ServiceRegisterVehicleExit {
	public static final int PRICE_HOUR_MOTORCYCLE = 500;
	public static final int PRICE_HOUR_CAR = 1000;
	public static final int PRICE_DAY_MOTORCYCLE = 4000;
	public static final int PRICE_DAY_CAR = 8000;
	
	private final ParkingLotRepository repository;
	
	public ServiceRegisterVehicleExit(ParkingLotRepository repository) {
		this.repository = repository;
	}
	
	public Ticket registerVehicleExit(Integer id) {
		Ticket ticketEntry = this.repository.findById(id);
		ticketEntry.setDepartureDate(LocalDateTime.now());
		ticketEntry.setValue(calculateValueTicket(ticketEntry));
		return this.repository.registerVehicleExit(ticketEntry);
	}
	
	public int calculateValueTicket(Ticket ticket) {
		boolean isMotorcycle = "moto".equalsIgnoreCase(ticket.getVehicle().getTypeVehicle());
		int priceDay = isMotorcycle ? PRICE_DAY_MOTORCYCLE : PRICE_DAY_CAR;
		int priceHour = isMotorcycle ? PRICE_HOUR_MOTORCYCLE : PRICE_HOUR_CAR;
		
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
    	
        return value != 0 && isMotorcycle && ticket.getVehicle().getEngineDisplacement() > 500 ? 
        		value + 2000 : value;
	}	
}
