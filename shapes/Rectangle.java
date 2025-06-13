package boqnkataZada4ka;

public class Rectangle implements Boqnkata_Interface{

	private double a, b;
	
	public Rectangle(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public double area() {
		return a*b;
	}

	@Override
	public double perimeter() {
		return 2*(a+b);
	}

	@Override
	public void printInfo() {
		System.out.println("Area: " + this.area());
		System.out.println("Perimeter: " + this.perimeter());
	}
	
}
