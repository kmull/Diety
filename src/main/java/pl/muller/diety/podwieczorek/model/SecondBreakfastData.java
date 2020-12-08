package pl.muller.diety.podwieczorek.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import pl.muller.diety.general.model.ModelData;

@Entity
@Table(name = "drugie_sniadanie")
@Data
public class SecondBreakfastData extends ModelData {

	public SecondBreakfastData() {
		super();
	}

	public SecondBreakfastData(ModelData modelData) {
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
