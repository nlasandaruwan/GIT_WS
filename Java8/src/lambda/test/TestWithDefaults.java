package lambda.test;

import lambda.functionalInterfaces.WithDefaults;

public class TestWithDefaults {

	public static void main(String[] args) {
		
		WithDefaults<Integer, String> defaults = (String s) -> s.length();
		WithDefaults<Integer, String> defaultsInfer = (s) -> s.hashCode();
		
		defaults.testDef();
		System.out.println(defaults.validate("Axis"));
		System.out.println(defaultsInfer.validate("Axis"));
		WithDefaults.testStatic();
	}
}
