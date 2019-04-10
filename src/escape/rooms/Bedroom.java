package escape.rooms;

import java.util.ArrayList;

import escape.items.Item;
import escape.items.OrnateChest;
import escape.items.Poster;
import escape.items.Wardrobe;

public class Bedroom extends DefaultRoom{
	
	public Bedroom(){
		name = "Bedroom";
		items = new ArrayList<Item>();
		items.add(new Wardrobe());
		items.add(new Poster());
		items.add(new OrnateChest());
	}
	
}
