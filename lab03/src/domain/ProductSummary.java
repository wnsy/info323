package domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductSummary {

	private String id;
	private String name;
	
	public ProductSummary() {
	}

	public ProductSummary(Product product) {
		this.id = product.getId();
		this.name = product.getName();
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
	
	@Override
	public String toString() {
		return "ProductSummary{" + "id=" + id + ", name=" + name + '}';
	}

}
