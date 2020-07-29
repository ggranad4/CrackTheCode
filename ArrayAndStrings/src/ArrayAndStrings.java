import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;
public class ArrayAndStrings {
	public static void main(String[] args) {
		String string = "Gerado1A";
		System.out.println("Is Gerardo1A a unique String: " + isUnique(string));
		System.out.println("Is dog, god permutation: " +isPermutation("god", "dog"));
		System.out.println(urlify("Mr John Smith", 13));
		System.out.println("is atcocta a palidrome : " + isPermutationPalindrome("atcocta"));
		System.out.println("is pales, pale one away: " + isOneAway("pales", "pale"));
		System.out.println("aabcccccaaa compressed is : " + stringCompression("aabcccccaaa"));
	}
	static boolean isUnique(String string) {
		boolean lettersAdded[] = new boolean[128];
		char[] arrayOfLetters = string.toCharArray();
		for(Character character: arrayOfLetters) {
			if(lettersAdded[character]) {
				return false;
			}
			else {
				
				lettersAdded[character] = true;
			}
		}
		return true;
		
	}
	
	static boolean isPermutation(String string1, String string2) {
		char[] c1 = string1.toCharArray();
		char[] c2 = string2.toCharArray();
		
		Arrays.sort(c1);
		Arrays.sort(c2);
		
		string1 = new String(c1);
		string2 = new String(c2);
		if(string1.equals(string2)) {
			return true;
		}
		else {
			return false;
		}
	}
	static String urlify(String inputString, int trueLength) {
		String output = "";
		for(int i = 0; i < trueLength; i++) {
			output += inputString.charAt(i);
		}
		output = output.replace(" ", "%20");
		return output;
	}
	
	static boolean isPermutationPalindrome(String string) {
		HashMap<Character,Integer> letters = new HashMap<Character,Integer>();
		int oddCounter = 0;
		for(int i =0; i < string.length(); i++) {
			if(letters.containsKey(string.charAt(i))) {
				letters.put(string.charAt(i), letters.get(string.charAt(i)) + 1);
			}
			else {
				letters.put(string.charAt(i), 1);
			}
			
		}
		for(Entry entry: letters.entrySet()) {
			int value = (int) entry.getValue();
			if(value % 2 == 1) {
				oddCounter++;
			}
		}
		return oddCounter <= 1;
	}
	static boolean isOneAway(String string1, String string2) {
		HashMap<Character, Integer> letters = new HashMap<>();
		for(int i = 0; i < string1.length(); i++) {
			if(letters.containsKey(string1.charAt(i))) {
				letters.put(string1.charAt(i), letters.get(string1.charAt(i)) + 1);
			}
			else {
			letters.put(string1.charAt(i),1);
			}
		}
		
		for(int i = 0; i < string2.length(); i++) {
			if(letters.containsKey(string2.charAt(i))) {
				letters.put(string2.charAt(i), letters.get(string2.charAt(i)) + 1);
			}
			else {
			letters.put(string2.charAt(i),1);
			}
		}
		String letter1 = "";
		for(Entry entry: letters.entrySet()) {
			int valueOfLetter = (int) entry.getValue();
			if(valueOfLetter == 1) {
				if(string1.replace(letter1, "").replace(entry.getKey() + "", "").equals(string2.replace(letter1, "").replace(entry.getKey() + "", ""))) return true;
				letter1 = entry.getKey() + "";
			}
		}
		return false;
	}
	
	static String stringCompression(String stringInput) {
		HashMap<Character,Integer> letters = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < stringInput.length(); i++) {
			if(!letters.containsKey(stringInput.charAt(i)) && letters.isEmpty()) {
				letters.put(stringInput.charAt(i), 1);
			}
			else if(letters.containsKey(stringInput.charAt(i))) {
				letters.put(stringInput.charAt(i), letters.get(stringInput.charAt(i)) + 1);
			}
			else{
				sb.append(stringInput.charAt(i-1) + "" +letters.get(stringInput.charAt(i-1)));
				letters.clear();
				letters.put(stringInput.charAt(i), 1);
			}
		}
		sb.append(stringInput.charAt(stringInput.length() -1) + "" + letters.get(stringInput.charAt(stringInput.length() -1)));
		return sb.toString();
	}
	
	
}
