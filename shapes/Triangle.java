package boqnkataZada4ka;


public class Triangle implements Boqnkata_Interface{
	private double a, b, c;
	
	public Triangle(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	@Override
	public double area() {
		return (1.0/4)*Math.sqrt(4*a*a*b*b - Math.pow(a*a + b*b - c*c, 2));
	}
	@Override
	public double perimeter() {
		return a+b+c;
	}
	
	@Override
	public void printInfo() {
		System.out.printf("Area: %.2f%n",this.area());
		System.out.printf("Perimeter: %.2f%n", this.perimeter());
	}
}
