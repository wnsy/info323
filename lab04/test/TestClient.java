
import javax.ws.rs.client.WebTarget;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import domain.Product;
import javax.ws.rs.*;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.*;

/**
 *
 * @author wanwa973
 */
public class TestClient {
	private Product product;
	private WebTarget products;

	public TestClient() {
	}

//	public TestClient(Product product, WebTarget products) {
//		this.product = product;
//		this.products = products;
//	}

	@Before
	public void setUp() {
		//creates client config
		ClientConfig config = new ClientConfig();

		//creates client endpoint
		Client client = ClientBuilder.newClient(config);

		//creates web target for the root of the inventory service
		products = client.target("http://localhost:8081/products/");

		/** Requests **/
		product = new Product("test001", "testUnit Product", "another testUnit",
				  23.00, 10.00);

	   products.request().post(Entity.entity(product, "application/json"));
	}

	@After
	public void tearDown() {
		products.path("test001").request().delete();
	}

	// TODO add test methods here.
	// The methods must be annotated with annotation @Test. For example:
	//
	// @Test
	// public void hello() {}

	//Test both the POST and GET features of the service
	//The setUp method is already doing the POST.
	@Test
	public void testGetProduct() {
		//GET the same product from the service and compare it to the one that
		//was created via the POST using assertEquals
		Product testProd = products
				  .path(product.getId())
				  .request("text/xml")
				  .get(Product.class);

		//also test POST indirectly
		assertEquals("Test product GET with XML", testProd, product);

		Product aProd = products
				  .path(product.getId())
				  .request("application/json")
				  .get(Product.class);

		assertEquals("Test product GET with JSON", aProd, product);
	}

	@Test(expected = javax.ws.rs.NotFoundException.class)
	public void testDeleteProduct() throws NotFoundException {
		//DELETE product test001
		Response testProd = products
				  .path(product.getId())
				  .request()
				  .delete();


		//GET product test001 using JSON
		Product jsonProd = products
				.path(product.getId())
				.request("application/json")
				.get(Product.class);

//		assertNull("Product isn't found", product);
//		assertEquals("Test product GET with JSON", jsonProd, product);
	}
	
	@Test
	public void testPut() {
		//should change the name of the test product, the PUT it
		product.setName("New Test Product");
		
		//PUT product
		 products.path(product.getId()).request().put(Entity.entity(product, "text/xml"));

		//GET
		Product xmlProd = products
				.path(product.getId())
				.request("text/xml")
				.get(Product.class);			
		
		assertEquals(xmlProd.getName(), product.getName());
	}
	
	@Test
	public void testProductSummaries() {
		// GET the RAW XML for the product IDs
      String rawIds = products.request("text/xml").get(String.class);
		Product aProd = products
				  .path(product.getId())
				  .request("text/xml")
				  .get(Product.class);
		
		assertTrue(rawIds.contains(aProd.getId()));
		assertTrue(rawIds.contains(aProd.getName()));
	}
	
	


}
