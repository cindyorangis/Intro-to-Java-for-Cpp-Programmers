import java.awt.geom.Line2D;

public class Triangle2D {
	static MyPoint m_p1, m_p2, m_p3;
	
	public static MyPoint getP1() {
		return m_p1;
	}
	
	public static MyPoint getP2() {
		return m_p2;
	}
	
	public static MyPoint getP3() {
		return m_p3;
	}
	
	public static void setP1(MyPoint p1) {
		m_p1 = p1;
	}
	
	public static void setP2(MyPoint p2) {
		m_p2 = p2;
	}
	
	public static void setP3(MyPoint p3) {
		m_p3 = p3;
	}
	
	public Triangle2D() {
		m_p1 = new MyPoint(0, 0);
		m_p2 = new MyPoint(1, 1);
		m_p3 = new MyPoint(2, 5);
	}
	
	public Triangle2D(MyPoint p1, MyPoint p2, MyPoint p3) {
		m_p1 = p1;
		m_p2 = p2;
		m_p3 = p3;
	}
	
	public static double getPerimeter() {
		double side1 = m_p1.distance(getP2());
		double side2 = m_p2.distance(getP3());
		double side3 = m_p3.distance(getP1());
		double perimeter = side1 + side2 + side3;
		return perimeter;
	}
	
	public static double getArea() {
		double s = getPerimeter()/2;
		double area = Math.sqrt((s * (s - m_p1.distance(getP2()))) * (s - m_p2.distance(getP3())) * (s - m_p3.distance(getP1())));
		return area;
	}
	
	public static boolean contains(MyPoint p) {
		boolean result;
		double triangle1 = ((m_p2.getY() - m_p3.getY()) * (p.getX() - m_p3.getX()) +
							(m_p3.getX() - m_p2.getX() * (p.getY() - m_p3.getY())) / 
								((m_p2.getY() - m_p3.getY()) * (m_p1.getX() - m_p3.getX()) + 
								(m_p3.getX() - m_p2.getX() * (m_p1.getY() - m_p3.getY()))));
		
		double triangle2 = ((m_p3.getY() - m_p1.getY()) * (p.getX() - m_p3.getX()) +
							(m_p1.getX() - m_p3.getX() * (p.getY() - m_p3.getY())) / 
								((m_p2.getY() - m_p3.getY()) * (m_p1.getX() - m_p3.getX()) + 
								(m_p3.getX() - m_p2.getX() * (m_p1.getY() - m_p3.getY()))));
		if ((1 - triangle1 - triangle2) > 0) {
			result = true;
		} else {
			result =  false;
		}
		return result;		
	}
	
	
	public boolean contains(Triangle2D t) {
		boolean result = true;
		return result;
	}
	
	public boolean overlaps(Triangle2D t) {
		boolean result = true;
		return result;
	}
	
	
	public static void main(String[] args) {
		Triangle2D t1 = new Triangle2D(new MyPoint(2.5, 2), new MyPoint(4.2,3), new MyPoint(5, 3.5));

		//t1.contains(3,3);
		t1.contains(new Triangle2D(new MyPoint(2.9,2), new MyPoint(4,1), new MyPoint(1,3.4)));
		t1.overlaps(new Triangle2D(new MyPoint(2, 5.5), new MyPoint(4,-3), new MyPoint(2,6.5)));
		
		System.out.printf("The area is: %.2f", getArea());
		System.out.printf("\nThe perimeter is: %.2f", getPerimeter());
		
		/*if (t1.contains(3,3)) {
			System.out.print("The point is inside this triangle");
		} else {
			System.out.print("The point is NOT inside this triangle");
		}*/	
		
		if (t1.contains(new Triangle2D(new MyPoint(2.9,2), new MyPoint(4,1), new MyPoint(1,3.4)))) {
			System.out.print("\nThe specified triangle is inside this triangle");
		} else {
			System.out.print("\nThe specified triangle is NOT inside this triangle");
		}
		
		if (t1.overlaps(new Triangle2D(new MyPoint(2, 5.5), new MyPoint(4,-3), new MyPoint(2,6.5)))) {
			System.out.print("\nThe specified triangle does overlaps this triangle");
		} else {
			System.out.print("\nThe specified triangle does NOT overlap this triangle");
		}
	}
}
