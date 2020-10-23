package nl.greenhighway.obp.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import nl.greenhighway.obp.exception.CallException;
import nl.greenhighway.obp.exception.JsonException;
import nl.greenhighway.obp.model.request.CreateBankAccountRequest;
import nl.greenhighway.obp.model.response.CreateBankAccountResponse;

public final class BankAccountUtils {

	public static final CreateBankAccountResponse createBankAccount(final String merchant_uid, final String returnUrl, final String notifyUrl) throws JsonException, CallException {
		if (merchant_uid == null || merchant_uid.isBlank())
			throw new IllegalArgumentException("merchant_uid may not be null or blank");

		CreateBankAccountRequest createBankAccountRequest = new CreateBankAccountRequest();
		createBankAccountRequest.setNotify_url(notifyUrl);
		createBankAccountRequest.setReturn_url(returnUrl);

		String json = JsonUtils.createJson(createBankAccountRequest);

		CloseableHttpResponse response = RequestUtils.doCall("/v1/merchants/" + merchant_uid + "/bank_accounts", json);

		HttpEntity entity = response.getEntity();
		try {
			String responseString = EntityUtils.toString(entity, "UTF-8");

			return JsonUtils.convertJsonToObject(responseString, CreateBankAccountResponse.class);
		} catch (IOException e) {
			throw new CallException(e.getMessage(), e);
		} catch (ParseException e) {
			throw new JsonException(e.getMessage(), e);
		}
	}

}
