package spring4.core.qualifier.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import spring4.core.qualifier.custom.Creamy;
import spring4.core.qualifier.intf.Dessert;

@Component
@Primary
@Qualifier("cold")
@Creamy
public class IceCream implements Dessert{

	@Override
	public void taste() {
		System.out.println("Dessert as IceCream Taste !!!" );
	}
}
