package nl.greenhighway.obp.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

	private String uid;

	private String object;

	private long created;

	private long updated;

	private String status; // pending live suspended blocked

	private String name;

	private String sector;

	private String url;

	private String po_number;

	private String contact;

	private String[] settings;

	private Object bank_account;

	private List<String> payment_methods;

	private Object files;

	private Object messages;

}
