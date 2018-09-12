import java.util.*;

import javax.swing.JOptionPane;

public class WebLesson10_2 {
	String make;
	String model;
	String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static void main(String[] args) {
		new WebLesson10_2().start();
	}
	
	public void start(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the make and the model of the car like so:");
		System.out.println("'Make Model'");
		make = scan.nextLine();
		makeSyntaxCheck(make);
		System.out.println("Now please enter the license plate, in this format:.");
		System.out.println("'ABC 123'");
		String license = scan.nextLine();
		char onec = license.charAt(0);
		char twoc = license.charAt(1);
		char trec = license.charAt(2);
		String fourc = ""+license.charAt(4);
		String fivec = ""+license.charAt(5);
		String sixc = ""+license.charAt(6);
		int one = (int) onec;
		int two = (int) twoc;
		int tre = (int) trec;
		int four = Integer.parseInt(fourc)*100;
		int five = Integer.parseInt(fivec)*10;
		int six = Integer.parseInt(sixc);
		int sum = one + two + tre + four + five + six;
		int rem = sum%26;
		char codes = alphabet.charAt(rem);
		String code = ""+codes+sum;
		System.out.println("- Valet Ticket -");
		System.out.printf("%5s", make+ " "+model);
		System.out.println("");
		System.out.println(code);
	}
	
	
	
	public void makeSyntaxCheck(String s){
		boolean spacer = false;
		int loc = 0;
		while(spacer == false){	
			if(loc >= s.length()){
				System.out.println("You didn't use the proper syntax, we found no spacing!");
				return;
			}
			if(Character.isWhitespace(s.charAt(loc))){
				model = s.substring(loc+1, s.length());
				make = make.substring(0,loc);
				spacer = true;
			}
			loc+=1;
		}
	}
}
