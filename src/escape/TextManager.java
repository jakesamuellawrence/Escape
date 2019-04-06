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
		say("");
		parseCommand(ask("What would you like to do?"));
	}
	
	static void parseCommand(String command){
		command = command.toLowerCase();
		String[] command_words = command.split(" ");
		if(command_words[0].equals("look")){
			parseLookCommand(command_words);
		}
		else{
			say("You're not quite sure how to '" + command + "' in this situation");
		}
		say("");
		parseCommand(ask("What would you like to do?"));
	}
	
	static void parseLookCommand(String[] command_words){
		String target_name = "";
		for(int i = 1; i < command_words.length; i++){
			if(!command_words[i].equals("at")){
				target_name += command_words[i] + " ";
			}
		}
		target_name = target_name.trim();
		Interacteable target = findItem(target_name);
		if(target != null){
			target.lookAt();
		}
		else{
			say("You look around the room but you can't seem to find a " + target_name + " :(");
		}
	}
	
	static Interacteable findItem(String target_name){
		for(int i = 0; i < in_room.size(); i++){
			if(in_room.get(i).getName().equals(target_name)){
				return in_room.get(i);
			}
		}
		return null;
	}
	
	public static void say(String message){
		System.out.println(message);
	}
	
	public static String ask(String question){
		System.out.println(question);
		return input_reader.nextLine();
	}
}
