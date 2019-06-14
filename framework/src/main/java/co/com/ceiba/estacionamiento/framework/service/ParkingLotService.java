package co.com.ceiba.estacionamiento.framework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.estacionamiento.framework.adapter.entity.EntityTicket;
import co.com.ceiba.estacionamiento.framework.adapter.repository.EntityTicketRepositoryData;

@Service
public class ParkingLotService {
	
	@Autowired
	private EntityTicketRepositoryData ticketRepository;
	
    public EntityTicket save(EntityTicket entityTicket) {
    	return ticketRepository.save(entityTicket);
    }

    public Iterable<EntityTicket> findAll() {
    	return ticketRepository.findAll();
    }
}
