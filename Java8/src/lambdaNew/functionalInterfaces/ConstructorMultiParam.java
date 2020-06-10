package lambdaNew.functionalInterfaces;

@FunctionalInterface
public interface ConstructorMultiParam <T, V, R>{

	public R apply(T t, V v);
}
