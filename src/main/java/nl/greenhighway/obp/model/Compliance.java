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
public class Compliance {

	private int level;

	private String status;

	private String overview_url;

	private List<Requirement> requirements;

}
