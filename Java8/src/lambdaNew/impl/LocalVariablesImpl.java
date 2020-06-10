package lambdaNew.impl;

import lambdaNew.functionalInterfaces.LocalVariables;

public class LocalVariablesImpl {

	
	
	public void process(LocalVariables localVariables){
		int portNumber = 1337;
		
		LocalVariables r = () -> System.out.println(portNumber);
		
//		portNumber = 22;
	}
	
	
	
}
