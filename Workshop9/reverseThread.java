package reverse;

public class ReverseThread extends Thread {
	
	public void run() {
		for (int i = 49; i > 0; i--) {
			System.out.println("Hello from Thread " + (i + 1));
		}
	}

	public static void main(String[] args) {
		ReverseThread t[] = new ReverseThread[50];
		for (int i = 0; i < 50; i++) {
			t[i] = new ReverseThread();
		}
		
		for (int i = 49; i > 0; i--) {
			t[i].start();
		}
	}
}
