package nl.greenhighway.obp.model;

import java.time.ZonedDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

	private String uid;

	private String object;

	private String type; // representative technical financial

	private long created;

	private long updated;

	private Long verified;

	private String verification_url;

	private String title;

	private String name_initials;

	private String name_first;

	private String name_last;

	private ZonedDateTime birthdate;

	private List<EmailAddress> emailaddresses;

}
