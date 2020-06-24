package spring4.core.qualifier.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import spring4.core.qualifier.intf.Dessert;

@Component
@Primary
public class Cookies implements Dessert{

	@Override
	public void taste() {
		System.out.println("Dessert as Cookies Taste !!!" );
	}
}
