package MyShapes;

public abstract class Shapes {
	public class Rectangle {
	}
	
	public class Square {
	}

	public class Cube {
	}
	
	public class Circle {
	}
	
	public float area;
	
	public void area(float area) {																	//remember to convert the double values into float in test class like setArea((float)n); wherein n is considered as double. This applies to functions with the float parameters. Thanks for reading the comments.
		this.area = area;
		System.out.println("The area of the shape is "+this.area+" units");
	}
}
