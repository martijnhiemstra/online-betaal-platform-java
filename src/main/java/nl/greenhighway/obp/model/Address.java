package nl.greenhighway.obp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	private String uid;

	private String object;

	private long created;

	private long updated;

	private Long verified;

	private String type;

	private String address_line_1;

	private String address_line_2;

	private String zipcode;

	private String city;

	private String country;

}
