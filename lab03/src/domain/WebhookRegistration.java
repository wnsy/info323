package domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wanwa973
 */
//XmlRootElem totell JAXB that it is allowed to UNmarshall instances of this cls
@XmlRootElement 
public class WebhookRegistration {
	
	private String URL;
	
	public WebhookRegistration() {
	}
	
	public WebhookRegistration(String URL) {
		this.URL = URL;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String URL) {
		this.URL = URL;
	}

	
}
