package backtojava;

import java.io.File;
import java.util.regex.*;
import java.util.Scanner;

public class FirstClass {
	
	public static void validateEntry() {
		
		System.out.println("Welcome, press q to quit\n");
		
		Scanner input = new Scanner(System.in);
		String entry = "";
		
		while(entry != "q") {
			System.out.print("Enter something: ");
			entry = input.nextLine();
			System.out.println(entry);
			System.out.println();
			
			if(entry != "q" && entry.length() > 1) {
				if(matchPattern("[0-9]+", entry)) {
					System.out.println("Invalid entry! Numbers are not allowed\n");
				}
				else {
					System.out.println("Whoa! You valid!\n");
					break;
				}
			}
			else {
				break;
			}
			
		}
		input.close();
		System.out.println("Quiting application...");
	}
	
	public static boolean matchPattern(String regex, String strToMatch) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(strToMatch);
		
		return m.find();
	}

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("45");
		System.out.println(sb);
		
		validateEntry();
		
//		System.out.println(sb.length());
		
		
		
		
//		System.out.println(m.find());
		
		
	}

}
