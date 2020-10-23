package nl.greenhighway.obp.model.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBankAccountResponse {

	private String uid;

	private String object;

	private long created;

	private long updated;

	private Long verified;

	private String verification_url;

	private String status;

	private List<Object> account;

	private List<Object> bank;

	private String reference;

	private String return_url;

	private String notify_url;

	private boolean is_default;

}
