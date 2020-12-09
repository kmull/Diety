package pl.muller.diety.obiad.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import pl.muller.diety.general.model.ModelData;

@Entity
@Table(name = "obiad_zupa")
@Data
public class SoupData extends ModelData {

	public SoupData() {
		super();
	}

	public SoupData(ModelData modelData) {
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
		return "SoupData [id=" + id + ", type=" + type + ", name=" + name + ", mealType=" + mealType + "]";
	}

}
