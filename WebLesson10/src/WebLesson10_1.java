import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class WebLesson10_1 {
	char vowel;
	String englishWord = "";
	String converted = "";
	boolean done = false;
	public static void main(String args[]){
		List<String> optionList = new ArrayList<String>();
		optionList.add("Test For Palindromes");
		optionList.add("Engage Pig Latinizer");
		optionList.add("Shorthand sentences");
		Object[] options = optionList.toArray();
		Object value = JOptionPane.showInputDialog(null, "What would you like to do?", "input box", 0, null, options, 0);
		if(value.equals("Test For Palindromes"))
			new WebLesson10_1().startPalindroming();
		else if(value.equals("Engage Pig Latinizer"))
			new WebLesson10_1().startPigging();
		else if(value.equals("Shorthand sentences")){
			Scanner scan = new Scanner(System.in);
			System.out.println("Type a sentence on the next line and hit enter to write shorthand");
			String pally = scan.nextLine();
			new WebLesson10_1().shortHanding(pally);
		}
			
	}


	public void startPalindroming(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Type a sentence on the next line and hit enter to test for palindromes");
		String pally = scan.nextLine();
		String dromey = pally.replace("\\W", "");
		String pallyTest = pally.replace("\\W", "");
		pallyTest = pallyTest.toLowerCase();
		dromey = dromey.toLowerCase();
		System.out.println("Stripped string: " + dromey);
		int scanList = dromey.length()-1;
		int otherScanList = dromey.length()+1;
//		System.out.println(scanList + " is scanlist");
		String newPally = new String("");
		try{
			for(int looper = 1; looper < otherScanList; looper++){
				char thing = dromey.charAt(scanList);
				newPally += thing;
				dromey = dromey.substring(0, dromey.length()-1);
				scanList = dromey.length()-1;
			}
		}
		catch(java.lang.StringIndexOutOfBoundsException e){
			System.out.println("It died!!!");
		}
//		System.out.println(newPally + " is new Pally");
//		System.out.println(pallyTest);
		if(newPally.equals(pallyTest))
			System.out.println("Congrats, '"+pally+"' is a palindrome!");
		else
			System.out.println("Sorry, no palindrome here!");
	}


	public void startPigging() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Type a sentence on the next line and hit enter to convert to Pig Latin");
		String entered = scan.nextLine();
		entered = entered.toLowerCase();
		System.out.println("You entered "+entered);
		recurSplitter(entered, 1);
//		vowelTest(entered, 0, entered.length());
	}
	
	private void recurSplitter(String entered, int loc){
		if(Character.isWhitespace(entered.charAt(loc-1))||loc-1 >= entered.length()){
			String tester = entered.substring(0, loc-1);
			vowelTest(tester, 0, tester.length());
			String nextTest = entered.substring(loc,entered.length());
			try{
				recurSplitter(nextTest, 1);}
			catch(java.lang.AbstractMethodError e){
				System.out.println(e.getMessage());
				System.out.println(nextTest+ " has failed, recursion is damaged");
			}
		}
		else{
			if(loc>=entered.length()){
				done = true;
				vowelTest(entered, 0, entered.length());
				return;
			}
			recurSplitter(entered, loc+=1);
		}
	}

	private void vowelTest(String entered,int firstnum, int length) {
		String vowels = "aeiou";
		char A = vowels.charAt(0);
		char E = vowels.charAt(1);
		char I = vowels.charAt(2);
		char O = vowels.charAt(3);
		char U = vowels.charAt(4);
		for(int looper = 0; looper < entered.length(); looper++){
			char test = entered.charAt(looper);
			if(test == A || test == E || test == I || test == O || test == U){
				if(looper == 0){
					converted = entered+"yay ";
					englishWord = englishWord+converted;
					if(done = true)
						System.out.println(englishWord);
					return;
				}
				String toEnd = entered.substring(0,looper);
				entered = entered.substring(looper,length);
				converted = entered+toEnd+"ay ";
				englishWord = englishWord+converted;
				if(done = true)
					System.out.println(englishWord);
				looper = entered.length();
				return;
			}
		}
		converted = entered+"ay ";
		englishWord = englishWord+converted;
		if(done = true)
			System.out.println(englishWord);
	}
	public void shortHanding(String s){
		if(done == true)
			return;
		else{
			int loc = 1;
			while(done == false){	
				if(loc >= s.length()){	
					shortHandler(s);
					vowelSearch(englishWord);
					System.out.println("Completed string.");
					System.out.println(englishWord);
					done = true;
					return;
				}
				if(Character.isWhitespace(s.charAt(loc-1))){
					String redo = s.substring(loc, s.length());
					String rerouter = s.substring(0,loc);
					
					shortHandler(rerouter);
					shortHanding(redo);
				}
				loc+=1;
			}
		}
	}


	private void vowelSearch(String eng) {
		String vowels = "aeiou";
		char A = vowels.charAt(0);
		char E = vowels.charAt(1);
		char I = vowels.charAt(2);
		char O = vowels.charAt(3);
		char U = vowels.charAt(4);
		for(int looper = 0; looper < eng.length(); looper++){
			char test = eng.charAt(looper);
			if(test == A || test == E || test == I || test == O || test == U){
				String beg = eng.substring(0,looper);
				String end = eng.substring(looper+1, eng.length());
				converted =beg + end;
				System.out.println(englishWord);
			} 
		}
	}


	private void shortHandler(String s) {
		if(s.equals("you ")||s.equals("You ")){
			s = "u ";
			englishWord = englishWord + s;
		}
		else if(s.equals("to ")||s.equals("To ")){
			s = "2 ";
			englishWord = englishWord + s;
		}
		else if(s.equals("and ")||s.equals("And ")){
			s = "& ";
			englishWord = englishWord + s;
		}
		else if(s.equals("for ")||s.equals("For ")){
			s = "4 ";
			englishWord = englishWord + s;
		}
		else
			englishWord = englishWord + s;
	}
	
}
