package lambdaNew.test;

import java.util.function.BiFunction;

import lambdaNew.functionalInterfaces.Sayable;
import lambdaNew.impl.InstanceMethodReference;
import lambdaNew.impl.MethodReference;

class Arithmetics {

	public int add(int a, int b) {
		return a + b;
	}

	public static float add(int a, float b) {
		return a + b;
	}

	public static float adds(int a, int b) {
		return a + b;
	}

	public static float add(float a, float b) {
		return a + b;
	}
}

public class InstanceMethodReferenceTest {

	public static void main(String[] args) {

		InstanceMethodReference methodReference = new InstanceMethodReference(); // Creating
		// object
		// Referring non-static method using reference
		Sayable sayable = methodReference::saySomething;
		// Calling interface method
		sayable.say();
		// Referring non-static method using anonymous object
		Sayable sayable2 = new InstanceMethodReference()::saySomething; // You
																		// can

		// use
		// anonymous
		// object
		// also
		// Calling interface method
		sayable2.say();

		// Referring static method
		Sayable sayable3 = MethodReference::saySomething;
		// Calling interface method
		sayable3.say();

		Sayable sayable4 = () -> System.out.println("Plain Lambda");
		sayable4.say();

		Thread t2 = new Thread(new InstanceMethodReference()::printnMsg);
		t2.start();

		BiFunction<Integer, Integer, Integer> adder = new Arithmetics()::add;
		int result = adder.apply(10, 20);
		System.out.println(result);
	}
}
