package lambdaNew.impl;

import lambdaNew.domain.Human;

public class MethodReference {

	public static void saySomething() {
		System.out.println("Hello, this is static method.");
	}

	public static void ThreadStatus() {
		System.out.println("Thread is running...");
	}

	public static int compareByNameThenAge(Human lhs, Human rhs) {
		if (lhs.getName().equals(rhs.getName())) {
			return lhs.getAge() - rhs.getAge();
		} else {
			return lhs.getName().compareTo(rhs.getName());
		}
	}
}
