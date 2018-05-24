package hibernate.training.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Laptop {
	@Id
	private String serialNo;
	private String make;
	private String model;

	@OneToOne(mappedBy = "laptop") // "laptop" is the field in the Employee class
	private Employee owner;

	public Laptop(String serialNo, String make, String model) {
		this.serialNo = serialNo;
		this.make = make;
		this.model = model;
	}
}
