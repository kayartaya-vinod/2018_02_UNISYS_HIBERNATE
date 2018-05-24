package hibernate.training.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
// apporach #1
// @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// @DiscriminatorColumn(name="person_type", discriminatorType=DiscriminatorType.STRING)

//apporach #2
// @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

//apporach #3
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {
	@Id
	private Integer id;
	private String name;
	private String city;
}
