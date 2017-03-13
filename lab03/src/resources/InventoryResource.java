package resources;

import dao.ProductDAO;
import domain.Product;
import java.util.Collection;
import javax.ws.rs.*;

/**
 *
 * @author wanwa973
 */
@Path("/products/")
public class InventoryResource {
	private static final ProductDAO test = new ProductDAO();

   @GET   //method will be invoke when an HTTP GET request is sent to this
	//resource class: when GET requesti is sent to /products/ path the service
	//will return all of the products
	private static Collection<Product> getProducts() {
		return test.getAll();
	}
}
