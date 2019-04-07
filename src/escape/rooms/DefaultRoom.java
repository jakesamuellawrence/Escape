package escape.rooms;

import java.util.ArrayList;

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
	public String getName(){
		return name;
	}
	
	@Override
	public String getDescription(){
		String description = "";
		for(int i = 0; i < items.size(); i++){
			description += items.get(i).getDescription() + "\n";
		}
		return description;
	}
}
