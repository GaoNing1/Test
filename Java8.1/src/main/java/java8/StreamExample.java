package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {

	public static void main(String[] args) {
		
		List<Integer> myList = new ArrayList<>();
		for(int i=0; i<100; i++) myList.add(i);
		
		//顺序流
		Stream<Integer> sequentialStream = myList.stream();
		
		//并行流
		Stream<Integer> parallelStream = myList.parallelStream();
		
		//使用带有Stream API的lambda，过滤器示例
		Stream<Integer> highNums = parallelStream.filter(p -> p > 90);
		//在forEach中使用lambda
		highNums.forEach(p -> System.out.println("High Nums parallel="+p));
		
		Stream<Integer> highNumsSeq = sequentialStream.filter(p -> p > 90);
		highNumsSeq.forEach(p -> System.out.println("High Nums sequential="+p));

	}

}
