package server;

import filters.CorsFilter;
import filters.DebugFilter;
import filters.ExceptionLogger;
import filters.ExceptionMessageHandler;
import java.net.URI;
import java.net.URISyntaxException;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.linking.DeclarativeLinkingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.bridge.SLF4JBridgeHandler;
import resources.InventoryResource;
import resources.ProductResource;
import resources.WebhookResource;

/**
 *
 * @author wanwa973
 */
public class Server {
	public static void main(String[] args) throws URISyntaxException {
		//configure the unified logger
		SLF4JBridgeHandler.removeHandlersForRootLogger();
		SLF4JBridgeHandler.install();
		
		//creates a web service configuration
		ResourceConfig config = new ResourceConfig();
		
		//adds a debug filter that prints request details
		config.register(DebugFilter.class);
		
		//an exception handler that copies exception messages into error
		//responses
		config.register(ExceptionMessageHandler.class);
		
		//an exception listener that ensures that all exceptions get logged
		config.register(ExceptionLogger.class);
		
		//adds CORS filter to allow AJAX clients to access the service
		config.register(CorsFilter.class);
		
		//adds our resource and product classes
		config.register(InventoryResource.class);
		config.register(ProductResource.class);
		config.register(DeclarativeLinkingFeature.class);
		config.register(WebhookResource.class);

		
		//defines the URI that the server will use
		URI baseUri = new URI("http://localhost:8081/");
		
		//starts the server (via the built-in Java HTTP server)
		JdkHttpServerFactory.createHttpServer(baseUri, config);

		// print a message so that we know when the service is ready
		System.out.println("Service Ready on " + baseUri);
	}
}
