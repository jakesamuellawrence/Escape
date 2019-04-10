package escape.rooms;

import java.util.ArrayList;

import escape.InteractionManager;
import escape.items.Item;

public class DefaultRoom implements Room{
	
	String name = "Default Room";
	
	ArrayList<Item> items = new ArrayList<Item>();

	@Override
	public Item findItem(String target_name){
		for(int i = 0; i < items.size(); i++){
			if(items.get(i).getName().equals(target_name)){
				return items.get(i);
			}
		}
		return null;
	}

	@Override
	public void addItem(Item item){
		items.add(item);
	}

	@Override
	public void removeItem(Item item){
		items.remove(item);
	}
	
	@Override
	public void describeRoom(){
		InteractionManager.say("Looking around the room, you see: ");
		for(int i = 0; i < items.size(); i++){
			InteractionManager.say(" - " + items.get(i).getDescription());
		}
	}

	@Override
	public String getName(){
		return name;
	}
}
