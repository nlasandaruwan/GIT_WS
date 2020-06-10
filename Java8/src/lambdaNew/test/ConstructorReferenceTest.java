package lambdaNew.test;

import lambdaNew.functionalInterfaces.Messageable;
import lambdaNew.impl.Message;

public class ConstructorReferenceTest {

	public static void main(String[] args) {
		Messageable hello = Message::new;
		hello.getMessage("Hello", 11);
		
		Messageable hello2 = Message::new;
		hello2.getMessage("",11);
	}
}
