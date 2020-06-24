package spring4.core.qualifier.impl;

import org.springframework.stereotype.Component;

import spring4.core.qualifier.intf.Dessert;

@Component
public class IceCream implements Dessert{

	@Override
	public void taste() {
		System.out.println("Dessert as IceCream Taste !!!" );
	}
}
