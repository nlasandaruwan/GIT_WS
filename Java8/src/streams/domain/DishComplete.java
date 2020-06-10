package streams.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class DishComplete {

	private final String name;
	private final boolean vegetarian;
	private final int calories;
	private final Type type;
	private final int price;

	
	public enum Type {
		MEAT, FISH, OTHER, ORGANIC
	}
}
