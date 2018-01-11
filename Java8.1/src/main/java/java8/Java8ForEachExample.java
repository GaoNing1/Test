package java8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
/**
 * 迭代器接口中的foreach方法
 * @author gaoning
 *
 */
public class Java8ForEachExample {
public static void main(String[] args) {
		
		//创建一个List集合
		List<Integer> myList = new ArrayList<Integer>();
		for(int i=0; i<10; i++) myList.add(i);
		
		//遍历迭代器
		Iterator<Integer> it = myList.iterator();
		while(it.hasNext()){
			Integer i = it.next();
			System.out.println("迭代器的值 ::"+i);
		}
		
		//匿名类遍历foreach
		myList.forEach(new Consumer<Integer>() {

			public void accept(Integer t) {
				System.out.println("forEach匿名类的值::"+t);
			}

		});
		//Consume接口实现
				MyConsumer action = new MyConsumer();
				myList.forEach(action);
				
			}
}

class MyConsumer implements Consumer<Integer>{

	public void accept(Integer t) {
		System.out.println("Consumer i实现值::"+t);
	}


}
