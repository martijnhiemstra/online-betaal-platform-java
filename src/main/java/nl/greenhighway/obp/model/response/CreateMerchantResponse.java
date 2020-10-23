package nl.greenhighway.obp.model.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nl.greenhighway.obp.model.Address;
import nl.greenhighway.obp.model.Contact;
import nl.greenhighway.obp.model.Profile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateMerchantResponse {

	private String uid;

	private String object;

	private long created;

	private long updated;

	private String status;

	private Object compliance;

	private String type;

	private String coc_nr;

	private String name;

	private String vat_nr;

	private String country;

	private String sector;

	private List<Address> addresses;

	private List<String> trading_names;

	private List<Contact> contacts;

	private List<Profile> profiles;

	private List<String> payment_methods;

}
