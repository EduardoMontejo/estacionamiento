package co.com.ceiba.estacionamiento.framework.adapter.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.ceiba.estacionamiento.framework.adapter.entity.EntityTicket;

@Repository
public interface EntityTicketRepositoryData extends CrudRepository<EntityTicket, Integer>{
	
	List<EntityTicket> findByDepartureDate(LocalDateTime date);
}
