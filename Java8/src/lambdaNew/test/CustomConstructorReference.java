package lambdaNew.test;

import lambdaNew.domain.Apple;
import lambdaNew.functionalInterfaces.Constructor;
import lambdaNew.functionalInterfaces.ConstructorMultiParam;

public class CustomConstructorReference {

	public static void main(String[] args) {
		
		Constructor<Apple> constructor = Apple::new;
		
		System.out.println(constructor.get());
		
		Constructor<Apple> constructor2 = ()-> new Apple(1,"Dark Red 1");
		
		System.out.println(constructor2.get());
		
		Constructor<Apple> constructor3 = ()-> new Apple(1);
		
		System.out.println(constructor3.get());
		
		ConstructorMultiParam<Integer, String, Apple> constructor4 = (Integer i, String s ) -> new Apple(i,s);
		
		System.out.println(constructor4.apply(11, "Dark Red 2"));
		
		ConstructorMultiParam<Integer, String, Apple> constructor5 = (Integer i, String s ) -> new Apple(11,"Dark Red 3");
		
		System.out.println(constructor5.apply(0, ""));
		
		ConstructorMultiParam<Integer, String, Apple> constructorMultiParam = Apple::new;
		
		System.out.println(constructorMultiParam.apply(11, "Blue").toString());
	}
}
