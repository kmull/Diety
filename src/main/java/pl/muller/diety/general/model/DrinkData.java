package pl.muller.diety.general.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "napoj")
public class DrinkData extends ModelData {

	public DrinkData() {
		super();
	}

	public DrinkData(ModelData modelData) {
		super();
		this.id = modelData.getId();
		this.type = modelData.getType();
		this.mealType = modelData.getMealType();
		this.name = modelData.getName();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String type;
	private String name;
	private String mealType;

	@Override
	public String toString() {
		return "Napoj [id=" + id + ", type=" + type + ", name=" + name + ", mealType=" + mealType + "]";
	}
}
