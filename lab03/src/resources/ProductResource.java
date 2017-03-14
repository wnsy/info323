package resources;

import dao.ProductDAO;
import domain.Product;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 *
 * @author wanwa973
 */
@Path("/products/{productID}")
public class ProductResource {
	private final ProductDAO itemDAO = new ProductDAO();
	private final String productID;
	private final Product product;

	
	public ProductResource(@PathParam("productID") String  productID) {
		this.productID = productID;
		this.product = this.itemDAO.getByID(productID);
		
		if(!itemDAO.exists(productID)) {
			throw new NotFoundException("Sorry, product ID is not found.");
		} 
	}	 

	@GET
	public Product getProduct() {
		return this.product;
	}
	
	@DELETE
	public void deleteProduct() {
		itemDAO.delete(product);
	}
	
	@PUT
	public Response updateProduct(Product updatedProduct) {
		if(this.productID.equals(updatedProduct.getId())) {
			itemDAO.updateProduct(this.productID, updatedProduct);
			return Response.noContent().build();
		} else {
			return Response
					  .status(Response.Status.CONFLICT)
					  .entity("IDs don't match")
					  .build();
		}
	}
	
}
