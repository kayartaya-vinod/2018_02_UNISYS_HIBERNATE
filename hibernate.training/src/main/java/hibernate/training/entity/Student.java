package hibernate.training.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("stud")
public class Student extends Person {
	private String subject;
	private Double marks;
}
