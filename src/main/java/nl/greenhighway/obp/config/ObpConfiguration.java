package nl.greenhighway.obp.config;

public class ObpConfiguration {

	private boolean productionMode;

	private String apiKey;

	private String baseUrl;

	private static final ObpConfiguration configuration = new ObpConfiguration();

	private ObpConfiguration() {
	}

	/**
	 * This initializer allows initializing the configuration with a production mode flag and an api key
	 * 
	 * @param productionMode Call the production url or if false then the sandbox will be used.
	 * @param apiKey         Your api key
	 */
	public static final void initialize(final boolean productionMode, final String apiKey) {
		configuration.productionMode = productionMode;
		configuration.apiKey = apiKey;
		configuration.baseUrl = productionMode ? "https://api.onlinebetaalplatform.nl" : "https://api-sandbox.onlinebetaalplatform.nl";
	}

	/**
	 * Use this code to set your own base url. This can be handy when testing for example.
	 * 
	 * @param baseUrl The base url that will be added to the beginning of all url's
	 * @param apiKey  The api key
	 */
	public static final void initialize(final String baseUrl, final String apiKey) {
		configuration.productionMode = false;
		configuration.apiKey = apiKey;
		configuration.baseUrl = baseUrl;
	}

	public static final ObpConfiguration getInstance() {
		return configuration;
	}

	public boolean isProductionMode() {
		return productionMode;
	}

	public String getApiKey() {
		return apiKey;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

}
