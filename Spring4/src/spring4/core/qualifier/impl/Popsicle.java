package spring4.core.qualifier.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import spring4.core.qualifier.custom.Fruity;
import spring4.core.qualifier.intf.Dessert;

@Component
@Primary
@Qualifier("cold")
@Fruity
public class Popsicle implements Dessert{

	@Override
	public void taste() {
		System.out.println("Dessert as Popsicle Taste !!!" );
		
	}

}
