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
	public void open(){
		if(locked){
			InteractionManager.say("You tug on the handle of the door of the wardrobe but it won't budge. Whatever maniac locked you in "
		                         + "here probably locked it.");
		}
		else if (!locked && !open){
			InteractionManager.say("You tug on the handle swings open and you see inside "); // NEEDS MORE DECRIPTION ABOUT DRESS AND SUCH
			open = false;
		}
		else if(!locked && open){
			InteractionManager.say("Emm, it's already open...?");
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
