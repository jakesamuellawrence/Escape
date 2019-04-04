package escape;

import java.util.ArrayList;
import java.util.Scanner;

import escape.items.Interacteable;
import escape.items.Wardrobe;

public class TextManager{
	
	static ArrayList<Interacteable> in_room = new ArrayList<Interacteable>();
	
	static Scanner input_reader = new Scanner(System.in);
	
	public static void initialise(){
		in_room.add(new Wardrobe());
	}
	
	public static void decribeRoom(){
		say("Looking around the room you see: ");
		for(int i = 0; i < in_room.size(); i++){
			say(in_room.get(i).getDescription());
		}
	}
	
	public static void say(String message){
		System.out.println(message);
	}
	
	public static String ask(String question){
		System.out.println(question);
		return input_reader.nextLine();
	}
}
