package preDefined_FunctionalInterfaces_InJAVA;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterface {
	Integer bonus;
// *All the follwing interfaces are pre-defined functional interfaces present in java.util.function package	
	public static void main(String[] args) {
		predicatePractice();
		FunctionPractice();
		ConsumerPractice();
		supplierPractice();
		/*
		 * calculate bonus for list of a employee and print their names if bonus is
		 * >5000
		 */
		FunctionalInterface obj=new 	FunctionalInterface();
		//employee e = new employee();
		Function<employee, Integer> pre = (w) -> {
			//int bonus = 0;
			if (w.salary < 1000) {
				obj.bonus = (w.salary * 10) / 100;
			} else if (w.salary < 20000) {
				obj.bonus = (w.salary * 13) / 100;
			} else if (w.salary < 50000) {
				obj.bonus = (w.salary * 15) / 100;
			} else
				obj.bonus = (w.salary * 18) / 100;
			return obj.bonus;
		};
		 Predicate<Integer>p=b->obj.bonus>5000;
		List<employee> emplist = new ArrayList<employee>();
		emplist.add(new employee("rahul", 5550000, 2));
		emplist.add(new employee("vishl", 55000, 2));
		emplist.add(new employee("satchin", 30000, 1));
		emplist.add(new employee("binod", 80000, 4));
		for (employee e: emplist) {
			// Integer bonus=pre.apply(l);
			 if(p.test(pre.apply(e)))
				 System.out.print("Name :- "+e.name+" Sallary :- "+e.salary+"  Experience :- "+e.exp+"yrs");
		}

	}

	public static void predicatePractice() {
		// TODO Auto-generated method stub

// syntax :-
//	@FunctionalInterface
//	interface Predicate<T> {
//		abstract boolean test (T t);
//	}

		/**/
		BiPredicate<Integer, Double> Elegiblity = (age, height) -> {
			return (age >= 18 && height >= 6);
		};
		System.out.println(Elegiblity.test(18, 6.2));

		/**/
		BiPredicate<String, String> pre = (a, b) -> {
			return a.equals(b);
		};
		BiPredicate<String, String> pre2 = (a, b) -> {
			return a.equalsIgnoreCase(b);
		};
		boolean a = pre.and(pre2).test("rahul", "rahul");
		System.out.println(a);
		System.out.println(pre.or(pre2).test("rahUl", "raHul"));

		/**/
		Predicate<Integer> p1 = (b) -> {
			return b < 18;
		};
		Predicate<Integer> p2 = (b) -> {
			return b > 6;
		};
		System.out.println(p1.and(p2).test(15));// true
		System.out.println(p1.or(p2).test(1));// true
		System.out.println(p1.and(p2).test(23));// false
		System.out.println(p1.and(p2).test(12)); // true
	}

	public static void FunctionPractice() {
// syntax :-
//		@FunctionalInterface
//		interface Predicate<T> {
//			abstract boolean test (T t);

		/* program to convert name into ASCII COde format as [AB=>65+66=>131] */
		Function<String, Integer> fn = (name) -> {
			int ASCII = 0;
			for (int i = 0; i < name.length(); i++) {
				int j = name.charAt(i);
				ASCII += j;
			}
			return ASCII;
		};
		System.out.println(fn.apply("AB"));

		/* Function_Chaining */
		Function<Integer, Integer> f1 = (n) -> n * 2;
		Function<Integer, Integer> f2 = (n) -> n * n;
		Integer a = f1.andThen(f2).apply(3); /* 3*2=6 → 6*6=36 Answer */
		System.out.println(a);
		Integer b = f1.compose(f2).apply(3); /* 3*3=9 → 9*2=18 Answer */
		System.out.println(b);

	}

	public static void ConsumerPractice() {
		/* Consumer_Chaining */

		Consumer<String> c = i -> System.out.println("Welcome " + i);
		Consumer<String> c1 = i -> System.out.println("Welcome yadav " + i);
		c.andThen(c1).accept("rahul");

	}

	public static void supplierPractice() {
		Supplier<Date> s = () -> {
			return new Date();
		};
		System.out.println(s.get());
		Supplier<String> s1 = () -> "rahul";
		System.out.println(s.get());
	}
}

class employee {
	int salary;
	String name;
	int exp;

	public employee() {
		// TODO Auto-generated constructor stub
	}

	public employee(String name, int salary, int exp) {
		// TODO Auto-generated constructor stub
		this.salary = salary;
		this.exp = exp;
		this.name = name;

	}
}