/**
 * 
 */
package pigLatin_translator;

import java.util.Scanner;

/**
 * @author Sahjan
 *
 * A simple text-based programme that, given a body
 * of text, returns a Pig Latin translation. 
 *
 */
public class Main {
	
	private static boolean isActive;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		isActive = true;
		System.out.println("Enter the text to be translated to Pig Latin. Enter 'bye' to exit.");
		
		while(isActive) {
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			System.out.println(translate(input));
		}	
	}
	
	public static String translate(String text) {
		String translation = "";
		if (text.equals("bye")) {
			isActive = false;
			return "Goodbye.";
		}
		
		String[] words = text.split(" ");

		//ignore numbers
		//check if word ends in punctuation and move this to the end of the translated word
		for (String word : words) {
			if (word.length() > 2 && !startsWithVowel(word)) {
				char firstLetter = word.toLowerCase().charAt(0);
				String noFirstLetter = word.substring(1);
				
				if (Character.isUpperCase(word.charAt(0))) {
					noFirstLetter = noFirstLetter.substring(0, 1).toUpperCase() + noFirstLetter.substring(1);
				}
				if (word.matches(".*\\p{Punct}+")) {
					char punctuationChar = word.charAt(word.length()-1);
					noFirstLetter = noFirstLetter.substring(0, noFirstLetter.length()-1);
					String translatedWord = noFirstLetter + "-" + firstLetter + "ay" + punctuationChar;
					word = translatedWord;
				}
				else {
					String translatedWord = noFirstLetter + "-" + firstLetter + "ay";
					word = translatedWord;
				}
			}
			
			translation = translation + word + " ";
		}
	
		return translation;
	}
	
	public static boolean startsWithVowel(String word) {
		if (word.charAt(0) == 'a' ||
			word.charAt(0) == 'e' ||
			word.charAt(0) == 'i' ||
			word.charAt(0) == 'o' ||
			word.charAt(0) == 'u') {
			return true;
		}
		return false;
	}

}
