package spring4.core.qualifier.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring4.core.qualifier.intf.Dessert;

@Component
public class DessertTaster {

	@Autowired
	@Qualifier("iceCream")
	private Dessert dessert;

	public Dessert getDessert() {
		return dessert;
	}

	public void setDessert(Dessert dessert) {
		this.dessert = dessert;
	}
}
