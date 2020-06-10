package lambda.functionalInterfaces;

@FunctionalInterface
public interface FunctionMultiParam <T, V, R>{

	public R apply(T t, V v);
}
