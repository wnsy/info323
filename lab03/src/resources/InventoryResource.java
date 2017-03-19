package resources;

import dao.ProductDAO;
import domain.Product;
import domain.ProductSummaries;
import java.net.URI;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

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
	 * @param uri
	 * @return 
	 * @POST method will respond to HTTP POST 
	 * @param product 
	 * //ignore this one// ==Response==
		RESPONSE STATUS: 204 No Content
		RESPONSE HEADERS: []
	 */
	@POST
	public Response createProduct(Product product, @Context UriInfo uri) {
		URI newURI = uri.getAbsolutePathBuilder()
				  .path(product.getId().toString())
				  .build();
		test.create(product);
		
		return Response.created(newURI).build();
	}
}
