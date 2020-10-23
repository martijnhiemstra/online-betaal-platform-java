package nl.greenhighway.obp.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import nl.greenhighway.obp.exception.CallException;
import nl.greenhighway.obp.exception.JsonException;
import nl.greenhighway.obp.model.request.CreateMerchantRequest;
import nl.greenhighway.obp.model.response.CreateMerchantResponse;

public final class MerchantUtils {

	public static final CreateMerchantResponse createMerchant(final CreateMerchantRequest createMerchantRequest) throws JsonException, CallException {
		if (createMerchantRequest == null)
			throw new IllegalArgumentException("createMerchantRequest may not be null");

		String json = JsonUtils.createJson(createMerchantRequest);

		CloseableHttpResponse response = RequestUtils.doCall("/v1/merchants", json);

		HttpEntity entity = response.getEntity();
		try {
			String responseString = EntityUtils.toString(entity, "UTF-8");

			return JsonUtils.convertJsonToObject(responseString, CreateMerchantResponse.class);
		} catch (IOException e) {
			throw new CallException(e.getMessage(), e);
		} catch (ParseException e) {
			throw new JsonException(e.getMessage(), e);
		}
	}

}
