package hibernate.training.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "brands")
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }) // fetch type is "LAZY" by default
	@JoinColumn(name = "brand_id") // column in the other table "products"
	private Set<Product> products;

	// custom helper method to do the bi-directional association between a product
	// and a brand
	public void addProduct(Product product) {
		if (this.products == null) {
			this.products = new HashSet<>();
		}

		this.products.add(product);
		product.setBrand(this);
	}
}
