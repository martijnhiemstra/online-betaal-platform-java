package nl.greenhighway.obp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailAddress {

	private String uid;

	private String object;

	private long created;

	private long updated;

	private Long verified;

	private String emailaddress;

}
