package java8;

public class MyClass implements Interface1,Interface2{
//两个接口都有一个log方法
	@Override
	public void method2() {
			
	}

	@Override
	public void method1(String str) {
	
	}

	@Override
	public void log(String str) {
		
		Interface1.super.log(str);
	}

}
