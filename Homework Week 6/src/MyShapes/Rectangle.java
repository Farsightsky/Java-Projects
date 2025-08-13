package MyShapes;

public class Rectangle extends Shapes{
	public float perimeter;
	
//I assume that this particular rectangle is a square based on the UML.
	
	public void perimeter() {
		System.out.println("The perimeter of the largest rectangle with an area of "+this.area+" square units is "+Math.sqrt(this.area)*4+ " units");
	}
}
 