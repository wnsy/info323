package domain;

import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "product")
public class Product {

	private String id;
	private String name;
	private String description;
	private Double price;
	private Double stockOnHand;

	public Product() {
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 37 * hash + Objects.hashCode(this.id);
		hash = 37 * hash + Objects.hashCode(this.name);
		hash = 37 * hash + Objects.hashCode(this.description);
		hash = 37 * hash + Objects.hashCode(this.price);
		hash = 37 * hash + Objects.hashCode(this.stockOnHand);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Product other = (Product) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		if (!Objects.equals(this.name, other.name)) {
			return false;
		}
		if (!Objects.equals(this.description, other.description)) {
			return false;
		}
		if (!Objects.equals(this.price, other.price)) {
			return false;
		}
		if (!Objects.equals(this.stockOnHand, other.stockOnHand)) {
			return false;
		}
		return true;
	}

	public Product(String id, String name, String description, Double price, Double stockOnHand) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stockOnHand = stockOnHand;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getStockOnHand() {
		return stockOnHand;
	}

	public void setStockOnHand(Double stockOnHand) {
		this.stockOnHand = stockOnHand;
	}

	@Override
	public String toString() {
		return "Product{" + "id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", stockOnHand=" + stockOnHand + '}';
	}

}
