package lambda.functionalInterfaces;

@FunctionalInterface
public interface CompareTwo <T, Y>{

	public boolean compare(T t1, Y y1);
}
