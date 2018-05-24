package hibernate.training.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("prof")
public class Professor extends Person {
	private String email;
	private Double salary;
}
