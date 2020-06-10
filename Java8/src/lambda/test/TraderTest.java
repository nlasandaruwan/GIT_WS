package lambda.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import lambda.custom.Trader;
import lambda.custom.Transaction;

public class TraderTest {

	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario","Milan");
		Trader alan = new Trader("Alan","Cambridge");
		Trader brian = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
		new Transaction(brian, 2011, 300),
		new Transaction(raoul, 2012, 1000),
		new Transaction(raoul, 2011, 400),
		new Transaction(mario, 2012, 710),
		new Transaction(mario, 2012, 700),
		new Transaction(alan, 2012, 950)
		);
		
		System.out.println(transactions.stream()
				.filter(a -> a.getYear() ==2011)
				.map(Transaction::getValue)
				.sorted().collect(Collectors.toList()));
		
		System.out.println(transactions.stream()
							.map(tr -> tr.getTrader().getCity())
							.distinct()
							.collect(Collectors.toList()));	
		
		System.out.println(transactions.stream()
			.filter(a -> a.getTrader().getCity().equals("Cambridge"))
			.map(a -> a.getTrader().getName())
			.sorted()
			.collect(Collectors.toList()));
		
		System.out.println(transactions.stream().
			map(Transaction::getTrader)
			.filter(t -> t.getCity().equals("Cambridge"))
			.distinct()
			.sorted(Comparator.comparing(Trader::getName))
			.collect(Collectors.toList()));
	
		System.out.println(transactions.stream()
				.map(t -> t.getTrader().getName())
				.distinct()
				.sorted().reduce("", (n1,n2)-> n1 +" "+n2));
		
		System.out.println(transactions.stream().map(t -> t.getTrader()).anyMatch(a-> a.getCity().equals("Milan")));
		
		System.out.println(transactions.stream()
				.filter(t-> t.getTrader().getCity().equals("Cambridge"))
				.map(t -> t.getValue())
				.collect(Collectors.toList()));
		
		System.out.println(transactions.stream().map(t-> t.getValue()).reduce(0,(a,b)->a > b ?a:b));
		System.out.println(transactions.stream().map(t-> t.getValue()).reduce(Integer::min).get());
		
		System.out.println(transactions.stream().mapToInt(Transaction::getValue).sum());
		System.out.println(transactions.stream().mapToInt(Transaction::getValue).max());
		System.out.println(transactions.stream().mapToInt(Transaction::getValue).min());
		
	}
}
