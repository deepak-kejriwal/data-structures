import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PracticeClass {

	public static void main(String[] args) {
		int cap=17;
	       int n = cap - 1;
	        n |= n >>> 1;
	        n |= n >>> 2;
	        n |= n >>> 4;
	        n |= n >>> 8;
	        n |= n >>> 16;
		
		Comparator c;
		List list;
		ArrayList al;
		HashMap<Integer,Integer> hm=new HashMap<>(10);
		Stream<Integer> stream = Stream.of(3, 5, 6);
		System.out.println(stream.reduce(1, (a, b) -> a*b));
		IntStream intStream = IntStream.range(1, 20);//.of(1, 2, 3);
		LongStream longStream=LongStream.of(1, 2, 3);//intStream.parallel().average()
		OptionalDouble avg1=longStream.average();
		OptionalDouble avg = intStream.parallel().average();
		System.out.println(avg.getAsDouble());
		Set<Integer> oddNumbers = Stream.iterate(1, n1 -> n1 + 1).limit(14).collect(Collectors.toSet());
		oddNumbers.add(20);
	}

}
