package escape.items;

import escape.InteractionManager;

public class Wardrobe extends DefaultItem{
	
	private boolean open = false;
	private boolean locked = true;
	
	public Wardrobe(){
		name = "wardrobe";
		description = "an old-looking wooden WARDROBE";
	}
	
	@Override
	public void lookAt(){
		InteractionManager.say("The wardrobe is old looking and shoddy, yet somehow also "
							 + "exquisitely beautiful. It gives you the feeling of looking at "
							 + "some kind of archaic and enchanted artifact. Looking closer, "
				             + "you see a strange keyhole in the shape of a loveheart.");
	}
	
	@Override
	public void useWith(Item item){
		if(item instanceof HeartKey){
			if(!open){
				if(locked){
					locked = false;
					InteractionManager.say("You slide the key in and twist. After a moment you hear a clunk from within the door. "
							             + "It should be unlocked now.");
				}
				else if(!locked){
					locked = true;
					InteractionManager.say("You slide the key in and twist. After a moment you hear a clunk from within the door. "
							             + "It should be locked now.");
				}
			}
			else if(open){
				InteractionManager.say("You realise there's not much use using a key on something that's open...");
			}
		}
		else{
			InteractionManager.say("You can't see anywhere you'd be able to use the " + item.getName());
		}
	}
	
	@Override
	public void open(){
		if(!open){
			if(locked){
				InteractionManager.say("You tug on the handle of the wardrobe, but it just won't budge. You reckon it's probably locked.");
			}
			else if(!locked){
				InteractionManager.say("You tug on the handle of the wardrobe, and it swings open. You peer inside and release a "
						             + "quick gasp. Before you you see the most beautiful DRESS you've ever seen. It's not particularly "
						             + "fancy, and to be honest it's somewhat plain, but something about it just enthralls you immediately.");
				InteractionManager.getCurrentRoom().addItem(new Dress());
				open = true;
			}
		}
		else if(open){
			InteractionManager.say("It's already open...");
		}
	}
	
	@Override
	public void close(){
		if(open){
			InteractionManager.say("You swing the large wooden doors shut and they come together with a clack");
			InteractionManager.getCurrentRoom().removeItem(InteractionManager.getCurrentRoom().findItem("dress"));
			open = false;
		}
		else if(!open){
			InteractionManager.say("Emm, it's already closed...");
		}
	}
}
