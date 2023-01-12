package FunctionalProgramingFeatures;

@FunctionalInterface // interface containing only one abstract method and multiple default ,static  and private methods
interface cab {
	abstract public void bookCab();

	default void m2() {

	}
}

public class anonymousFunctions {
	public static void main(String[] args) {
		cab a = () -> System.out.println("ola Cab Booked");
		a.bookCab();
		cab b = () -> System.out.println("asdf Cab Booked");
		b.bookCab();
	}
}
