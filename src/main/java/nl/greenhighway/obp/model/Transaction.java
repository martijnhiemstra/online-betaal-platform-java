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
public class Transaction {

	private String merchant_uid;

	private int total_price;

	private int partner_fee;

	private List<Product> products;

	private String notify_url;

}
