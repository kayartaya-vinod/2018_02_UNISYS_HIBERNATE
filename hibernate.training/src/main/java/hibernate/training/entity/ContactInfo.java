package hibernate.training.entity;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Embeddable
@ToString
public class ContactInfo {
	private String address;
	private String city;
	private String state;
	private String country;
	private String phone;
}
