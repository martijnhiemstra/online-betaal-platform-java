package nl.greenhighway.obp.model;

public enum MerchantStatus {

	NEW("new"), PENDING("pending"), LIVE("live"), SUSPENDED("suspended"), TERMINATED("terminated"), BLOCKED("blocked");

	private String value;

	private MerchantStatus(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static final MerchantStatus findByValue(final String value) {
		for (MerchantStatus nextMerchantStatus : MerchantStatus.values()) {
			if (nextMerchantStatus.value.equals(value))
				return nextMerchantStatus;
		}

		return null;
	}

}
