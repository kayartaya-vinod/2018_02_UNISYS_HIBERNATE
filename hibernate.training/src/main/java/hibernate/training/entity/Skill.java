package hibernate.training.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Skill {
	@Id
	private Integer id;
	private String name;

	public Skill(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	@ManyToMany
	@JoinTable(name = "EMPS_SKILLS", 
		joinColumns = @JoinColumn(name = "SK_ID"), // maps to this.id
		inverseJoinColumns = @JoinColumn(name = "EMP_ID")) // maps to employee.id
	private Set<Employee> employees; // employees with this skill
	
	// custom helper method to add employee to this.employees
	public void addEmployee(Employee e) {
		if(this.employees==null) {
			this.employees = new HashSet<>();
		}
		this.employees.add(e);
	}
}









