package lambda.functionalInterfaces;

public interface WithDefaults <T, R> {

	default void testDef(){
		System.out.println("From Default !!!");
	}
	
	public T validate(R r);
	
	public static void testStatic(){
		System.out.println("From static !!!");
	}
}
