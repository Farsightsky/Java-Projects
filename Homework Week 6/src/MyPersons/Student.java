package MyPersons;

public interface Student extends Person{
	default void sayAdmitYear(Integer admitYear) {
		System.out.println("I was admitted in "+ admitYear);
	}
	
	default void sayGWA(float GWA) {
		System.out.println("My GWA is "+ GWA);
	}
}
