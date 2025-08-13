package MyShapes;

public class Circle extends Shapes{
	public void circumference() {
		System.out.println("The circumference of a circle with an area of "+this.area+" square units is "+2*Math.PI*Math.sqrt(this.area/Math.PI)+ " units");
	}
}
