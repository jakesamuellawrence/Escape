package escape.rooms;

import java.util.ArrayList;

import escape.items.Item;
import escape.items.Wardrobe;

public class Bedroom extends DefaultRoom{
	
	public Bedroom(){
		name = "Bedroom";
		items = new ArrayList<Item>();
		items.add(new Wardrobe());
	}
	
}
