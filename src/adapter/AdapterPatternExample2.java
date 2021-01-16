package adapter;

import java.util.ArrayList;
import java.util.List;

interface RectInterface {
	void aboutRectangle();

	double calculateAreaOfRectangle();
}

class Rectangle2 implements RectInterface {
	public double length;
	public double width;

	public Rectangle2(double length, double width) {
		this.length = length;
		this.width = width;
	}

	@Override
	public void aboutRectangle() {
		System.out
				.println("Rectangle object with length : " + this.length + "unit and width : " + this.width + "unit.");
	}

	@Override
	public double calculateAreaOfRectangle() {
		return length * width;
	}
}

interface TriInterface {
	void aboutTriangle();

	double calculateAreaOfTriangle();
}

class Triangle2 implements TriInterface {

	public double base;
	public double height;

	public Triangle2(double base, double height) {
		this.base = base;
		this.height = height;
	}

	@Override
	public void aboutTriangle() {
		System.out.println("Triangle object with base : " + this.base + "unit and height : " + this.height + "unit.");
	}

	@Override
	public double calculateAreaOfTriangle() {
		return 0.5 * base * height;
	}
}

class TriangleAdapter implements RectInterface {

	Triangle2 triangle;

	TriangleAdapter(Triangle2 t) {
		this.triangle = t;
	}

	@Override
	public void aboutRectangle() {
		triangle.aboutTriangle();
	}

	@Override
	public double calculateAreaOfRectangle() {
		return triangle.calculateAreaOfTriangle();
	}
}

public class AdapterPatternExample2 {

	public static void main(String[] args) {
		System.out.println("*** Adapter Pattern Modified Demo ***\n");

		Rectangle2 rectangle = new Rectangle2(20, 10);
		System.out.println("Area of Rectangle is : " + rectangle.calculateAreaOfRectangle() + " Square unit.");

		Triangle2 triangle = new Triangle2(10, 5);
		System.out.println("Area of Triangle is : " + triangle.calculateAreaOfTriangle() + " Square unit.");

		RectInterface adapter = new TriangleAdapter(triangle);
		System.out.println("Area of Triangle using the triangle adapter is : " + getArea(adapter) + " Square unit.");
		
		List<RectInterface> rectangleObjects = new ArrayList<RectInterface>();
		
		rectangleObjects.add(rectangle);
		//rectangleObjects.add(triangle); //error
		rectangleObjects.add(adapter); // OK.
		
		System.out.println("");
		System.out.println("*** Current Objects in the system are : ****");
		for(RectInterface rectObjects : rectangleObjects) {
			rectObjects.aboutRectangle();
		}
	}
	
	static double getArea(RectInterface r) {
		return r.calculateAreaOfRectangle();
	}

}
