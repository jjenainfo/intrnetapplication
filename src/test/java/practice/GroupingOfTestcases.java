package practice;

import org.testng.annotations.Test;

public class GroupingOfTestcases {
	
	@Test(groups= {"smoke"})
	public void test1() {
		System.out.println("I am at Test1");
	}
	@Test(groups= {"sanity"})
	public void test2() {
		System.out.println("I am at Test2");
	}
	@Test(groups= {"smoke","sanity"})
	public void test3() {
		System.out.println("I am at Test3");
	}
	@Test(groups= {"regression"})
	public void test4() {
		System.out.println("I am at Test4");
	}
	@Test(groups= {"regression","sanity"})
	public void test5() {
		System.out.println("I am at Test5");
	}
	@Test
	public void test6() {
		System.out.println("I am at Test6");
	}
	

}
