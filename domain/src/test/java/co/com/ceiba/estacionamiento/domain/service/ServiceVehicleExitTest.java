package co.com.ceiba.estacionamiento.domain.service;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;
import org.mockito.Mockito;

import co.com.ceiba.estacionamiento.domain.entity.Ticket;
import co.com.ceiba.estacionamiento.domain.entity.Vehicle;
import co.com.ceiba.estacionamiento.domain.port.ParkingLotRepository;
import co.com.ceiba.estacionamiento.domain.testdatabuilder.TicketTestDataBuilder;
import co.com.ceiba.estacionamiento.domain.testdatabuilder.VehicleTestDataBuilder;

public class ServiceVehicleExitTest {
	
	@Test
	public void calculateValueTicketCarOneDayAndThreeHours() {
		//arrange
		Vehicle vehicle = new VehicleTestDataBuilder().withPlate("WSN25C").withTypeVehicle("carro").build();
		Ticket ticket = new TicketTestDataBuilder().withVehicle(vehicle).build();
		ParkingLotRepository repository = Mockito.mock(ParkingLotRepository.class);
		ServiceRegisterVehicleExit service = new ServiceRegisterVehicleExit(repository);		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		String strEntry = "2019-06-20 05:40";
		LocalDateTime dateTimeEntry = LocalDateTime.parse(strEntry, formatter);
		
		String strExit = "2019-06-21 08:40";
		LocalDateTime dateTimeExit = LocalDateTime.parse(strExit, formatter);
				
		ticket.setAdmissionDate(dateTimeEntry);
		ticket.setDepartureDate(dateTimeExit);
		
		//act
		int value = service.calculateValueTicket(ticket);
		
		//assert
		assertTrue(11000 == value);
	}
	
	@Test
	public void calculateValueTicketMotoTenHoursAndHighEngine() {
		//arrange
		Vehicle vehicle = new VehicleTestDataBuilder().withPlate("WSN25C").withTypeVehicle("moto").withEngineDisplacement(700).build();
		Ticket ticket = new TicketTestDataBuilder().withVehicle(vehicle).build();
		ParkingLotRepository repository = Mockito.mock(ParkingLotRepository.class);
		ServiceRegisterVehicleExit service = new ServiceRegisterVehicleExit(repository);		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		String strEntry = "2019-06-20 00:40";
		LocalDateTime dateTimeEntry = LocalDateTime.parse(strEntry, formatter);
		
		String strExit = "2019-06-20 10:40";
		LocalDateTime dateTimeExit = LocalDateTime.parse(strExit, formatter);
				
		ticket.setAdmissionDate(dateTimeEntry);
		ticket.setDepartureDate(dateTimeExit);
		
		//act
		int value = service.calculateValueTicket(ticket);
		
		//assert
		assertTrue(6000 == value);
	}
	
	@Test
	public void calculateValueTicketMotoNineHoursAndHighEngine() {
		//arrange
		Vehicle vehicle = new VehicleTestDataBuilder().withPlate("WSN25C").withTypeVehicle("moto").withEngineDisplacement(700).build();
		Ticket ticket = new TicketTestDataBuilder().withVehicle(vehicle).build();
		ParkingLotRepository repository = Mockito.mock(ParkingLotRepository.class);
		ServiceRegisterVehicleExit service = new ServiceRegisterVehicleExit(repository);		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		String strEntry = "2019-06-20 00:40";
		LocalDateTime dateTimeEntry = LocalDateTime.parse(strEntry, formatter);
		
		String strExit = "2019-06-20 09:40";
		LocalDateTime dateTimeExit = LocalDateTime.parse(strExit, formatter);
				
		ticket.setAdmissionDate(dateTimeEntry);
		ticket.setDepartureDate(dateTimeExit);
		
		//act
		int value = service.calculateValueTicket(ticket);
		
		//assert
		assertTrue(6000 == value);
	}
	
	
	@Test
	public void calculateValueTicketMotoNineHoursAndLowEngine() {
		//arrange
		Vehicle vehicle = new VehicleTestDataBuilder().withPlate("WSN25C").withTypeVehicle("moto").build();
		Ticket ticket = new TicketTestDataBuilder().withVehicle(vehicle).build();
		ParkingLotRepository repository = Mockito.mock(ParkingLotRepository.class);
		ServiceRegisterVehicleExit service = new ServiceRegisterVehicleExit(repository);		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		String strEntry = "2019-06-20 00:40";
		LocalDateTime dateTimeEntry = LocalDateTime.parse(strEntry, formatter);
		
		String strExit = "2019-06-20 09:40";
		LocalDateTime dateTimeExit = LocalDateTime.parse(strExit, formatter);
				
		ticket.setAdmissionDate(dateTimeEntry);
		ticket.setDepartureDate(dateTimeExit);
		
		//act
		int value = service.calculateValueTicket(ticket);
		
		//assert
		assertTrue(4000 == value);
	}
	
	@Test
	public void calculateValueTicketCarNineHours() {
		//arrange
		Vehicle vehicle = new VehicleTestDataBuilder().withPlate("WSN25C").withTypeVehicle("carro").build();
		Ticket ticket = new TicketTestDataBuilder().withVehicle(vehicle).build();
		ParkingLotRepository repository = Mockito.mock(ParkingLotRepository.class);
		ServiceRegisterVehicleExit service = new ServiceRegisterVehicleExit(repository);		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		String strEntry = "2019-06-20 00:40";
		LocalDateTime dateTimeEntry = LocalDateTime.parse(strEntry, formatter);
		
		String strExit = "2019-06-20 09:40";
		LocalDateTime dateTimeExit = LocalDateTime.parse(strExit, formatter);
				
		ticket.setAdmissionDate(dateTimeEntry);
		ticket.setDepartureDate(dateTimeExit);
		
		//act
		int value = service.calculateValueTicket(ticket);
		
		//assert
		assertTrue(8000 == value);
	}
	
	@Test
	public void calculateValueTicketCarOneHour() {
		//arrange
		Vehicle vehicle = new VehicleTestDataBuilder().withPlate("WSN25C").withTypeVehicle("carro").build();
		Ticket ticket = new TicketTestDataBuilder().withVehicle(vehicle).build();
		ParkingLotRepository repository = Mockito.mock(ParkingLotRepository.class);
		ServiceRegisterVehicleExit service = new ServiceRegisterVehicleExit(repository);		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		String strEntry = "2019-06-20 00:40";
		LocalDateTime dateTimeEntry = LocalDateTime.parse(strEntry, formatter);
		
		String strExit = "2019-06-20 01:40";
		LocalDateTime dateTimeExit = LocalDateTime.parse(strExit, formatter);
				
		ticket.setAdmissionDate(dateTimeEntry);
		ticket.setDepartureDate(dateTimeExit);
		
		//act
		int value = service.calculateValueTicket(ticket);
		
		//assert
		assertTrue(1000 == value);
	}
}
