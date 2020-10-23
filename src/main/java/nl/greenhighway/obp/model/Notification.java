package nl.greenhighway.obp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Notification {

	private String uid;

	private String type;

	private long created;

	private String object_uid;

	private String object_type;

	private String object_url;

	private String parent_uid;

	private String parent_type;

	private String parent_url;

	private String verification_hash;

}
