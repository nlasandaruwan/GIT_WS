package lambda.functionalInterfaces;

@FunctionalInterface
public interface VoidConsumer <T> {

	public void consume(T t);
}
