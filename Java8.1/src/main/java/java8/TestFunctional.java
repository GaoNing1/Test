package java8;

public class TestFunctional {
public static void main(String[] args) {
	ConvertFunctional<String,Integer> convert =(from)->Integer.valueOf(from);
	Integer result =convert.convert("123");
	System.out.println(result);
}
}
