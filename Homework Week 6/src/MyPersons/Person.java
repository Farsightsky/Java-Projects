package MyPersons;

public interface Person {													//still learning how to instantiate Person
	default void sayname(String name) {
		System.out.println("My name is "+ name);
	}
	default void sayid(Integer idnum) {
		System.out.println("My personal ID num is "+ idnum);
	}
}
