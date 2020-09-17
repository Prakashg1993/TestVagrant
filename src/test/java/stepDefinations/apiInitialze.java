package stepDefinations;

import java.util.LinkedHashMap;
import java.util.Map;
import container.browserIntialize;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class apiInitialze extends browserIntialize {

	public static RequestSpecification request;

	public static RequestSpecification requestinitializer() {
		RequestSpecBuilder builder = new RequestSpecBuilder();
		Map<String, String> values = new LinkedHashMap<String, String>();
		values.put("q", cityName);
		values.put("appid", prop.getProperty("appid"));

		builder.setBaseUri(prop.getProperty("apiURL"));
		builder.addQueryParams(values);
		builder.setContentType(ContentType.JSON);

		request = builder.build();
		return request;
	}
}
