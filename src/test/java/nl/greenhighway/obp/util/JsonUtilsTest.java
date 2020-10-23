package nl.greenhighway.obp.util;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import nl.greenhighway.obp.exception.JsonException;
import nl.greenhighway.obp.model.Merchant;

public class JsonUtilsTest {

	@Test
	public void test_createJson_with_null() throws JsonException {
		Assertions.assertThrows(JsonException.class, () -> {
			JsonUtils.createJson(null);
		});
	}

	@Test
	public void test_createJson_with_validObject() throws JsonException, IOException {
		Merchant merchant = new Merchant();

		String value = JsonUtils.createJson(merchant);
		String expectedValue = TestUtils.readFileContents("merchant_empty.json");

		Assertions.assertEquals(value, expectedValue);
	}

	@Test
	public void test_convertJsonToObject_with_merchantJson() throws JsonException, IOException {
		String emptyMerchantJson = TestUtils.readFileContents("merchant_empty.json");

		Merchant merchant = JsonUtils.convertJsonToObject(emptyMerchantJson, Merchant.class);

		Assertions.assertNull(merchant.getUid());
		Assertions.assertNull(merchant.getStatus());
		Assertions.assertEquals(merchant.getCreated(), 0L);
		Assertions.assertEquals(merchant.getUpdated(), 0L);
	}

}
