package slipp.support.test;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class HtmlFormDataBuilder {
	private HttpHeaders headers;
	private MultiValueMap<String, String> params;
	
	private HtmlFormDataBuilder(HttpHeaders headers) {
		this.headers = headers;
		this.params = new LinkedMultiValueMap<String, String>();
	}
	
	public HtmlFormDataBuilder addParameter(String key, String value) {
		this.params.add(key, value);
		return this;
	}
	
	public HttpEntity<MultiValueMap<String, String>> build() {
		return new HttpEntity<MultiValueMap<String, String>>(params, headers);
	}
	
	public static HtmlFormDataBuilder urlEncodedForm() {
		HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    	return new HtmlFormDataBuilder(headers);
	}
}
