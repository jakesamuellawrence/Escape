package escape;

import java.util.ArrayList;
import java.util.Scanner;

import escape.items.Item;
import escape.rooms.Bedroom;
import escape.rooms.Room;

public class InteractionManager{
	
	static ArrayList<Room> rooms = new ArrayList<Room>();
	static Room current_room;
	
	static Scanner input_reader = new Scanner(System.in);
	
	public static void initialise(){
		rooms.add(new Bedroom());
		current_room = rooms.get(0);
	}
	
	public static void decribeRoom(){
		say("Looking around the room you see: ");
		say(current_room.getDescription());
		say("");
		parseCommand(ask("What would you like to do?"));
	}
	
	static void parseCommand(String command){
		command = command.toLowerCase();
		String[] command_words = command.split(" ");
		if(command_words[0].equals("look")){
			handleLookCommand(command_words);
		}
		else if(command_words[0].equals("use")){
			handleUseCommand(command_words);
		}
		else{
			say("You're not quite sure how to '" + command + "' in this situation");
		}
		say("");
		parseCommand(ask("What would you like to do?"));
	}
	
	static void handleLookCommand(String[] command_words){
		String target_name = "";
		for(int i = 1; i < command_words.length; i++){
			if(!command_words[i].equals("at")){
				target_name += command_words[i] + " ";
			}
		}
		target_name = target_name.trim();
		Item target = current_room.findItem(target_name);
		if(target != null){
			target.lookAt();
		}
		else{
			say("You look around the room but you can't seem to find a " + target_name + " :(");
		}
	}
	
	static void handleUseCommand(String[] command_words){
		String target_name = "";
		for(int i = 1; i < command_words.length; i++){
			if(!command_words[i].equals("with")){
				target_name += command_words[i] + " ";
			}
			else{
				handleUseWithCommand(command_words, target_name, i);
				return;
			}
		}
		target_name = target_name.trim();
		Item target = current_room.findItem(target_name);
		if(target != null){
			target.use();
		}
		else{
			say("You look around the room but you can't seem to find a " + target_name + " :(");
		}
	}
	
	static void handleUseWithCommand(String[] command_words, String target_1_name, int index_of_with){
		String target_2_name = "";
		for(int i = index_of_with+1; i < command_words.length; i++){
			target_2_name += command_words[i] + " ";
		}
		target_1_name = target_1_name.trim();
		target_2_name = target_2_name.trim();
		Item target_1 = current_room.findItem(target_1_name);
		Item target_2 = current_room.findItem(target_2_name);
		if(target_1 == null){
			say("You look around the room but you can't seem to find a " + target_1_name + " :(");
			return;
		}
		if(target_2 == null){
			say("You look around the room but you can't seem to find a " + target_2_name + " :(");
			return;
		}
		target_1.useWith(target_2);
	}
	
	public static void say(String message){
		System.out.println(message);
	}
	
	public static String ask(String question){
		System.out.println(question);
		return input_reader.nextLine();
	}
}
