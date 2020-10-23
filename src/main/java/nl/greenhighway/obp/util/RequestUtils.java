package nl.greenhighway.obp.util;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import nl.greenhighway.obp.config.ObpConfiguration;
import nl.greenhighway.obp.exception.CallException;

final class RequestUtils {

	static final CloseableHttpResponse doCall(final String url, final String json) throws CallException {
		if (!url.startsWith("/"))
			throw new IllegalArgumentException("Url must start with a /");

		CloseableHttpClient httpClient = null;

		try {
			httpClient = HttpClients.createDefault();

			if (json == null || json.isBlank()) {
				HttpGet request = new HttpGet(ObpConfiguration.getInstance().getBaseUrl() + url);
				request.addHeader("APIKEY", ObpConfiguration.getInstance().getApiKey());
				request.addHeader("content-type", "application/json");

				return httpClient.execute(request);
			} else {
				HttpPost request = new HttpPost(ObpConfiguration.getInstance().getBaseUrl() + url);
				request.addHeader("APIKEY", ObpConfiguration.getInstance().getApiKey());
				request.addHeader("content-type", "application/json");

				StringEntity stringEntity = new StringEntity(json);
				request.setEntity(stringEntity);

				return httpClient.execute(request);
			}
		} catch (Exception e) {
			if (httpClient != null) {
				try {
					httpClient.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

			throw new CallException(e.getMessage(), e);
		}
	}

}
