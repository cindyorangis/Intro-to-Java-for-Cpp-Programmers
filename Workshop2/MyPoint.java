import java.lang.Math;

public class MyPoint {
	double m_x, m_y;
	
	public double getX() {
		return m_x;
	}
	
	public double getY() {
		return m_y;
	}

	public MyPoint() {
		m_x = 0;
		m_y = 0;
	}
	
	public MyPoint(double x, double y) {
		m_x = x;
		m_y = y;
	}
	
	public double distance(MyPoint mp) {
		return Math.sqrt(Math.pow(mp.getX() - m_x, 2) + 
				Math.pow(mp.getY() - m_y, 2));
	}
	
	public double distance(double x, double y) {
		return distance(new MyPoint(x, y));
	}
}
