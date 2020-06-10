package lambdaNew.impl;

public class Message {

	public Message(String msg) {
		System.out.print(msg);
	}
	
	public Message(String msg, int occurence) {
		System.out.print(msg+" and occures in "+occurence);
	}
}
