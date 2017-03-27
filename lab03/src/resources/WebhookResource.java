package resources;

import domain.WebhookRegistration;
import java.util.ArrayList;
import javax.ws.rs.*;

/**
 *
 * @author wanwa973
 */
@Path("/webhook")
public class WebhookResource {
	
	private static final ArrayList<WebhookRegistration> urlList = new ArrayList<>(); 
	
	//create a webhook instance for that URI and add it to the collection
	//needs to be marshalled
	@POST @Consumes("text/plain")
	public void registerWebhook(String url) {
		WebhookRegistration webhook = new WebhookRegistration(url);
		urlList.add(webhook);
	}
	
	@GET
	public ArrayList<WebhookRegistration> getResource() {
		return urlList;
	}
	
	/**
	 * To allow client to send a properly encoded webhook using XML/JSON
	 *
	 * @param webhook
	 */
  @POST
	public void registerXmlJson(WebhookRegistration webhook) {
		urlList.add(webhook);
	}
	
}
