package MyPersons;

public interface Faculty extends Person{
	default void sayHiredYear(Integer hiredYear) {
		System.out.println("I was hired in "+ hiredYear);
	}
}
