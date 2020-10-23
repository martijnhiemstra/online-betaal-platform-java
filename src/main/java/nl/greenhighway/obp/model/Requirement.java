package nl.greenhighway.obp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Requirement {

	private String type;

	private String status; // unverified pending verified

	private String object_type;

	private String object_uid;

	private String object_url;

	private String object_redirect_url;

}
