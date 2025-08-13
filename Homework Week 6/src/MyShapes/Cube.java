package MyShapes;

public class Cube extends Circle{
	public void volume() {
		System.out.println("The volume of a cube with a surface area of "+this.area+" square units is "+(this.area*Math.sqrt(this.area/(4*Math.PI)))/3+" cube units");
	}
}
