package lambdaNew.test;

import java.util.function.Function;

import lambdaNew.domain.Letter;

public class TransformationPipeline {
	public static void main(String[] args) {

		Function<String, String> addHeader = Letter::addHeader;
		Function<String, String> transformationPipeline = addHeader.andThen(Letter::checkSpelling);
		Function<String, String> finals = transformationPipeline.andThen(Letter::addFooter);
		
		addHeader.apply("Architect****");
		finals.apply("IEWARAI");
		System.out.println(transformationPipeline.apply("A second pipeline might be only adding a header"));

	}
}
 