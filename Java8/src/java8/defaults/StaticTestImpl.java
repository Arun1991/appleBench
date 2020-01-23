package java8.defaults;

public class StaticTestImpl  extends StaticTest implements StaticInterface {

	@Override
	public void doDefault() {
		// TODO Auto-generated method stub
		System.out.println("default method overridden  in class, while overriding default keyword should be replaced by public");
	}
	public static void main(String[] args) {
		StaticTestImpl.doSomething();
		StaticInterface.doNothing();
		StaticTestImpl impl = new StaticTestImpl();
		impl.doDefault();
	}
}
class StaticTest{
	public static void doSomething(){
		System.out.println("static method");
	}
}
interface StaticInterface{
	static void doNothing(){
		System.out.println("interface static() can be only invoked by using the refference of Interface");
	}
	default void doDefault(){
		System.out.println("default() defined in interface");
	}
}