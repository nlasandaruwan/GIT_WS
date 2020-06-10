package streams.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Transaction {

	private final Trader trader;
	private final int year;
	private final int value;

}
