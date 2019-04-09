package escape.items;

import escape.InteractionManager;

public class Safe extends DefaultItem{
	
	boolean open = false;

	public Safe(){
		name = "safe";
		description = "a SAFE built into the wall";
	}
	
	@Override
	public void lookAt(){
		InteractionManager.say("You look at the safe. There's a small display and a keypad to one side of the safe, which you reckon "
				             + "you'd probably have to enter the keycode with.");
	}
	
	@Override
	public void open(){
		if(!open){
			InteractionManager.say("You tug on the door but it's locked. Seeing the numberpad next to the door, you realise "
					             + "you're probably going to have to find the right keycode to unlock it.");
			String combination = InteractionManager.ask("What combination do you want to enter?");
			if(combination.equals("1803")){
				open = true;
				InteractionManager.say("You enter the code and the display flashes green. After a moment, "
						             + "you here a click and the door swings open, revealing a strange "
						             + "HEART-SHAPED KEY sitting in the centre of the safe.");
				InteractionManager.getCurrentRoom().addItem(new HeartKey());
			}
			else{
				InteractionManager.say("You enter the code and the the display flashes red. Looks like you "
						             + "didn't enter the right code.");
			}
		}
		else{
			InteractionManager.say("It's already open...");
		}
	}
	
	@Override
	public void close(){
		if(open){
			InteractionManager.say("You push on the door of the safe and it swings shut with a thud.");
			InteractionManager.getCurrentRoom().removeItem(InteractionManager.getCurrentRoom().findItem("heart-shaped key"));
			open = false;
		}
	}
	
	@Override
	public void pickUp(){
		InteractionManager.say("It's built into the wall...");
	}
	
}
