package nl.greenhighway.obp.model.request;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nl.greenhighway.obp.model.Transaction;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateMultiTransactionRequest {

	private String payment_method; // ideal paypal-pc bcmc sepa creditcard

	private int total_price;

	private int shipping_costs;

	private ZonedDateTime date_expired;

	private String description;

	private List<Transaction> transactions;

	private String return_url;

	private String notify_url;

	private Map<String, String> metadata;

}
