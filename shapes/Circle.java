package boqnkataZada4ka;

public class Circle implements Boqnkata_Interface{
	
	private double r;
	
	public Circle(double r) {
		this.r = r;
	}

	@Override
	public double area() {
		return Math.PI * this.r * this.r;
	}

	@Override
	public double perimeter() {
		return 2 * Math.PI * this.r;
	}

	@Override
	public void printInfo() {
		System.out.println("Area: " + this.area());
		System.out.println("Perimeter: " + this.perimeter());
	}
}
