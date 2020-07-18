package spring4.core.qualifier.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring4.core.qualifier.custom.Creamy;
import spring4.core.qualifier.custom.Fruity;
import spring4.core.qualifier.intf.Dessert;

@Component
public class DessertTaster {

	@Autowired
	@Qualifier("cold")
	@Creamy
	private Dessert softDessert;

	@Autowired
	@Qualifier("cold")
	@Fruity
	private Dessert frutyDessert;

	public Dessert getSoftDessert() {
		return softDessert;
	}

	public void setSoftDessert(Dessert softDessert) {
		this.softDessert = softDessert;
	}

	public Dessert getFrutyDessert() {
		return frutyDessert;
	}

	public void setFrutyDessert(Dessert frutyDessert) {
		this.frutyDessert = frutyDessert;
	}
}
