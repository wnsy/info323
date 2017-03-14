package resources;

import dao.ProductDAO;
import domain.Product;
import domain.ProductSummaries;
import domain.ProductSummary;
import java.util.Collection;
import javax.ws.rs.*;

/**
 *
 * @author wanwa973
 */
@Path("/products/")
public class InventoryResource {
	private final ProductDAO test = new ProductDAO();

   /** method will be invoke when an HTTP GET request is sent to this
	 * resource class: when GET request is sent to /products/ path the service
	 * will return all of the products
	 * @return 
	 */
	@GET
	public ProductSummaries getProducts() {
		return test.getSummaries();
	}
	
	/**
	 * Creates product
	 * @POST method will respond to HTTP POST 
	 * @param product 
	 * //ignore this one// ==Response==
		RESPONSE STATUS: 204 No Content
		RESPONSE HEADERS: []
	 */
	@POST
	public void createProduct(Product product) {
		test.create(product);
	}
}
