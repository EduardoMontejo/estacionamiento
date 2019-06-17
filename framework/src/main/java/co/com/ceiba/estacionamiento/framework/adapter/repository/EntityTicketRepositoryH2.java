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
	public Ticket registerVehicleEntry(Ticket ticketEntry) {
		return this.ticketMapper.mapDomain(this.entityTicketRepositoryData.save(this.ticketMapper.mapEntityTicketEntry(ticketEntry)));
	}
	
	@Override
	public Collection<Ticket> findVehiclesInParkingLot() {
		return this.ticketMapper.mapDomain(this.entityTicketRepositoryData.findByValue(0));
	}
	
	@Override
	public Ticket findById(Integer id) {		
		return this.ticketMapper.mapDomain(this.entityTicketRepositoryData.findById(id).orElse(new EntityTicket()));
	} 
	
	@Override
	public Ticket registerVehicleExit(Ticket ticket) {
		this.entityTicketRepositoryData.save(this.ticketMapper.mapEntityTicketExit(ticket));
		return ticket;
	}
}
