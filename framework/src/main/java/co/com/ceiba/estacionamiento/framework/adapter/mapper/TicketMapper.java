package co.com.ceiba.estacionamiento.framework.adapter.mapper;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import co.com.ceiba.estacionamiento.domain.entity.Ticket;
import co.com.ceiba.estacionamiento.domain.entity.Vehicle;
import co.com.ceiba.estacionamiento.framework.adapter.entity.EntityTicket;

@Component
public class TicketMapper {
	
	public TicketMapper() {
		
	}
	
	public EntityTicket mapEntityTicketEntry(Ticket ticket) {
		EntityTicket entityTicket = new EntityTicket(
										ticket.getVehicle().getPlate(),
										ticket.getVehicle().getTypeVehicle(),
										ticket.getVehicle().getEngineDisplacement(),
										ticket.getAdmissionDate());
		return entityTicket;
	}
	
	public EntityTicket mapEntityTicketExit(Ticket ticketEntry) {
		EntityTicket entityTicketExit = new EntityTicket(
											ticketEntry.getId(),											
											ticketEntry.getVehicle().getPlate(),
											ticketEntry.getVehicle().getTypeVehicle(),
											ticketEntry.getVehicle().getEngineDisplacement(),
											ticketEntry.getAdmissionDate(),
											ticketEntry.getDepartureDate(),
											ticketEntry.getValue());
		return entityTicketExit;
	}
	
	public Collection<Ticket> mapDomain(Iterable<EntityTicket> entityList) {
		List<Ticket> ticketsList = new ArrayList<>();
		entityList.forEach(entityTicket -> ticketsList.add(this.mapDomain(entityTicket)));
		
		return ticketsList;
	}
	
	public Ticket mapDomain(EntityTicket entityTicket) {
		Vehicle vehicle = new Vehicle(entityTicket.getPlate(), entityTicket.getEngineDisplacement(), 
				entityTicket.getTypeVehicle());
        Ticket ticketEntry = new Ticket(entityTicket.getAdmissionDate(), vehicle);
        ticketEntry.setId(entityTicket.getId());
				
		return ticketEntry;
	}
}
