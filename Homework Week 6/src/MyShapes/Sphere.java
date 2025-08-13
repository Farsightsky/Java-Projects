package MyShapes;

public class Sphere extends Circle{
	public void volume() {
		System.out.println("The volume of a sphere with a surface area of "+this.area+" square units is "+(area/6)*(Math.sqrt(area/6))+" cube units");
	}
}
