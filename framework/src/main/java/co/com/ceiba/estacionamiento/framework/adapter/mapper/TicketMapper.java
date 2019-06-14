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
	
	public EntityTicket mapEntityTicket(Ticket ticket) {
		
		EntityTicket entityTicket = new EntityTicket(
										ticket.getVehicle().getPlate(),
										ticket.getVehicle().getTypeVehicle(),
										ticket.getVehicle().getEngineDisplacement(),
										ticket.getAdmissionDate());
		return entityTicket;
	}
	
	public Collection<Ticket> mapDomain(Iterable<EntityTicket> entityList) {
		
		List<Ticket> ticketsList = new ArrayList<>();
		
		entityList.forEach(entityTicket -> {
			Ticket ticket = new Ticket(entityTicket.getAdmissionDate(), 
									   new Vehicle(entityTicket.getPlate(), entityTicket.getEngineDisplacement(), entityTicket.getTypeVehicle()));
			
			ticketsList.add(ticket);
		});
		
		return ticketsList;
	}
	
	public Ticket mapDomain(EntityTicket entityTicket) {
		
		Vehicle vehicle = new Vehicle(entityTicket.getPlate(), entityTicket.getEngineDisplacement(), 
				entityTicket.getTypeVehicle());
        Ticket newTicket = new Ticket(entityTicket.getId(),
        		entityTicket.getAdmissionDate(), vehicle);
				
		return newTicket;
	}
}
