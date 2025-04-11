package testove;

import java.util.*;

public class Complex {
	
	private double re, im;
	private final double TOLERANCE = 1e-12;
	String value_str;

	Complex(double re, double im){
		this.re = re;
		this.im = im;
		
		if (Math.abs(re) < TOLERANCE && Math.abs(im) < TOLERANCE) {
			this.value_str = "0";
		} else if (Math.abs(re) < TOLERANCE) {
			if (Math.floor(im) == im) {
				this.value_str = Integer.toString((int)im);
			} else {
				this.value_str = Double.toString(im);
			}
			this.value_str += "i";
		} else if (Math.abs(im) < TOLERANCE) {
			if (Math.floor(re) == re) {
				this.value_str = Integer.toString((int)re);
			} else {
				this.value_str = Double.toString(re);
			}
		} else {
			if (Math.floor(re) == re) {
				this.value_str = Integer.toString((int)re);
			} else {
				this.value_str = Double.toString(re);
			}
			if (im > 0) {
				if (Math.floor(im) == im) {
					this.value_str += "+" + Integer.toString((int)im);
				} else {
					this.value_str += "+" + Double.toString(im);
				}
				this.value_str += "i";
			} else {
				if (Math.floor(im) == im) {
					this.value_str += Integer.toString((int)im);
				} else {
					this.value_str += Double.toString(im);
				}
				this.value_str += "i";
			}
		}
		
	}
	
	public boolean equals(Complex number) {
		if (this.re == number.re && this.im == number.im) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean equals(double number) {
		if (this.re == number && this.im == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public Complex opposite() {
		return new Complex(-this.re, -this.im);
	}
	
	public Complex add(Complex number) {
		return new Complex(this.re + number.re, this.im + number.im);
	}
	
	public Complex add(double number) {
		return new Complex(this.re + number, this.im);
	}
	
	public Complex subtract(Complex number) {
		return this.add(number.opposite());
	}
	
	public Complex subtract(double number) {
		return this.add(-number);
	}
	
	public Complex multiply(Complex number) {
		return new Complex(this.re * number.re - this.im * number.im, this.re * number.im + this.im * number.re);
	}
	
	public Complex multiply(double number) {
		return new Complex(this.re * number, this.im * number);
	}
	
	public Complex divide(Complex number) {
		double divisor = Math.pow(number.re, 2) + Math.pow(number.im, 2);
		if (divisor == 0) {
			throw new IllegalArgumentException("Cannot divide by zero!");
		} else {
			return new Complex((this.re * number.re + this.im * number.im)/divisor , (this.im * number.re - this.re * number.im)/divisor);
		}
	}
	
	public Complex divide(double number) {
		if(number == 0) {
			throw new IllegalArgumentException("Cannot divide by zero!");
		} else {
			return new Complex(this.re / number, this.im / number);
		}
	}
	
	public Complex pow(int number) {
		Complex result = new Complex(1, 0);
		
		if (number == 0) {
			return result;
		}
		
		for (int i = 0; i < Math.abs(number); i++) {
			result = result.multiply(this);
		}
		
		if (number < 0) {
			return new Complex(1, 0).divide(result);
		}
		
		return result;
	}
	
	public Complex[] root(int number) {
		
//		if (this.im == 0) {
//			return new Complex[] {new Complex(Math.pow(this.re, 1.0/number),0)};
//		}
		
		double angle = Math.atan2(this.im, this.re);
		double r = Math.sqrt(Math.pow(this.re, 2) + Math.pow(this.im, 2));
		
		
		Complex[] roots = new Complex[number];
		
		
		for (int k = 0; k < number; k++) {
			double expression = (angle + 2*Math.PI*k)/number;
			double re = Math.pow(r, 1.0/number) * Math.cos(expression);
			double im = Math.pow(r, 1.0/number) * Math.sin(expression);
			roots[k] = new Complex(re, im);
		}
		
		return roots;
	}
	
	
}
