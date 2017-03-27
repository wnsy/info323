package dao;

import domain.Product;
import domain.ProductSummaries;
import domain.ProductSummary;
import domain.WebhookRegistration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import org.glassfish.jersey.client.ClientConfig;
import resources.WebhookResource;

public class ProductDAO {

	private static Map<String, Product> products = null;

	// create some dummy products for testing purposes
	public ProductDAO() {
		if (products == null) {
			products = new HashMap<>();
			products.put("FD1234", new Product("FD1234", "Freckled Doohicky", "A doohicky that has spent a lot of time in direct sunlight.", 4.35, 10.0));
			products.put("FW4321", new Product("FW4321", "Fuzzy Widget", "A widget that needs a shave.", 5.64, 20.0));
			products.put("WF3412", new Product("WF3412", "Wuzzy Fidget", "A slightly confused fuzzy widget.", 6.34, 2.0));
		}
	}

	public Collection<Product> getAll() {
		return products.values();
	}

	public ProductSummaries getSummaries() {

		ProductSummaries summaries = new ProductSummaries();

		for (Product product : products.values()) {
			summaries.add(new ProductSummary(product));
		}

		return summaries;
	}

	public Product getByID(String id) {
		return products.get(id);
	}

	public Boolean exists(String id) {
		return products.containsKey(id);
	}

	public void create(Product product) {
		products.put(product.getId(), product);
		
		//lab5 Firing the webhook
		WebhookResource webhook = new WebhookResource();
		
		ArrayList<WebhookRegistration> storeWebhook = webhook.getResource();
		
				//creates client config
		ClientConfig config = new ClientConfig();

		//creates client endpoint
		Client client = ClientBuilder.newClient(config);

		
		for (WebhookRegistration test : storeWebhook) {
			client.target(test.getURL()).request().async().post(Entity.entity(product, "application/json"));
		}
	}

	public void delete(Product product) {
		products.remove(product.getId());
	}

	public void updateProduct(String id, Product product) {
		products.put(id, product);
	}

}
