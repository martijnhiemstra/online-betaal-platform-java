package nl.greenhighway.obp.util;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import nl.greenhighway.obp.exception.JsonException;

final class JsonUtils {

	private static final ObjectMapper mapper = new ObjectMapper();

	protected static final String createJson(final Object obj) throws JsonException {
		if (obj == null)
			throw new JsonException("Object may not be null");

		try {
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			throw new JsonException(e.getMessage(), e);
		}
	}

	protected static final JsonNode convertJsonToJsonNode(final String json) throws JsonException {
		try {
			return mapper.readTree(json);
		} catch (JsonProcessingException e) {
			throw new JsonException(e.getMessage(), e);
		}
	}

	protected static final Map<?, ?> convertJsonToMap(final String json) throws JsonException {
		try {
			return mapper.readValue(json, new TypeReference<Map<?, ?>>() {
			});
		} catch (JsonProcessingException e) {
			throw new JsonException(e.getMessage(), e);
		}
	}

	protected static final <O extends Object> O convertJsonToObject(final String json, final Class<O> clazz) throws JsonException {
		try {
			return mapper.readValue(json.getBytes(), clazz);
		} catch (JsonProcessingException e) {
			throw new JsonException(e.getMessage(), e);
		} catch (IOException e) {
			throw new JsonException(e.getMessage(), e);
		}
	}

}
