package pl.muller.diety.sniadanie.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import pl.muller.diety.general.model.ModelData;

@Data
@Entity
@Table(name = "sniadanie_warzywo")
public class VegetableData extends ModelData {

	public VegetableData() {
		super();
	}

	public VegetableData(ModelData modelData) {
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
}
