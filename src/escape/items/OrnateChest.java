package escape.items;

import escape.InteractionManager;

public class OrnateChest extends DefaultItem{
	
	boolean open = false;
	
	public OrnateChest(){
		name = "ornate chest";
		description = "a beautiful ORNATE CHEST sitting on a desk in the corner of the room";
	}
	
	@Override
	public void lookAt(){
		if(!open){
			InteractionManager.say("The chest itself is made of a beautiful silver, with patterns embossed all over the "
					 			 + "box. It carries the feeling that whatever is stored inside this box, it must be very "
					 			 + "important. You notice that on the front, at the seam where the lid meets the body "
					 			 + "of the box, there is a an inset loveheart insignia which seems to be what's holding the box "
					 			 + "shut. ");
		}
		else{
			InteractionManager.say("You read the note attached to the lid:");
			InteractionManager.say("Pick our special word, ");
			InteractionManager.say("or my secrets you will miss.");
			InteractionManager.say("This cryptex was Pavloved, ");
			InteractionManager.say("and sealed with a kiss");
		}
	}
	
	@Override
	public void open(){
		if(!open){
			InteractionManager.say("You tug on the lid but it does not seem to want to open.");	
		}
		else{
			InteractionManager.say("It's already open...");
		}
	}
	
	@Override
	public void useWith(Item item){
		if(item instanceof SignetRing){
			if(!open){
				InteractionManager.say("You slide the ring onto your finger. It's a perfect fit. You place the embossed insignia on the ring "
						 			 + "against the inset insignia on the chest, and twist your hand. The insiginia on the chets rotates with "
						 			 + "your hand, and the lid springs open. Inside, you see golden five-ringed CRYPTEX. "
						 			 + "On the lid of the box you find a note:");
				InteractionManager.say("Pick our special word, ");
				InteractionManager.say("or my secrets you will miss.");
				InteractionManager.say("This cryptex was Pavloved, ");
				InteractionManager.say("and sealed with a kiss");
				open = true;
			}
			else{
				InteractionManager.say("It's already open, using the ring won't do anything");
			}
		}
	}
	
	@Override
	public void close(){
		if(open){
			InteractionManager.say("You try to push the lid closed but it's seems to be connected to a very strong spring. "
					 			 + "No matter how hard you try you cannot close it.");
		}
		else{
			InteractionManager.say("Its already closed...");
		}
	}

}
