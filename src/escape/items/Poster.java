package escape.items;

import escape.InteractionManager;

public class Poster extends DefaultItem{
	
	boolean on_wall = true;

	public Poster(){
		name = "poster";
		description = "A POSTER for some kind of romance novel hanging on the wall";
	}
	
	@Override
	public void lookAt(){
		if(on_wall){
			InteractionManager.say("You look closer at the poster, and notice it seems to be for some kind of romance novel about vampires. "
		             + "The words 'Glampires: Love at first bite' are scrawled across the top in beautiful flowing letters. "
		             + "The tagline at the bottom reads 'Damien had stolen the key to my heart. I had to get it back'. "
		             + "Upon getting even closer, you notice the bottom right corner is curled up the way slightly instead of "
		             + "lying flat. ");
		}
		else{
			InteractionManager.say("You read the message written on the back of the poster: ");
			InteractionManager.say("To unlock my heart,");
			InteractionManager.say("you must choose our special date");
			InteractionManager.say("Between January and June,");
			InteractionManager.say("this day entwined our fate");
		}
	}
	
	@Override
	public void pickUp(){
		if(on_wall){
			InteractionManager.say("You pull the poster down off the wall, revealing a small "
					             + "SAFE built into the wall behind it. Unsure what to do with the poster, "
					             + "you lay it on the floor. You lay it face-down, and notice "
					             + "a message written on the back: ");
			InteractionManager.say("To unlock my heart,");
			InteractionManager.say("you must choose our special date");
			InteractionManager.say("Between January and June,");
			InteractionManager.say("this day entwined our fate");
			InteractionManager.getCurrentRoom().addItem(new Safe());
			on_wall = false;
			description = "a POSTER for some kind of romance novel lying on the floor";
		}
		else{
			InteractionManager.say("You look at the poster laying on the floor, and decide there's not really much "
					             + "point in picking it up. It probably wouldn't fit in your pockets anyway.");
		}
	}
	
}
