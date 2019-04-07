package escape.items;

import escape.InteractionManager;

public class DefaultItem implements Item{
	
	String name = "Default Item.";
	String description = "Errrm. You shouldn't really be creating instances of this. Go fix your code, bud.";

	@Override
	public void lookAt(){
		InteractionManager.say("It's a " + name + ". There's not really much else to say about it.");
	}

	@Override
	public void use(){
		InteractionManager.say("You poke the " + name + ". Not much happens");
	}

	@Override
	public void useWith(Item target){
		InteractionManager.say("You poke the " + name + " with the "
				      + target.getName() + ". Not much happens.");
	}
	
	@Override
	public void pickUp(){
		InteractionManager.say("Really? You thought you could pick up an entire "
				      + name + "? You're not Guybrush Threepwood. Try something else");
	}	

	@Override
	public void open(){
		InteractionManager.say("You pull on pretty much every part of the " + name + " but you cannot find a way to 'open' it");
	}

	@Override
	public void close(){
		InteractionManager.say("You're not even really sure what closing would mean when it comes to this object.");
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
