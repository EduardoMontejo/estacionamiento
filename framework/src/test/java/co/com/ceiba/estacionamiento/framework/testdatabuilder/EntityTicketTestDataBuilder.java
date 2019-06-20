package co.com.ceiba.estacionamiento.framework.testdatabuilder;

import java.time.LocalDateTime;

import co.com.ceiba.estacionamiento.framework.adapter.entity.EntityTicket;

public class EntityTicketTestDataBuilder {
	private String plate;
	private String typeVehicle;
    private int engineDisplacement;
	private LocalDateTime admissionDate;
	
	public EntityTicketTestDataBuilder() {
		this.plate = "WSN25c";
		this.typeVehicle = "MOTO";
		this.engineDisplacement = 125;
		this.admissionDate = LocalDateTime.now();
	}
	
	public EntityTicket build() {
		return new EntityTicket(this.plate, this.typeVehicle,
					this.engineDisplacement, this.admissionDate);
	}
}
