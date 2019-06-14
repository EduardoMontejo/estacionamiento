package co.com.ceiba.estacionamiento.framework.adapter.repository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ceiba.estacionamiento.domain.entity.Ticket;
import co.com.ceiba.estacionamiento.domain.port.ParkingLotRepository;
import co.com.ceiba.estacionamiento.framework.adapter.entity.EntityTicket;
import co.com.ceiba.estacionamiento.framework.adapter.mapper.TicketMapper;

@Component
public class EntityTicketRepositoryH2 implements ParkingLotRepository{
	
	@Autowired
	private TicketMapper ticketMapper;
	
	@Autowired
	private EntityTicketRepositoryData entityTicketRepositoryData;
	
	@Override
	public Ticket registerVehicleEntry(Ticket ticket) {
		this.entityTicketRepositoryData.save(this.ticketMapper.mapEntityTicket(ticket));
		return ticket;
	}
	
	@Override
	public Collection<Ticket> findVehiclesInParkingLot() {
		return this.ticketMapper.mapDomain(entityTicketRepositoryData.findAll());
	}
	
	@Override
	public Ticket findById(int id) {		
		return this.ticketMapper.mapDomain(
				this.entityTicketRepositoryData.findById(id).orElse(
						new EntityTicket()));
	} 
	
//	public Ticket registerVehicleExit(Ticket ticket) {
//		
//	}
}
