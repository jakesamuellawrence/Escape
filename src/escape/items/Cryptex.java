package escape.items;

import escape.InteractionManager;

public class Cryptex extends DefaultItem{

	public Cryptex(){
		name = "cryptex";
		description = "a golden 5-ringed CRYPTEX, lying in an ornate chest";
	}
	
	@Override
	public void lookAt(){
		InteractionManager.say("The cryptex is a long wide cylinder, consisting of two end pieces and 5 rings with 26 letters on them each. "
							 + "The two end pieces both have arrows on them, and you're pretty sure that if you rotate the rings so that they "
							 + "spell a word along the line of the arrows, you'll be able to open the cryptex and see what's inside. The rings "
							 + "themesleves are edged with shining gold, and like everything else in the room, are exquisitely beautiful.");
	}
	
	@Override
	public void pickUp(){
		InteractionManager.say("You grab the cryptex and squeeze it into your pockets");
		InteractionManager.addItemToInventory(this);
	}
	
	@Override
	public void open(){
		use();
	}
	
	@Override
	public void use(){
		InteractionManager.say("You're pretty sure to be able to open this thing you're going to have to align the rings so that they spell a "
							 + "word. ");
		String word = InteractionManager.ask("What word do you want to try").toLowerCase();
		if(word.length() > 5){
			InteractionManager.say("You start aligning the rings to spell " + word + " but then realise that it has too many letters");
			return;
		}
		else if(word.length() < 5){
			InteractionManager.say("You start aligning the rings to spell " + word + " but then realise that it doesn't have enough letters");
			return;
		}
		if(word.equals("yummy")){
			InteractionManager.say("You align the rings to spell out '" + word + "'. You pull on the cap, and it slides away, revealing "
					             + "the hollow insides of the cryptex and a curled up scroll of paper inside. You reach in and grab the piece "
					             + "of paper, eager to finally find out what this has all been about. You unfurl it, and it reads:");
			String choice = InteractionManager.askBoxed("Would you like to go to prom with me?");
			if(choice.toLowerCase().contains("yes")){
				InteractionManager.say("The words fade from the scroll of paper, and are soon replaced by new ones:");
				InteractionManager.say("FUCKING SUPERB GO TELL ME ABOUT IT");
			}
			else if(choice.toLowerCase().contains("no")){
				InteractionManager.say("The words fade away on the scroll of paper. They are replaced by new ones:");
				InteractionManager.say("THEN PERISH, HARLOT!");
				InteractionManager.say("The room turns red. Flames begin to spring up around you. You feel a weight in your "
									 + "chest like you're being dragged down into some fiery abyss.");
				while(true){
					InteractionManager.ask("What would you like to do?");
					InteractionManager.say("You suffer.");
				}
			}
		}
		else{
			InteractionManager.say("You align the rings to spell '" + word + "'. You pull on the cap, but it doesn't budge.");
		}
	}
	
}
