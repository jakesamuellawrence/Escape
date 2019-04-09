package escape.rooms;

import java.util.ArrayList;

import escape.items.Item;

public interface Room{
	
	public Item findItem(String target_name);
	public void addItem(Item item);
	public void removeItem(Item item);
	public void describeRoom();
	
	public String getName();
}
