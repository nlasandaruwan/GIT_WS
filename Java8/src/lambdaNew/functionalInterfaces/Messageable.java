package lambdaNew.functionalInterfaces;

import lambdaNew.impl.Message;

public interface Messageable {

	Message getMessage(String msg, int occurence);

}
