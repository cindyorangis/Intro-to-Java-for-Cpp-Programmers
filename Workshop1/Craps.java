import java.util.Random;

public class Carps {
	static int m_die1;
	static int m_die2;
	static int m_sum;
	static int m_point;
	static boolean done = false;
	
	public static void main(String[] args) {
		m_die1 = rollDie();
		m_die2 = rollDie();
		m_sum = m_die1 + m_die2;
		System.out.println("You rolled " + m_die1 + " + " + m_die2 + " = " + m_sum);
		
		firstRound();
	}
	
	public static int rollDie() {
		int roll = new Random().nextInt(6) + 1;
		return roll;
	}
	
	public static void firstRound() {
		if (m_sum == 7 || m_sum == 11) {
			System.out.println("You win");
				
		} else if (m_sum == 2 || m_sum == 3 || m_sum == 12) {
			System.out.println("You lose");
				
		} else {
			m_point = m_sum;
			System.out.println("point is " + m_point);
			pointsRound();
		} 
	}
	
	public static void pointsRound() {
		while (!done) {
			m_die1 = rollDie();
			m_die2 = rollDie();
			m_sum = m_die1 + m_die2;
			System.out.println("You rolled " + m_die1 + " + " + m_die2 + " = " + m_sum);
			
			if (m_sum == 7) {
				done = true;
				System.out.println("You lose");
				
			} else if (m_point == m_sum){
				done = true;
				System.out.println("You win");
				
			} else {
				done = false;
				System.out.println("point is " + m_point);
				
			}
		}
	}
}
