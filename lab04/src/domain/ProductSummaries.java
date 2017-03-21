package domain;

import java.util.ArrayList;
import java.util.Collection;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "product_summaries")
public class ProductSummaries {

	@XmlElement(name="product_summary")
	private final Collection<ProductSummary> summaries = new ArrayList<>();

	public ProductSummaries() {
	}

	public Collection<ProductSummary> getSummaries() {
		return summaries;
	}

	public void add(ProductSummary productSummary) {
		summaries.add(productSummary);
	}

}
