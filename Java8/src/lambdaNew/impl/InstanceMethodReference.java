package lambdaNew.impl;

public class InstanceMethodReference {

	public void saySomething() {
		System.out.println("Hello, this is non-static method.");
	}

	public void printnMsg() {
		System.out.println("Hello, this is instance method inside a Thread");
	}
}
