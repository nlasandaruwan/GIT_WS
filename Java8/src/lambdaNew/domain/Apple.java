package lambdaNew.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Setter
@Getter
public class Apple {

	private String color = "Default Color";

	private int weight = 0;

	private String countryOfOrigined;

	public Apple() {
	}

	public Apple(int weight) {
		this.weight = weight;
	}

	public Apple(int weight, String color) {
		this.color = color;
		this.weight = weight;
	}

	/*public Apple(int weight, String color, String countryOfOrigined) {
		this.color = color;
		this.weight = weight;
		this.countryOfOrigined = countryOfOrigined;
	}*/

	/*public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getCountryOfOrigined() {
		return countryOfOrigined;
	}

	public void setCountryOfOrigined(String countryOfOrigined) {
		this.countryOfOrigined = countryOfOrigined;
	}

	public String toString() {
		return "Apple{" + "color='" + color + '\'' + ", weight=" + weight + '\'' + ", Country of Origine=" + countryOfOrigined +'}';
	}*/
}
