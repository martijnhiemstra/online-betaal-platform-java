package nl.greenhighway.obp.util;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import nl.greenhighway.obp.exception.CallException;
import nl.greenhighway.obp.exception.JsonException;
import nl.greenhighway.obp.model.Address;

public final class MerchantAddressUtils {

	@SuppressWarnings("unchecked")
	public static final List<Address> getMerchantAddresses(final String merchant_uid) throws JsonException, CallException {
		if (merchant_uid == null || merchant_uid.isBlank())
			throw new IllegalArgumentException("merchant_uid may not be null or blank");

		CloseableHttpResponse response = RequestUtils.doCall("/v1/merchants/" + merchant_uid + "/addresses", null);

		HttpEntity entity = response.getEntity();
		try {
			String responseString = EntityUtils.toString(entity, "UTF-8");

			return JsonUtils.convertJsonToObject(responseString, List.class);
		} catch (IOException e) {
			throw new CallException(e.getMessage(), e);
		} catch (ParseException e) {
			throw new JsonException(e.getMessage(), e);
		}
	}

	public static final Address getMerchantAddress(final String merchant_uid, final String merchant_address_uid) throws JsonException, CallException {
		if (merchant_uid == null || merchant_uid.isBlank())
			throw new IllegalArgumentException("merchant_uid may not be null or blank");

		CloseableHttpResponse response = RequestUtils.doCall("/v1/merchants/" + merchant_uid + "/addresses/" + merchant_address_uid, null);

		HttpEntity entity = response.getEntity();
		try {
			String responseString = EntityUtils.toString(entity, "UTF-8");

			return JsonUtils.convertJsonToObject(responseString, Address.class);
		} catch (IOException e) {
			throw new CallException(e.getMessage(), e);
		} catch (ParseException e) {
			throw new JsonException(e.getMessage(), e);
		}
	}

}
