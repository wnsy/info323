package resources;

import dao.ProductDAO;
import domain.Product;
import javax.ws.rs.*;


/**
 *
 * @author wanwa973
 */
@Path("/products/{productID}")
public class ProductResource {
	private final ProductDAO item = new ProductDAO();
	private final String productID;
	private final Product product;

	
	public ProductResource(@PathParam("productID") String  productID) {
		this.productID = productID;
		this.product = this.item.getByID(productID);
		
		if(!item.exists(productID)) {
			throw new NotFoundException("Sorry, product ID is not found.");
		} 
	}	 

	@GET
	public Product getProduct() {
		return product;
	}
}
