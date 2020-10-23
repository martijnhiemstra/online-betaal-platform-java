package nl.greenhighway.obp.util;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.mockserver.matchers.Times;
import org.mockserver.model.Header;

import nl.greenhighway.obp.exception.CallException;
import nl.greenhighway.obp.exception.JsonException;
import nl.greenhighway.obp.model.request.CreateMerchantRequest;

public class MerchantUtilsTest extends AbstractTestClass {

	@Test
	public void test_createMerchant() throws JsonException, CallException, IOException {
		System.out.println("testing test_createMerchant");

		String expectedResponse = TestUtils.readFileContents("create_merchant_response.json");

		mockServer.when( // When
				request().withMethod("POST").withPath("/v1/merchants").withHeader("\"Content-type\", \"application/json\""), // The request
				Times.exactly(1) // How many times
		).respond( // How to respond
				response().withStatusCode(200).withHeaders(new Header("Content-Type", "application/json; charset=utf-8")) // Status code and headers
						.withBody(expectedResponse) // The expected response
						.withDelay(TimeUnit.SECONDS, 1) // The delay
		);

		CreateMerchantRequest createMerchantRequest = new CreateMerchantRequest();
		createMerchantRequest.setCoc_nr("coc_1234");
		createMerchantRequest.setCountry("nld");
		createMerchantRequest.setEmailaddress("test@mynonexistingtestdomain.com");
		createMerchantRequest.setPhone("0612345678");
		createMerchantRequest.setType("business");

		MerchantUtils.createMerchant(createMerchantRequest);
	}

}
