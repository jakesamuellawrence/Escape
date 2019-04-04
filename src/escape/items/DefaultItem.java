package escape.items;

import escape.TextManager;

public class DefaultItem implements Interacteable{
	
	String name = "Default Item.";
	String description = "Errrm. You shouldn't really be creating instances of this. Go fix your code, bud.";

	@Override
	public void lookAt(){
		TextManager.say("It's a " + name + ". There's not really much else to say about it.");
	}

	@Override
	public void use(){
		TextManager.say("You poke the " + name + ". Not much happens");
	}

	@Override
	public void useWith(Interacteable target){
		TextManager.say("You poke the " + name + " with the "
				      + target.getName() + ". Not much happens.");
	}
	
	@Override
	public void pickUp(){
		TextManager.say("Really? You thought you could pick up an entire "
				      + name + "? You're not Guybrush Threepwood. Try something else");
	}

	@Override
	public String getName(){
		return name;
	}

	@Override
	public String getDescription(){
		return description;
	}
}
