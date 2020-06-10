package streams.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Employee {
	private String name;
	private Integer age;
	private Double salary;


	// Standard hashcode() & equals() implementations go here
}