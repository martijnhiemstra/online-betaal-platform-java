package nl.greenhighway.obp.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateMerchantRequest {

	private String country;

	private String emailaddress;

	private String phone;

	private String type = "business";

	private String coc_nr;

}
