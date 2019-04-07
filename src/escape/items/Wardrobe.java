package escape.items;

import escape.InteractionManager;

public class Wardrobe extends DefaultItem{
	
	public Wardrobe(){
		name = "wardrobe";
		description = "an old-looking wooden wardrobe";
	}
	
	@Override
	public void lookAt(){
		InteractionManager.say("You investigate the wardrobe further, and immediately notice it seems to be made of a deep red mahoganny. "
				             + "Whomever locked you in this room clearly has expensive tastes. Looking at the door, "
				             + "you see a strangely shaped keyhole, and next to it the words 'Open me ;)' scrawled on a note");
	}
	
	@Override
	public void open(){
		InteractionManager.say("You tug on the handle of the door of the wardrobe but it won't budge. Whatever maniac locked you in "
				             + "here probably locked it.");
	}
}
