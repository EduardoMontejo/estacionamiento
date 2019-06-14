package co.com.ceiba.estacionamiento.framework.adapter.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EntityVehicle {
	
	@Id
	private String plate;
	private String typeVehicle;
	private String engineDisplacement;

	
	public EntityVehicle() {
		
	}
	
	public EntityVehicle(String plate, String engineDisplacement, String typeVehicle) {
		this.plate = plate;
		this.engineDisplacement = engineDisplacement;
		this.typeVehicle = typeVehicle;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getEngineDisplacement() {
		return engineDisplacement;
	}

	public void setEngineDisplacement(String engineDisplacement) {
		this.engineDisplacement = engineDisplacement;
	}

	public String getTypeVehicle() {
		return typeVehicle;
	}

	public void setTypeVehicle(String typeVehicle) {
		this.typeVehicle = typeVehicle;
	}	
}
