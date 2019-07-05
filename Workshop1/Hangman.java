import java.util.Random;
//import java.util.Arrays;
import java.util.Scanner;

public class Hangman {
	static String[] m_words = { "dungeon", "dragon", "bard", "barbarian", "sorcerer", "warlock" };
	static String m_selectedWord;
	static char[] m_enteredLetters;
	static int m_attempts = 0;
	static int m_pos;
	static boolean m_asteriskPrinted = false;
	static boolean m_gameOver = false;
	
	public static void main(String[] args) {
		m_selectedWord = getWord(m_words);
		m_enteredLetters = new char[m_words[3].length()];
		
		while (!m_gameOver) {	
			System.out.print("(Guess) Enter a letter in word ");
			
			blockedWord(m_words, m_enteredLetters);
			
			System.out.print(" [" + m_selectedWord.length() + " letters] > ");
			
			Scanner scan = new Scanner(System.in);
			char input = scan.nextLine().charAt(0);

			
			char lowerInput = java.lang.Character.toLowerCase(input);
			
			if (letterGuessed(lowerInput, m_enteredLetters)) {
				System.out.println(lowerInput + " is already in the word");
				
			} else if (m_selectedWord.contains(String.valueOf(lowerInput))) {
				int m_pos = pos(m_enteredLetters);
				m_enteredLetters[m_pos] = lowerInput;
				m_attempts++;
				
			} else {
				System.out.println(lowerInput + " is not in the word");
				m_attempts++;
			}
		}
		System.out.print("The word is " + m_selectedWord);
		System.out.print(". You missed " + m_attempts + " time(s)");
		System.out.print("\nDo you want to guess another word? Enter y or n> ");
	}
	
	public static String getWord(String[] m_words) {
		int i = new Random().nextInt(m_words.length);
		return new String(m_words[i]);
	}
	
	public static boolean blockedWord(String[] string, char[] enteredLetters) {
		for (int i = 0; i < m_selectedWord.length(); i++) {
			char letter = m_selectedWord.charAt(i);
			
			if (letterGuessed(letter, m_enteredLetters)) {
				System.out.print(letter);
			} else {
				System.out.print('*');
				m_asteriskPrinted = true;
			}
		}
		return m_asteriskPrinted;
	}
	
	public static boolean letterGuessed(char letter, char[] m_enteredLetters) {
		return new String(m_enteredLetters).contains(String.valueOf(letter));
	}
	
	public static int pos(char[] m_enteredLetter) {
		int i = 0;
		while (m_enteredLetters[i] != '\0') {
			i++;
		};
		return i;
	}
}
