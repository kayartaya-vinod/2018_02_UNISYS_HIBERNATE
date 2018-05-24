package hibernate.training.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Double salary;

	// many-to-one is used to represent a foreign key, by using unique=true,
	// this association acts as a one-to-one
	@ManyToOne
	@JoinColumn(name = "lt_serial_no", unique = true, nullable = true)
	private Laptop laptop;

	public Employee(String name, Double salary) {
		this.name = name;
		this.salary = salary;
	}
	
	@ManyToMany(mappedBy="employees") // get the mapping info from the "Skill.employees" field
	private Set<Skill> skills; // the skills, "this" employee has
}
