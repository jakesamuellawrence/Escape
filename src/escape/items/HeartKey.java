package escape.items;

import escape.InteractionManager;

public class HeartKey extends DefaultItem{

	public HeartKey(){
		name = "heart shaped key";
		description = "a long HEART SHAPED KEY, sitting in an open SAFE.";
	}
	
	@Override
	public void lookAt(){
		InteractionManager.say("You turn the key over in your hands. The handle is in the shape of a heart, with an M embossed in the centre "
				             + "of it. At the tip of the blade is another metallic heart-shaped piece of metal, perpendicular to the blade "
				             + "itself. It looks like this would only fit into a very unusual lock.");
	}
	
	@Override
	public void pickUp(){
		InteractionManager.say("You grab the key and slip it into your pocket");
		InteractionManager.addItemToInventory(this);
	}
	
}
