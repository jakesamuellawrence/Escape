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
		InteractionManager.say("You investigate the wardrobe further, and notice it seems to be made of a deep red mahoganny. "
				             + "Whomever locked you in this room clearly has expensive tastes. Looking at the door, "
				             + "you see a strangely shaped keyhole, and next to it the words 'Open me ;)' scrawled on a note");
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
	}
	
	@Override
	public void open(){
		if(!open){
			if(locked){
				InteractionManager.say("You tug on the handle of the wardrobe, but it just won't budge");
			}
			else if(!locked){
				InteractionManager.say("You tug on the handle of the wardrobe, and it swings open. You peer inside and release a "
						             + "quick gasp. Before you you see a D I C K B U T T");
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
			InteractionManager.say("You swing the large mahoganny doors shut and they come together with a clack");
			open = false;
		}
		else if(!open){
			InteractionManager.say("Emm, it's already closed...");
		}
	}
}
