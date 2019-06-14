package co.com.ceiba.estacionamiento.framework.adapter.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EntityTicket {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String plate;
	private String typeVehicle;
    private int engineDisplacement;
	private LocalDateTime admissionDate;
	private LocalDateTime departureDate;
	private int value;
	
	public EntityTicket() {

	}
	
	public EntityTicket(String plate, String typeVehicle, int engineDisplacement, LocalDateTime admissionDate) {
		super();
		this.plate = plate;
		this.typeVehicle = typeVehicle;
		this.engineDisplacement = engineDisplacement;
		this.admissionDate = admissionDate;
	}

	public EntityTicket(String plate, String typeVehicle, int engineDisplacement) {
		super();
		this.plate = plate;
		this.typeVehicle = typeVehicle;
		this.engineDisplacement = engineDisplacement;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getTypeVehicle() {
		return typeVehicle;
	}

	public void setTypeVehicle(String typeVehicle) {
		this.typeVehicle = typeVehicle;
	}

	public int getEngineDisplacement() {
		return engineDisplacement;
	}

	public void setEngineDisplacement(int engineDisplacement) {
		this.engineDisplacement = engineDisplacement;
	}

	public LocalDateTime getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(LocalDateTime admissionDate) {
		this.admissionDate = admissionDate;
	}

	public LocalDateTime getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
