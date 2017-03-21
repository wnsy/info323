package domain;

import java.net.URI;
import javax.xml.bind.annotation.XmlRootElement;
import org.glassfish.jersey.linking.InjectLink;
import static org.glassfish.jersey.linking.InjectLink.Style.ABSOLUTE;

@XmlRootElement
public class ProductSummary {

	private String id;
	private String name;
	@InjectLink(value = "products/{id}", style = ABSOLUTE)
	private URI uri;
	
	public ProductSummary() {
	}

	public ProductSummary(Product product) {
		this.id = product.getId();
		this.name = product.getName();
	}

	public URI getUri() {
		return uri;
	}

	public void setUri(URI uri) {
		this.uri = uri;
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
