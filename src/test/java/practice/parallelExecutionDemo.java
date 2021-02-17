package practice;

import org.testng.annotations.Test;

public class parallelExecutionDemo {
	
	@Test
	public void methodOne() {
		System.out.println("I am at method1 |"+Thread.currentThread().getId());

	}
	@Test
	public void methodTwo() {
		System.out.println("I am at method2 |"+Thread.currentThread().getId());

	}
	@Test
	public void methodThree() {
		System.out.println("I am at method3 |"+Thread.currentThread().getId());

	}
	@Test
	public void methodFour() {
		System.out.println("I am at method4 |"+Thread.currentThread().getId());

	}
	@Test
	public void methodFive() {
		System.out.println("I am at method5 |"+Thread.currentThread().getId());
	}
	@Test
	public void methodsix() {
		System.out.println("I am at method6 |"+Thread.currentThread().getId());

	}
	

}
