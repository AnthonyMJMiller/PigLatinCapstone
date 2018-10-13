package pigLatinProject;

import java.util.Scanner;

public class Wk1Capstone {

	public static String pigLatinConverter(String convert) {

		String initiate;

		initiate = "";
		int icount = 0;
		while (icount < convert.length()) {

			while (icount < convert.length() && !isLetter(convert.charAt(icount))) {
				initiate = initiate + convert.charAt(icount);
				icount++;
			}

			if (icount >= convert.length())
				break;

			int begin = icount;
			while (icount < convert.length() && isLetter(convert.charAt(icount))) {
				icount++;
			}

			int end = icount;
			initiate = initiate + pigWord(convert.substring(begin, end));

		}
		return initiate;
	}

	public static String pigWord(String word) {
		int split = firstVowel(word);
		if (split != 0) {
			return word.substring(split) + word.substring(0, split) + "ay";
		} else {
			return word.substring(split) + word.substring(0, split) + "way";
		}
	}

	public static int firstVowel(String word) {
		word = word.toLowerCase();
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o'
					|| word.charAt(i) == 'u') {
				return i;
			}
			
		}
		return 0;
	}

	private static boolean isLetter(char check) {
		return ((check >= 'A' && check <= 'Z') || (check >= 'a' && check <= 'z'));
	}

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		String enter;
		do {
			System.out.println(
					"Hi, welcome to the Pig Latin Translator app.\nPlease enter in a word and/or sentence so I can translate it to pig latin: ");

			enter = key.nextLine();

			String translate = pigLatinConverter(enter);

			System.out.println("The translation for " + enter + " is: " + translate);

			System.out.println("Would you like to try another word and/or sentence? (Type Yes to continue or any other key to stop)");
			enter = key.nextLine();
		} while (enter.equalsIgnoreCase("Yes"));

		System.out.println("Thank you for using the Pig Latin Translator. Goodbye!");

		key.close();

	}

}
