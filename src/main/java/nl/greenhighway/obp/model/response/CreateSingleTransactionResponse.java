package nl.greenhighway.obp.model.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nl.greenhighway.obp.model.Status;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateSingleTransactionResponse {

	private boolean livemode;

	private String uid; // transaction_uid

	private String object;

	private long created;

	private long updated;

	private long completed;

	private boolean checkout;

	private String payment_method; // ideal bcmc sepa paypal-pc mandate creditcard

	private String payment_flow; // direct or email

	private List<Object> payment_details; // TODO type

	private String amount;

	private String return_url;

	private String redirect_url;

	private String notify_url;

	private String status;

	private List<Object> metadata; // TODO type

	private List<Status> statuses;

	private List<Object> order; // TODO type

	private List<Object> escrow; // TODO type

}
