package escape;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

import escape.items.Item;
import escape.rooms.Bedroom;
import escape.rooms.Room;

public class InteractionManager{
	
	static ArrayList<Item> inventory = new ArrayList<Item>();
	
	static ArrayList<Room> rooms = new ArrayList<Room>();
	static Room current_room;
	
	static Scanner input_reader = new Scanner(System.in);
	
	public static void initialise(){
		rooms.add(new Bedroom());
		current_room = rooms.get(0);
	}
	
	public static void addItemToInventory(Item item){
		inventory.add(item);
		current_room.removeItem(item);
	}

	public static Item findInventoryItem(String target_name){
		for(int i = 0; i < inventory.size(); i++){
			if(inventory.get(i).getName().equals(target_name)){
				return inventory.get(i);
			}
		}
		return null;
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
		if(command_words[0].equals("look") || command_words[0].equals("investigate")){
			handleLookCommand(command_words);
		}
		else if(command_words[0].equals("use")){
			handleUseCommand(command_words);
		}
		else if(command_words[0].equals("pick")){
			handlePickUpCommand(command_words);
		}
		else if(command_words[0].equals("open")){
			handleOpenCommand(command_words);
		}
		else if(command_words[0].equals("close")){
			handleCloseCommand(command_words);
		}
		else if(command_words[0].equals("exit")){
			System.exit(0);
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
		if(target == null){
			target = findInventoryItem(target_name);
			if(target == null){
				say("You look around the room and fish around your pockets but you can't seem to find a " + target_name + " :(");
				return;
			}
		}
		target.lookAt();
	}
	
	static void handleUseCommand(String[] command_words){
		String target_name = "";
		for(int i = 1; i < command_words.length; i++){
			if(!command_words[i].equals("with") && !command_words[i].equals("on")){
				target_name += command_words[i] + " ";
			}
			else{
				handleUseWithCommand(command_words, target_name, i);
				return;
			}
		}
		target_name = target_name.trim();
		Item target = current_room.findItem(target_name);
		if(target == null){
			target = findInventoryItem(target_name);
			if(target == null){
				say("You look around the room and fish around your pockets but you can't seem to find a " + target_name + " :(");
				return;
			}
		}
		target.use();
	}
	
	static void handleUseWithCommand(String[] command_words, String target_1_name, int index_of_with){
		String target_2_name = "";
		for(int i = index_of_with+1; i < command_words.length; i++){
			target_2_name += command_words[i] + " ";
		}
		target_1_name = target_1_name.trim();
		target_2_name = target_2_name.trim();
		Item target_1 = findInventoryItem(target_1_name);
		Item target_2 = current_room.findItem(target_2_name);
		if(target_1 == null){
			say("You fish around in your pockets but you can't seem to find a " + target_1_name + " :(");
			return;
		}
		if(target_2 == null){
			say("You look around the room but you can't seem to find a " + target_2_name + " :(");
			return;
		}
		target_2.useWith(target_1);
	}
	
	static void handlePickUpCommand(String[] command_words){
		String target_name = "";
		for(int i = 1; i < command_words.length; i++){
			if(!command_words[i].equals("up")){
				target_name += command_words[i] + " ";
			}
		}
		target_name = target_name.trim();
		Item target = current_room.findItem(target_name);
		if(target != null){
			target.pickUp();
		}
		else{
			say("You look around the room but you can't seem to find a " + target_name + " :(");
		}
	}
	
	static void handleOpenCommand(String[] command_words){
		String target_name = "";
		for(int i = 1; i < command_words.length; i++){
			target_name += command_words[i] + " ";
		}
		target_name = target_name.trim();
		Item target = current_room.findItem(target_name);
		if(target != null){
			target.open();
		}
		else{
			say("You look around the room but you can't seem to find a " + target_name + " :(");
		}
	}
	
	static void handleCloseCommand(String[] command_words){
		String target_name = "";
		for(int i = 1; i < command_words.length; i++){
			target_name += command_words[i] + " ";
		}
		target_name = target_name.trim();
		Item target = current_room.findItem(target_name);
		if(target != null){
			target.close();
		}
		else{
			say("You look around the room but you can't seem to find a " + target_name + " :(");
		}
	}
	
	public static void say(String message){
		System.out.println(WordWrapper.wordWrap(message, 100));
	}
	
	public static void sayBox(String message){
		System.out.println(WordWrapper.drawBox(message, 100));
	}
	
	public static String ask(String question){
		say(question);
		return input_reader.nextLine();
	}
}
