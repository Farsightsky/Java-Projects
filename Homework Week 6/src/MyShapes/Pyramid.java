package MyShapes;

public class Pyramid extends RightTriangle{
	public void volume() {
		System.out.println("The volume of a pyramid with a surface area of "+this.area+" square units, a height of "+ height +" units, and a square base is "+(Math.pow(this.area,2)*height)/(6*(2*Math.pow(height, 2)+this.area))+" cube units");
	}
}
