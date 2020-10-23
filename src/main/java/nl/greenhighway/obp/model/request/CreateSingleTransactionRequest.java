package nl.greenhighway.obp.model.request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateSingleTransactionRequest {

	private String merchant_uid;

	private List<Object> products;

	private String return_url;

	private String notify_url;

	private int total_price;

	private Map<String, String> metadata = new HashMap<>();

}
