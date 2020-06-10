package streams.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Dish {

	private final String name;
	private final boolean vegetarian;
	private final int calories;
	private final Type type;

	
	public enum Type {
		MEAT, FISH, OTHER
	}
}
