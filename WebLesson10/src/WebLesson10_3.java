import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class WebLesson10_3 {
	public static void main(String args[]){
		List<String> optionList = new ArrayList<String>();
		optionList.add("Numbers to Roman Numerals");
		optionList.add("Roman Numerals to Numbers");
		Object[] options = optionList.toArray();
		Object value = JOptionPane.showInputDialog(null, "What would you like to convert?", "input box", 0, null, options, 0);
		if(value.equals("Numbers to Roman Numerals")){
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter in a number or numbers for conversion");
			int s = (int) scan.nextInt();
			new WebLesson10_3().IntToRoman(s);
		}
		else if(value.equals("Roman Numerals to Numbers")){
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter in the Roman Numerals");
			String s = scan.nextLine();
			new WebLesson10_3().RomanToInt(s);
		}
	}

	public static void IntToRoman(int s) {
		String output = "";
		while(s>=1000){
			output += "M";
			s-=1000;
		}
		if(s>=900){
			output += "CM";
			s-=900;
		}
		if(s>=500){
			output += "D";
			s-=500;
		}
		if(s>=400){
			output += "CD";
			s-=400;
		}
		while(s>=100){
			output += "C";
			s-=100;
		}
		if(s>=90){
			output += "XC";
			s-=90;
		}
		if(s>=50){
			output += "L";
			s-=50;
		}
		if(s>=40){
			output += "XL";
			s-=40;
		}
		while(s>=10){
			output += "X";
			s-=10;
		}
		if(s>=9){
			output += "IX";
			s-=9;
		}
		if(s>=5){
			output += "V";
			s-=5;
		}
		if(s>=4){
			output += "IX";
			s-=4;
		}
		while(s>=1){
			output += "I";
			s-=1;
		}
		
		
		System.out.println(output);
		System.out.println("S = "+s);
	}

	public static void RomanToInt(String s) {
		String lets = "MDCLXVI";
		char M = lets.charAt(0);
		char D = lets.charAt(1);
		char C =lets.charAt(2);
		char L =lets.charAt(3);
		char X =lets.charAt(4);
		char V =lets.charAt(5);
		char I =lets.charAt(6);
		int number = 0;
		char n = s.charAt(0);
		char o = s.charAt(1);
		s = s + " ";

		if(n == M){
			s = s.substring(1, s.length());
			number+=1000;
		}

		n = s.charAt(0);
		if(s.length() > 1){
			o = s.charAt(1);
			if(n == C && o == M ){
				s = s.substring(2, s.length());
				number+=900;
			}
		}
		try{
			n = s.charAt(0);
		}
		catch(java.lang.StringIndexOutOfBoundsException e){
			System.out.println(number);
		}
		if(n == D){
			s = s.substring(1, s.length());
			number+=500;
		}
		try{
			n = s.charAt(0);
		}
		catch(java.lang.StringIndexOutOfBoundsException e){
			System.out.println(number);
		}
		if(s.length() > 1){
			o = s.charAt(1);
			if(n == C && o == D){
				s = s.substring(2, s.length());
				number+=400;
			}
		}
		try{
			n = s.charAt(0);
		}
		catch(java.lang.StringIndexOutOfBoundsException e){
			System.out.println(number);
		}
		while(n == C){
			s = s.substring(1, s.length());
			number+=100;
			n = s.charAt(0);
		}
		try{
			n = s.charAt(0);
		}
		catch(java.lang.StringIndexOutOfBoundsException e){
			System.out.println(number);
		}
		if(s.length() > 1){
			o = s.charAt(1);
			if(n == X && o == C){
				s = s.substring(2, s.length());
				number+=90;
			}
		}
		try{
			n = s.charAt(0);
		}
		catch(java.lang.StringIndexOutOfBoundsException e){
			System.out.println(number);
		}
		if(n == L){
			s = s.substring(1, s.length());
			number+=50;
		}
		try{
			n = s.charAt(0);
		}
		catch(java.lang.StringIndexOutOfBoundsException e){
			System.out.println(number);
		}
		if(s.length() > 1){
			o = s.charAt(1);	
			if(n == X && o == L){
				s = s.substring(2, s.length());
				number+=40;
			}
		}
		try{
			n = s.charAt(0);
		}
		catch(java.lang.StringIndexOutOfBoundsException e){
			System.out.println(number);
		}
		while(n == X){
			s = s.substring(1, s.length());
			number+=10;
			n = s.charAt(0);
		}
		try{
			n = s.charAt(0);
		}
		catch(java.lang.StringIndexOutOfBoundsException e){
			System.out.println(number);
		}
		if(s.length() > 1){
			o = s.charAt(1);
			if(n == I && o == X){
				s = s.substring(2, s.length());
				number+=9;
			}
		}
		try{
			n = s.charAt(0);
		}
		catch(java.lang.StringIndexOutOfBoundsException e){
			System.out.println(number);
		}
		if(s.length() > 1){
			o = s.charAt(1);
			if(n == I && o == V){
				s = s.substring(2, s.length());
				number+=4;
			}
		}
		try{
			n = s.charAt(0);
		}
		catch(java.lang.StringIndexOutOfBoundsException e){
			System.out.println(number);
		}
		if(n == V){
			s = s.substring(1, s.length());
			number += 5;
		}
		try{
			n = s.charAt(0);
		}
		catch(java.lang.StringIndexOutOfBoundsException e){
			System.out.println(number);
		}
		while(n == I){
			s = s.substring(1, s.length());
			number+=1;
			try{
				n = s.charAt(0);
			}
			catch(java.lang.StringIndexOutOfBoundsException e){
				n = C;
			}
		}
		System.out.println(number);

	}
}