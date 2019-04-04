package escape;

import java.util.Scanner;

public class TextManager{
	
	static Scanner input_reader = new Scanner(System.in);
	
	public static void say(String message){
		System.out.println(message);
	}
	
	public static String ask(String question){
		System.out.println(question);
		return input_reader.nextLine();
	}
}
